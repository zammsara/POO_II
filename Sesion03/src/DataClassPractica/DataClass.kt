package DataClassPractica

/**
 * Project: Sesion03
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 18:02
 * All rights reserved 2026.*/

data class Estudiante (
    val cif : String,
    val nombre : String,
    val  carrera : String,
    val promedio : Double

)

fun main(){
    val madz = Estudiante("2100",
        "Madz",
        "Psicologia",
        99.0)

    println()
    println(madz)
}