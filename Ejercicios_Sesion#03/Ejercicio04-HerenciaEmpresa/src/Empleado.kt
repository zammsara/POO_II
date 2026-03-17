/**
 * Project: Ejercicio04-HerenciaEmpresa
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 21:47
 * All rights reserved 2026.*/

//Clase PADRE
open class Empleado (
    private var nombre : String,
    private var salario : Double,) {

    open fun mostrarInfo(): String {
        return "Información del empleado:\n Nombre: $nombre\n Salario: $salario"
    }
}

//Clase HIJO
class Programador(nombre: String,
                  salario: Double,
                  var lenguaje : String)
    : Empleado(nombre, salario, ) {

    override fun mostrarInfo() : String {
        return "${super.mostrarInfo()}\n Lenguaje: ${lenguaje}"
    }
}
