/**
 * Project: Ejercicio07-InterfacesVehiculo
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:11
 * All rights reserved 2026.*/

fun main(){
    println("\n++++++++++++++++++++++++++++++++++++++++\n")
    val moverCamion = Camion()
    println(moverCamion.mover("Estorba en la entrada."))

    println("\n++++++++++++++++++++++++++++++++++++++++\n")
    val moverMoto = Motocicleta()
    println(moverMoto.mover("Estacionada en el lugar equivocado."))
}
