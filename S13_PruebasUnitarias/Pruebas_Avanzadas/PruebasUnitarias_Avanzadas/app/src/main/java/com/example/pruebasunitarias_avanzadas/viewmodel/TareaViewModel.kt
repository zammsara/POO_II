package com.example.pruebasunitarias_avanzadas.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pruebasunitarias_avanzadas.data.model.Tarea
import com.example.pruebasunitarias_avanzadas.data.repository.RepositorioTareas

/**
 * ViewModel encargado de conectar la interfaz de usuario
 * con el repositorio de tareas.
 *
 * Responsabilidades:
 * - Gestionar el estado de la lista de tareas.
 * - Agregar tareas.
 * - Eliminar tareas.
 * - Marcar tareas como completadas.
 * - Mantener actualizado el contador de pendientes.
 */
class TareaViewModel : ViewModel() {

    private val repositorio = RepositorioTareas()

    var tareas by mutableStateOf<List<Tarea>>(emptyList())
        private set

    var cantidadPendientes by mutableStateOf(0)
        private set

    private var siguienteId = 1

    var porcentajeCompletadas by mutableStateOf(0)
        private set

    var filtroActual by mutableStateOf("Todas")
        private set


    fun agregarTarea(
        titulo: String,
        descripcion: String = ""
    ) {

        if (titulo.isBlank()) return

        repositorio.agregarTarea(
            Tarea(
                id = siguienteId++,
                titulo = titulo,
                descripcion = descripcion,
                completada = false
            )
        )

        actualizarEstado()
    }


    fun eliminarTarea(id: Int) {

        repositorio.eliminarTarea(id)

        actualizarEstado()
    }


    fun marcarComoCompletada(id: Int) {

        repositorio.marcarComoCompletada(id)

        actualizarEstado()
    }


    private fun actualizarEstado() {

        tareas = when (filtroActual) {

            "Pendientes" ->
                repositorio.obtenerTareasPendientes()

            "Completadas" ->
                repositorio.obtenerTareasCompletadas()

            else ->
                repositorio.obtenerTodasLasTareas()
        }

        cantidadPendientes =
            repositorio.contarTareasPendientes()

        porcentajeCompletadas =
            repositorio.porcentajeCompletadas()
    }

    fun mostrarTodas() {
        filtroActual = "Todas"
        actualizarEstado()
    }

    fun mostrarPendientes() {
        filtroActual = "Pendientes"
        actualizarEstado()
    }

    fun mostrarCompletadas() {
        filtroActual = "Completadas"
        actualizarEstado()
    }

    fun ordenarAlfabeticamente() {
        tareas = repositorio.obtenerTareasOrdenadas()
    }
}