package run

/**
 * Project: Ejemplo3
 * From: run
 * Created by: Sara Zambrana
 * On: 11/03/2026 at 18:26
 * All rights reserved 2026.*/

fun isAdult(age: Int) : Boolean = age >= 18

fun calculateBonus(salary: Double) : Double = salary * 0.1

fun scholarship(grade: Int): Double {
    when (grade) {
        in 70..<79 -> {
            return 0.25
        }
        in 80..89 -> {
            return 0.30
        }
        in 90..95 -> {
            return 0.50
        }
        else -> {
            return 0.0
        }
    }
}

//Antes de convertilo a while la función era esta:

//**fun scholarship(grade: Int): Double {
//    if (grade in 70..<79){
//        return 0.25
//    }else if(grade in 80..89){
//        return 0.30
//    }else if(grade in 90..95){
//        return 0.50
//    }else{
//        return 0.0
//    }
//}*/