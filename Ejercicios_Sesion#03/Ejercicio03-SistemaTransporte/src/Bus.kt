/**
 * Project: Ejercicio03-SistemaTransporte
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 21:34
 * All rights reserved 2026.*/

class Bus (var numeroRuta : Int,
           var capacidad : Int,
           var conductor : String  ){

    fun iniciarRuta() : String {
        return "La ruta $numeroRuta ha salido de la terminal.\nInformación de la ruta:\n Conductor: $conductor\n Capacidad: $capacidad"
    }
}