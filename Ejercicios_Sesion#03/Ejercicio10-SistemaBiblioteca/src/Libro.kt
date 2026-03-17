/**
 * Project: Ejercicio10-SistemaBiblioteca
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:48
 * All rights reserved 2026.*/

class Libro(val titulo : String,
            val autor : String,
            val anioPublicacion : Int)
{
    fun mostrarInfo(){
       println("Información dle libro:")
       print(" Título: $titulo\n Autor: $autor\n Año publicado: $anioPublicacion")
    }
}