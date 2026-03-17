/**
 * Project: Ejercicio07-InterfacesVehiculo
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:17
 * All rights reserved 2026.*/

class Motocicleta : Vehiculo {
    override fun mover(motivo: String): String {
        return "Se solicita mover la motocicleta por el siguiente motivo:\n$motivo"
    }
}