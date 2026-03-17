/**
 * Project: Ejercicio05-SistemaBanco
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 12:21
 * All rights reserved 2026.*/

//Clase
class CuentaBancaria (private val numeroCuenta : Int,
                      private var saldo : Double)
{
    fun getNumeroCuenta(): Int {
        return numeroCuenta
    }

    fun getSaldo() : Double {
        return saldo
    }

    //Metodos
    fun depositar(monto : Double){

        if (saldo > 0.0) {
            saldo += monto
            println("Depósito de $$monto realizado correctamente.")
        } else {
            println("El monto a depositar debe de ser mayor que 0.")
        }
    }

    fun retirar(monto : Double){

        if (monto <= saldo) {
            saldo -= monto
            println("Retiro de $monto realizado correctamente.")
        } else {
            println("Fondos insuficientes.")
        }
    }

    fun consultarSaldo(){
        println("\nTu saldo disponible es $$saldo")
    }

}

