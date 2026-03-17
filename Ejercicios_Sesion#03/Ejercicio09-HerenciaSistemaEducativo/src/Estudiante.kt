/**
 * Project: Ejercicio09-HerenciaSistemaEducativo
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:35
 * All rights reserved 2026.*/

class Estudiante (nombre : String,
                  edad : Int,
                  var anio : Int ) : Persona(nombre, edad) {

    fun infoEstudiante(): String {
        return "Informacion del estudiante: \n Nombre: $nombre\n Edad: $edad\n Año: $anio"
    }
}