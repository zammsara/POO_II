/**
 * Project: Ejercicio02-SistemaProductos
 * From:
 * Created by: Sara Zambrana
 * On: 16/03/2026 at 21:17
 * All rights reserved 2026.*/


fun main(){
    val producto1 = Producto("Coca-Cola 1Lt", 25.50, 10)
    val producto2 = Producto("Pepsi 1Lt", 24.00, 8)
    val producto3 = Producto("Fanta 1Lt", 23.50, 12)

    println("\n-----------------------")

    producto1.mostrarProducto()
    producto2.mostrarProducto()
    producto3.mostrarProducto()
}