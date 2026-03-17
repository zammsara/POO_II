/**
 * Project: Ejercicio09-HerenciaSistemaEducativo
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:32
 * All rights reserved 2026.*/

class Docente (nombre : String,
               edad: Int,
               var clase : String) : Persona(nombre, edad) {

    fun inforDocente(): String {
        return "Informacion del docente:\n Nombre: $nombre\n Edad: $edad\n Clase: $clase"
    }
}