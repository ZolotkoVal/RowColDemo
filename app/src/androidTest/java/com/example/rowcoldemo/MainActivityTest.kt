package com.example.rowcoldemo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule val compose = createAndroidComposeRule<MainActivity>()

    @Test fun activityShowsFinalCellsBelowTopInset() {
        listOf("1", "2", "3").forEach { compose.onNodeWithText(it).assertIsDisplayed() }
        val top = compose.onNodeWithText("1").fetchSemanticsNode().boundsInRoot.top
        val inset = compose.runOnIdle {
            requireNotNull(ViewCompat.getRootWindowInsets(compose.activity.window.decorView))
                .getInsets(WindowInsetsCompat.Type.systemBars()).top
        }
        val expected = inset + with(compose.density) { 4.dp.toPx() }
        assertEquals("Scaffold must apply its top inset exactly once", expected, top, 2f)
    }
}
