/**
 * Project: Sesion03
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 17:13
 * All rights reserved 2026.*/

//Clases y objetos
class Estudiante {
    var nombre = ""
    var edad = 0

    fun estudiar(){
        println("El estudiante $nombre esta estudiando...")
    }

}

//Encapsulamiento
class Asignatura(private val nombre: String, private val precio: Double) {

    fun getNombre(): String {
        return "La asignatura se llama $nombre"
    }

    fun getPrecio(): Double {
        return precio
    }
}

fun main(){
    val estudiante = Estudiante()

    println("Clases y objetos")
    estudiante.nombre="Lee Pace"
    estudiante.edad=20
    estudiante.estudiar()

    estudiante.nombre="Oscar Isaac"
    estudiante.edad=30
    estudiante.estudiar()

    println("Encapsulamiento")
    val poo = Asignatura("POO", 250.0)
    println(poo.getNombre())
    println(poo.getPrecio())
}
