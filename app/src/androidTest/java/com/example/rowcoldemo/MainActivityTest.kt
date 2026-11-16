package com.example.rowcoldemo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule val compose = createAndroidComposeRule<MainActivity>()

    @Test fun activityShowsFinalCellsBelowTopInset() {
        listOf("1", "2", "3").forEach { compose.onNodeWithText(it).assertIsDisplayed() }
        val top = compose.onNodeWithText("1").fetchSemanticsNode().boundsInRoot.top
        assertTrue("Scaffold must retain the status-bar inset", top > 0f)
    }
}
