package com.example.pruebasunitarias_avanzadas.data.repository

import com.example.pruebasunitarias_avanzadas.data.model.Tarea

class RepositorioTareas {

    private val tareas = mutableListOf<Tarea>()

    fun agregarTarea(tarea: Tarea) {
        tareas.add(tarea)
    }

    fun eliminarTarea(id: Int) {
        tareas.removeAll { it.id == id }
    }

    fun marcarComoCompletada(id: Int) {
        val indice = tareas.indexOfFirst { it.id == id }

        if (indice != -1) {
            tareas[indice] = tareas[indice].copy(
                completada = true
            )
        }
    }

    fun obtenerTodasLasTareas(): List<Tarea> {
        return tareas.toList()
    }

    fun obtenerTareasPendientes(): List<Tarea> {
        return tareas.filter { !it.completada }
    }

    fun contarTareasPendientes(): Int {
        return tareas.count { !it.completada }
    }

    //actividades complementarias
    fun obtenerTareasCompletadas(): List<Tarea> {
        return tareas.filter { it.completada }
    }

    fun obtenerTareasOrdenadas(): List<Tarea> {
        return tareas.sortedBy { it.titulo.lowercase() }
    }

    fun porcentajeCompletadas(): Int {

        if (tareas.isEmpty()) return 0

        return (tareas.count { it.completada } * 100) / tareas.size
    }
}