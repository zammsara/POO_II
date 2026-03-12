package run

/**
 * Project: Ejemplo3
 * From: run
 * Created by: Sara Zambrana
 * On: 11/03/2026 at 17:10
 * All rights reserved 2026.*/

fun main(){
    //mutable
    topic("Variables mutables")
    var age = 0
    println(age)

    age = 14
    println(age)

    var pookie1= "Pedrito"
    println("Mi pookie fav es $pookie1")

    pookie1= "Lee Pace"
    println("Mi pookie fav es $pookie1")

    var pookie2= "Oscarcito"
    println("Mi pookie fav2 es $pookie2")

    pookie2= "Lee Pace"
    println("Mi pookie fav2 es $pookie2")

    //inmutable
    topic("Variables inmutables")
    val pookieOG = "Madz"
    println("El pookie OG es: $pookieOG")

    //Variables de tipo entero
    topic("Variables tipo entero")
    val quan: Int = 22
    var totalStudents: Int = 30
    println("Cantidad: $quan \nTotal de estudiantes: $totalStudents")

    //Variables de tipo decimal
    topic("Variables tipo decimal")
    val price : Double = 3.14
    var average : Double = 3.16
    println("Promedio: $average\n Precio: $price ")

    //texto
    topic("Texto")
    val phrase: String = "Para super un miedo, tienes que atravesarlo"
    println(phrase)

    //caracter
    topic("caracter")
    var grade: Char = 'A'
    println("Su calificacion es: $grade")

    //booleanos
    var isActive: Boolean = true
    isActive=false
    println(!isActive)


}

fun topic(texto:String){
    println("\n${Separator.SEPARATORR} $texto ${Separator.SEPARATORR}")
}
