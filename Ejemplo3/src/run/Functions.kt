package run

/**
 * Project: Ejemplo3
 * From: run
 * Created by: Sara Zambrana
 * On: 11/03/2026 at 18:09
 * All rights reserved 2026.*/

fun sayHi(name: String){
    println("Hi $name!")
}

fun addGrade(baseGrade: Int, extra: Int): Int{
    return baseGrade + extra
}

fun getScore(score: Int, extra: Int): Int = score + extra

fun createUser(name: String, role: String = "Usuario"){
    println("Usuario: $name, Rol: $role")
}

fun main(){
    topic("Funciones")
    sayHi("Madz")
    val grade= "Nota final: ${addGrade(75, 1)}"
    println(grade)
    println("Aumento: ${getScore(75, 6)}")
    createUser("Lee", "Admin")

}