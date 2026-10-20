
package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // go to drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // check drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverNameInput")
            .performTextInput("Lewis Hamilton")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // check driver appears
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        // clear drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // check driver is removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        // return home
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // check home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
