package com.example.practicasunitariascalculadora

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.practicasunitariascalculadora.screens.PantallaCalculadora
import org.junit.Rule
import org.junit.Test

class PantallaCalculadoraTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verificarBotonSumaYResultado() {

        composeTestRule.setContent {
            PantallaCalculadora()
        }

        composeTestRule
            .onNodeWithText("Sumar")
            .performClick()

        composeTestRule
            .onNodeWithTag("resultado")
            .assertTextEquals("8")
    }

    @Test
    fun verificarBotonRestaYResultado() {

        composeTestRule.setContent {
            PantallaCalculadora()
        }

        composeTestRule
            .onNodeWithText("Restar")
            .performClick()

        composeTestRule
            .onNodeWithTag("resultado")
            .assertTextEquals("2")
    }
}