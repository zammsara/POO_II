/**
 * Project: Ejercicio02-SistemaProductos
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 21:25
 * All rights reserved 2026.*/

data class Producto (
    var nombre : String,
    var precio : Double,
    var cantidad : Int
) {
    fun mostrarProducto(){
        println("\nProducto: $nombre")
        println("Precio: $precio")
        println("Cantidad: $cantidad\n")
        println("-----------------------")
    }
}

