/**
 * Project: Sesion03
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 17:29
 * All rights reserved 2026.*/

//HERENCIA
open class Persona(
    private var nombre:String = "" ,
    private var apellido:String = ""){

    fun saludar():String{
        return "Bienvenid@ $nombre $apellido !"
    }
}

class Empleado(nombre: String,
               apellido: String,
               var rol:String
) : Persona (nombre, apellido,) {


}

fun main(){
    val empleado = Empleado("Oscar", "Isaac", "admin")
    println(empleado.saludar())
}