package com.example.practicasunitariascalculadora

import com.example.practicasunitariascalculadora.models.Calculadora
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Test

class CalculadoraTest {

    private val calculadora = Calculadora()

    @Test
    fun verificarSuma() {                                                     //delta:margen de error permitido
        assertEquals(8.0, calculadora.sumar(5.0, 3.0), 0.001) //"La prueba pasa si el resultado está entre 7.999 y 8.001"
    }

    @Test
    fun verificarResta() {
        assertEquals(2.0, calculadora.restar(5.0, 3.0), 0.001)
    }

    @Test
    fun verificarMultiplicacion() {
        assertEquals(15.0, calculadora.multiplicar(5.0, 3.0), 0.001)
    }

    @Test
    fun verificarDivision() {
        assertEquals(1.666, calculadora.dividir(5.0, 3.0), 0.001)
    }

    @Test
    fun verificarNumerosNegativos() {
        assertEquals(-8.00, calculadora.sumar(-5.00, -3.00))
    }

    @Test
    fun verificarRestaConNegativos() {
        assertEquals(-2.00, calculadora.restar(-5.00, -3.00))
    }

    // Prueba para fallar intencionalmente
    @Test
    fun pruebaFallida() {
        assertEquals(10.00, calculadora.sumar(5.00, 3.00))
    }}