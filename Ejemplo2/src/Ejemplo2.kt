import Calculadora
import javax.swing.JOptionPane
import Calculadora as ca

class Ejemplo2 {
    fun saludar(nombre: String) {
        println("Hola $nombre")
    }

    fun producto(x: Int, y: Int): Int {

        return x * y
    }

}

fun main(args: Array<String>) {
    //val saluda1 = Ejemplo2().saludar("Madz") //otra opcion
    val saludo= Ejemplo2()
    saludo.saludar("Oscar")

    val num1 = 2
    val num2 = 3
    val prod = saludo.producto(num1, num2)
    //println(saludo.producto(2,4)) //manera mas simple por el curso

    JOptionPane.showMessageDialog(null, 6)

    var c: Calculadora()
    var suma: Int = c.Suma(num1, num2)

    //println(ca.Suma)
}
