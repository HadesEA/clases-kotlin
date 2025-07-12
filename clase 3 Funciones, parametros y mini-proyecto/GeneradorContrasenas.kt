import kotlin.random.Random

fun main() {
    println("*** Generador de contraseñas ***")
    print("¿De cuantos caracteres quieres la contraseña? ")
    val longitud = readln().toIntOrNull() ?: 8

    val password = generarContrasena(longitud)

    println("Su nueva contraseña es: === $password === ")
}

fun generarContrasena(longitud: Int): String {
    val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    var contraseña = ""

    for (i in 1..longitud) {
        val indice = Random.nextInt(caracteres.length)
        contraseña += caracteres[indice]
    }
    return contraseña
}