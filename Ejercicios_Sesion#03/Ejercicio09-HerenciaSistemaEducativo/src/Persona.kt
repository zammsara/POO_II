/**
 * Project: Ejercicio09-HerenciaSistemaEducativo
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:30
 * All rights reserved 2026.*/

open class Persona (val nombre:String,
                    var edad : Int){
    fun infoPersona() : String{
        return "Nombre: $nombre, Edad: $edad"
    }
}