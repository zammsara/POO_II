/**
 * Project: Ejercicio07-InterfacesVehiculo
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:14
 * All rights reserved 2026.*/

class Camion : Vehiculo {

    override fun mover(motivo: String): String {
        return "Deseamos mover el camion por el siguiente motivo:\n$motivo"
    }
}