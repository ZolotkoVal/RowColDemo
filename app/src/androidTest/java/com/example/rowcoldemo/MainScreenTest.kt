package com.example.rowcoldemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class MainScreenTest {
    @get:Rule val compose = createComposeRule()

    @Test fun finalCellsAreVisibleAndHorizontal() {
        compose.setContent { RowColDemoTheme { MainScreen() } }
        val cells = listOf("1", "2", "3").map {
            compose.onNodeWithText(it).assertIsDisplayed().fetchSemanticsNode().boundsInRoot
        }
        assertTrue(cells[0].right < cells[1].left)
        assertTrue(cells[1].right < cells[2].left)
        assertEquals(cells[0].top, cells[1].top, 1f)
        assertEquals(cells[1].top, cells[2].top, 1f)
    }

    @Test fun actualMeasuredWidthsFollowTwoFourThreeWeights() {
        compose.setContent { RowColDemoTheme { MainScreen(Modifier.width(360.dp)) } }
        val bounds = listOf("1", "2", "3").map {
            compose.onNodeWithText(it).fetchSemanticsNode().boundsInRoot
        }
        // Text semantics exclude the 4 dp margin on each side of the weighted slot.
        val margin = with(compose.density) { 8.dp.toPx() }
        val slots = bounds.map { it.width + margin }
        val total = slots.sum()
        listOf(2f, 4f, 3f).forEachIndexed { index, weight ->
            assertEquals(total * weight / 9f, slots[index], 2f)
        }
        assertEquals(bounds[0].left + slots[0], bounds[1].left, 2f)
        assertEquals(bounds[1].left + slots[1], bounds[2].left, 2f)
    }

    @Test fun mainScreenPreservesIncomingOffsetAndPaddingOnce() {
        compose.setContent {
            RowColDemoTheme {
                Box(Modifier.fillMaxSize()) {
                    MainScreen(Modifier.offset(x = 12.dp, y = 16.dp)
                        .width(300.dp).padding(start = 20.dp, top = 24.dp))
                }
            }
        }
        val first = compose.onNodeWithText("1").fetchSemanticsNode().boundsInRoot
        assertEquals(with(compose.density) { 36.dp.toPx() }, first.left, 2f)
        assertEquals(with(compose.density) { 44.dp.toPx() }, first.top, 2f)
    }

    @Test fun textCellDoesNotDuplicateIncomingModifier() {
        compose.setContent {
            RowColDemoTheme {
                Box(Modifier.fillMaxSize()) {
                    TextCell("X", Modifier.padding(start = 20.dp, top = 24.dp))
                }
            }
        }
        val cell = compose.onNodeWithText("X").fetchSemanticsNode().boundsInRoot
        assertEquals(with(compose.density) { 24.dp.toPx() }, cell.left, 2f)
        assertEquals(with(compose.density) { 28.dp.toPx() }, cell.top, 2f)
        assertEquals(with(compose.density) { 100.dp.toPx() }, cell.width, 2f)
    }
}
