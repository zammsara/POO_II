/**
 * Project: Ejercicio10-SistemaBiblioteca
 * From:
 * Created by: Sara Zambrana
 * On: 17/03/2026 at 13:53
 * All rights reserved 2026.*/

fun main(){
    val libro1 = Libro("Introducción a Algoritmos", "Thomas H. Cormen, Charles E. Leiserson", 1990)
    val libro2 = Libro("Algoritmos + Estructuras de Datos = Programas", "Niklaus Wirth", 1976)
    val libro3 = Libro("La practica de Programar", "Brian V. Kerningham, Rob Pike", 1999)
    val libro4 = Libro("Pensando en Java", "Bruce Eckel", 1998)

    println("\n====================================\n")
    libro1.mostrarInfo()
    println("\n====================================\n")
    libro2.mostrarInfo()
    println("\n====================================\n")
    libro3.mostrarInfo()
    println("\n====================================\n")
    libro4.mostrarInfo()
    println("\n====================================\n")
}