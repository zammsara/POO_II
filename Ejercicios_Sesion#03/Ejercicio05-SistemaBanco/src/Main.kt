/**
 * Project: Ejercicio05-SistemaBanco
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 12:47
 * All rights reserved 2026.*/

fun main(){
    val cuenta = CuentaBancaria(123456789, 500.0)

    println("\n================================\n")
    println("Cuenta: ${cuenta.getNumeroCuenta()}\nSaldo: $${cuenta.getSaldo()}")

    println("\n================================\n")
    cuenta.depositar(400.0)
    println("\n================================\n")
    cuenta.retirar(350.0)

    println("\n================================\n")
    cuenta.consultarSaldo()

}