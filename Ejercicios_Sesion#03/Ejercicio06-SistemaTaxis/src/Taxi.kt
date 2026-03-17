/**
 * Project: Ejercicio06-SistemaTaxis
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 12:59
 * All rights reserved 2026.*/

class Taxi(val placa : String,
           val conductor :  String,
           val modelo : String)
{
    fun iniciarServicio(){
        println("\n+++++++++++++++++++++++++++++++++++++++++++")
        println("Tu servicio de taxi esta en camino.\n\nInformación del taxi: ")
        println(" Conductor: $conductor\n Modelo de auto: $modelo\n Placa: $placa\n")
    }

}