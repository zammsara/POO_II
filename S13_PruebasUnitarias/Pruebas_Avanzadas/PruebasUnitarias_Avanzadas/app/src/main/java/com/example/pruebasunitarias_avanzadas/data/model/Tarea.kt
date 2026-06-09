package com.example.pruebasunitarias_avanzadas.data.model

/**
 * Modelo que representa una tarea dentro de la aplicación.
 */
data class Tarea(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val completada: Boolean //pendiente, completada
)