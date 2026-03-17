/**
 * Project: Ejercicio01-RegistroEstudiantes
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 18:13

 * All rights reserved 2026.*/

class Estudiante {

    var nombre = ""
    var carnet = ""
    var carrera = ""
    var anio = 0

    fun mostrarDatos() {
        println("Información del Estudiante: ")
        println(" Nombre: $nombre\n Carnet: $carnet\n Carrera: $carrera\n Año: $anio")
    }
}

fun main(){
    val estudiante = Estudiante()

    estudiante.nombre = "Oscar Isaac"
    estudiante.carnet = "2401001"
    estudiante.carrera = "Psicología"
    estudiante.anio = 4
    estudiante.mostrarDatos()
    println("____________________________________")

    estudiante.nombre = "Madz Mikkelsen"
    estudiante.carnet = "2100109"
    estudiante.carrera = "Negocios Internacionales"
    estudiante.anio = 4
    estudiante.mostrarDatos()
    println("____________________________________")

    estudiante.nombre = "Lee Pace"
    estudiante.carnet = "2401007"
    estudiante.carrera = "Matemáticas"
    estudiante.anio = 4
    estudiante.mostrarDatos()

}

