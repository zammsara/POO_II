/**
 * Project: Sesion03
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 17:44
 * All rights reserved 2026.*/

interface calculadora{

    fun sumar(num1: Int, num2: Int): Int

    fun restar(num1: Int, num2: Int): Int

    fun multiplicar(num1: Int, num2: Int): Int

    fun dividir(num1: Double, num2: Double): Double
}

class MiCalculadora : calculadora{
    override fun sumar(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    override fun restar(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    override fun multiplicar(num1: Int, num2: Int): Int {
        return num1 * num2
    }

    override fun dividir(num1: Double, num2: Double): Double {
        return num1 / num2
    }

}

fun main(){
    val miCalculadora = MiCalculadora()
    println(miCalculadora.sumar(10, 20))
    println(miCalculadora.restar(10, 20))
    println(miCalculadora.multiplicar(10, 20))
    println(miCalculadora.dividir(10.0, 20.0))

}