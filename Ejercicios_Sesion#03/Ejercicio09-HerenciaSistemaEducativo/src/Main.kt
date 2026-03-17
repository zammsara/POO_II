/**
 * Project: Ejercicio09-HerenciaSistemaEducativo
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:37
 * All rights reserved 2026.*/

fun main(){
    val docente = Docente("Mads Mikkelsen", 60, "Danza")
    val estudiante = Estudiante("Hugh Dancy", 25, 5)

    println("\n===============================\n")
    println(docente.inforDocente())
    println("\n===============================\n")
    println(estudiante.infoEstudiante())
    println("\n===============================\n")
}