/**
 * Project: Ejercicio06-SistemaTaxis
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 12:59
 * All rights reserved 2026.*/

fun main(){
    val taxi1 = Taxi("M01 000 000", "Oscar Isaac", "TOYOTA COROLLA ")
    taxi1.iniciarServicio()

    val taxi2 = Taxi("002 0001 000", "Madz Mikkelsen", "HONDA CIVIC")
    taxi2.iniciarServicio()

    val taxi3 = Taxi("003 002 001", "Lee Pace", "TESLA MODEL 3")
    taxi3.iniciarServicio()
}