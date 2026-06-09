package com.example.pruebasunitarias_avanzadas.test

import com.example.pruebasunitarias_avanzadas.data.model.Tarea
import com.example.pruebasunitarias_avanzadas.data.repository.RepositorioTareas
import com.example.pruebasunitarias_avanzadas.ui.screens.PantallaTareas
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test


/**
 * Pruebas unitarias para validar el correcto funcionamiento
 * de la lógica de negocio implementada en RepositorioTareas.
 */
class RepositorioTareasTest {

    private lateinit var repositorio: RepositorioTareas

    //inicaliza un repositorio limpio antes de cada prueba
    @Before
    fun configurar(){
        repositorio = RepositorioTareas()
    }

    //se verifica que al agregar una tarea, la cantidad total aumenta en 1
    @Test
    fun verificarAgregarTarea() {

        repositorio.agregarTarea(
            Tarea(
                id = 1,
                titulo = "Comprar leche",
                descripcion = "Comprar leche en el supermercado",
                completada = false
            )
        )
        assertEquals(1, repositorio.obtenerTodasLasTareas().size)
    }

    //se verrifica que una tarea se elimine correctamente
    @Test
    fun verificarEliminarTarea() {

        repositorio.agregarTarea(
            Tarea(
                id = 1,
                titulo = "Comprar leche",
                descripcion = "Comprar leche en el supermercado",
                completada = false
            )
        )
        repositorio.eliminarTarea(1)
        assertEquals(0, repositorio.obtenerTodasLasTareas().size)
    }

    //se verifica que una tarea cambie su estado de pendiente a completada
    @Test
    fun verificarCompletarTarea(){
        repositorio.agregarTarea(
            Tarea(
                id = 1,
                titulo = "Comprar leche",
                descripcion = "Comprar leche en el supermercado",
                completada = false
            )
        )
        repositorio.marcarComoCompletada(1)
        val tarea = repositorio.obtenerTodasLasTareas().firstOrNull { it.id == 1 }
        assertEquals(true, tarea?.completada)
    }

    //verifica que el conteo de tareas pendientes, retorne la cantidad correcta
    @Test
    fun verificarConteoPendienes(){
        repositorio.agregarTarea(
            Tarea(
                id = 1,
                titulo = "Comprar leche",
                descripcion = "Comprar leche en el supermercado",
                completada = false
            )
        )
        repositorio.agregarTarea(
            Tarea(
                id = 2,
                titulo = "Lavar ropa",
                descripcion = "Lavar la ropa sucia",
                completada = false
            )
        )
        repositorio.agregarTarea(
            Tarea(
                id = 3,
                titulo = "Pagar facturas",
                descripcion = "Pagar las facturas de servicios",
                completada = true
            )
        )

        assertEquals(2, repositorio.contarTareasPendientes())
    }

    //verifica que una lista vacia retorne cero tareas pendientes
    @Test
    fun verificarListaVacia() {
        assertEquals(0, repositorio.contarTareasPendientes())
    }

    //verificar filtro de completadas
    @Test
    fun verificarObtenerTareasCompletadas() {

        repositorio.agregarTarea(
            Tarea(1, "Tarea 1", "", true)
        )

        repositorio.agregarTarea(
            Tarea(2, "Tarea 2", "", false)
        )

        assertEquals(
            1,
            repositorio.obtenerTareasCompletadas().size
        )
    }

    //verificar orden alfabético
    @Test
    fun verificarOrdenAlfabetico() {

        repositorio.agregarTarea(
            Tarea(1, "Zanahoria", "", false)
        )

        repositorio.agregarTarea(
            Tarea(2, "Banano", "", false)
        )

        repositorio.agregarTarea(
            Tarea(3, "Arroz", "", false)
        )

        val tareasOrdenadas =
            repositorio.obtenerTareasOrdenadas()

        assertEquals(
            "Arroz",
            tareasOrdenadas[0].titulo
        )
    }

    //validar porcentaje de tareas completadas
    @Test
    fun verificarPorcentajeCompletadas() {

        repositorio.agregarTarea(
            Tarea(1, "Tarea 1", "", true)
        )

        repositorio.agregarTarea(
            Tarea(2, "Tarea 2", "", false)
        )

        repositorio.agregarTarea(
            Tarea(3, "Tarea 3", "", true)
        )

        assertEquals(
            66,
            repositorio.porcentajeCompletadas()
        )
    }

    //validar porcentaje con lista vacia
    @Test
    fun verificarPorcentajeListaVacia() {

        assertEquals(
            0,
            repositorio.porcentajeCompletadas()
        )
    }

    //prueba fallida intencional
    @Test
    fun pruebaNegativa_conteoPendientesIncorrecto() {

        repositorio.agregarTarea(
            Tarea(1, "Comprar leche", "", false)
        )

        repositorio.agregarTarea(
            Tarea(2, "Lavar ropa", "", false)
        )

        assertEquals(3, repositorio.contarTareasPendientes())
    }
}