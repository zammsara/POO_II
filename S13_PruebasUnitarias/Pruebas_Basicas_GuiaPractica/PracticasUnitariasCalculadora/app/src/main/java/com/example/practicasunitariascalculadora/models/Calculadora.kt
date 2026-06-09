package com.example.practicasunitariascalculadora.models

class Calculadora {

    fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun dividir(a: Double, b: Double): Double {

        require(b != 0.0) {
            "No se puede dividir entre cero"
        }

        return a / b
    }
}