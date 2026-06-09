package com.example.pruebasunitarias_avanzadas.test

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.pruebasunitarias_avanzadas.ui.screens.PantallaTareas
import org.junit.Rule
import org.junit.Test

class PantallaTareasTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun agregarTarea_apareceEnPantalla() {

        composeTestRule.setContent {
            PantallaTareas()
        }

        composeTestRule
            .onNodeWithText("Título de la tarea")
            .performTextInput("Comprar leche")

        composeTestRule
            .onNodeWithText("Agregar tarea")
            .performClick()

        composeTestRule
            .onNodeWithText("Comprar leche")
            .assertExists()
    }

    @Test
    fun botonAgregar_respondeAlClickCorrectamente() {

        composeTestRule.setContent {
            PantallaTareas()
        }

        composeTestRule
            .onNodeWithText("Título de la tarea")
            .performTextInput("Estudiar Compose")

        composeTestRule
            .onNodeWithText("Agregar tarea")
            .performClick()

        composeTestRule
            .onNodeWithText("Estudiar Compose")
            .assertExists()
    }

    @Test
    fun eliminarTarea_desapareceDeLaLista() {

        composeTestRule.setContent {
            PantallaTareas()
        }

        composeTestRule
            .onNodeWithText("Título de la tarea")
            .performTextInput("Tarea Temporal")

        composeTestRule
            .onNodeWithText("Agregar tarea")
            .performClick()

        composeTestRule
            .onNodeWithText("Tarea Temporal")
            .assertExists()

        composeTestRule
            .onNodeWithContentDescription("Eliminar")
            .performClick()

        composeTestRule
            .onNodeWithText("Tarea Temporal")
            .assertDoesNotExist()
    }

    @Test
    fun mostrarPendientes_cantidadCorrecta() {

        composeTestRule.setContent {
            PantallaTareas()
        }

        composeTestRule
            .onNodeWithText("Título de la tarea")
            .performTextInput("Pendiente")

        composeTestRule
            .onNodeWithText("Agregar tarea")
            .performClick()

        composeTestRule
            .onNodeWithText("1")
            .assertExists()
    }

    @Test
    fun campoEntrada_aceptaTextoCorrectamente() {

        composeTestRule.setContent {
            PantallaTareas()
        }

        composeTestRule
            .onNodeWithText("Título de la tarea")
            .performTextInput("Mi tarea")

        composeTestRule
            .onNodeWithText("Mi tarea")
            .assertExists()
    }

}