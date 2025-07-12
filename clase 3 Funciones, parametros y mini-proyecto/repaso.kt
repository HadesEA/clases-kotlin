// En kotlin una función básica se define de la siguiente manera:
fun saludar(nombre: String): String {
    return "Hola, $nombre"
}

// Se compone de la siguiente forma:
//  1. La palabra reservada "fun"
//  2. El nombre de la función "saludar"
//  3. El parámetro "nombre: String"
//  4. El tipo de retorno "String"
//  5. El cuerpo de la función "return "Hola, $nombre""

// Función que no devuelve nada (Tipo Unit, como es void en C#) Equivalente a un procedimiento
fun imprimirSaludo(nombre: String) {
    println("Hola, $nombre")
}

// Ejemplo inicial y base de un generador de contraseñas
import kotlin.random.Random

fun main() {
    println("=== Generador de contraseñas ===")
    print("¿De cuántos caracteres quieres la contraseña?: ")
    val longitud = readln().toIntOrNull() ?: 8

    val password = generadorContrasena(longitud)

    println("Tu nueva contraseña es: $password")
}

// Función que genera una contraseña
fun generadorContrasena(longitud: Int): String {
    val caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#\$%^&*()-_+="
    var contrasena = ""

    for (i in 1..longitud) {
        val indice = Random.nextInt(caracteres.length)
        contrasena += caracteres[indice]
    }
    return contrasena
}
