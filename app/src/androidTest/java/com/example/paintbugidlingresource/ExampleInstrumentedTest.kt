package com.example.paintbugidlingresource

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
open class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun createObjectiveAddExpertsToTheObjective() {
        composeTestRule.apply{
            waitUntil(10_000L) {
                onAllNodes(hasTestTag("BUTTON"), true).fetchSemanticsNodes().size > 1
            }
            onAllNodesWithTag("BUTTON")[0].performClick()
        }

    }
}
