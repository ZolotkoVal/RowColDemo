package com.example.rowcoldemo

import android.util.Log
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class BaselineDesignTest {
    @get:Rule val compose = createComposeRule()

    private fun layout(text: String): TextLayoutResult {
        val results = mutableListOf<TextLayoutResult>()
        compose.onNodeWithText(text).assertIsDisplayed()
            .performSemanticsAction(SemanticsActions.GetTextLayoutResult) { it(results) }
        return results.single()
    }

    private fun top(text: String) =
        compose.onNodeWithText(text).fetchSemanticsNode().boundsInRoot.top

    @Test fun paddingFromUses32SpAndPlacesBaselineAt80Dp() {
        compose.setContent { RowColDemoTheme { PaddingFromScreen() } }
        val small = layout("Small Text")
        assertEquals("Actual rendered Small Text size", 32.sp, small.layoutInput.style.fontSize)
        assertEquals("First baseline must be 80dp from row top",
            with(compose.density) { 80.dp.toPx() },
            top("Small Text") + small.firstBaseline, 1f)
    }

    @Test fun firstBaselineUses32SpAndAlignsToFirstLine() {
        compose.setContent { RowColDemoTheme { FirstBaselineScreen() } }
        val large = layout("Large Text\n\nMore Text")
        val small = layout("Small Text")
        assertEquals("Actual rendered Small Text size", 32.sp, small.layoutInput.style.fontSize)
        assertEquals("Small first baseline must equal large FIRST baseline",
            top("Large Text\n\nMore Text") + large.firstBaseline,
            top("Small Text") + small.firstBaseline, 1f)
    }

    @Test fun lastBaselineUses32SpAndAlignsToLastLine() {
        compose.setContent { RowColDemoTheme { LastBaselineScreen() } }
        val large = layout("Large Text\n\nMore Text")
        val small = layout("Small Text")
        Log.i("BaselineRegression", "last: small=${small.layoutInput.style.fontSize}, " +
            "largeFirst=${top("Large Text\n\nMore Text") + large.firstBaseline}, " +
            "largeLast=${top("Large Text\n\nMore Text") + large.lastBaseline}, " +
            "smallFirst=${top("Small Text") + small.firstBaseline}")
        assertEquals("Actual rendered Small Text size", 32.sp, small.layoutInput.style.fontSize)
        assertEquals(40.sp, large.layoutInput.style.fontSize)
        assertTrue("Large Text must remain multiline", large.lastBaseline > large.firstBaseline)
        assertEquals("Small first baseline must equal large LAST baseline",
            top("Large Text\n\nMore Text") + large.lastBaseline,
            top("Small Text") + small.firstBaseline, 1f)
    }
}
