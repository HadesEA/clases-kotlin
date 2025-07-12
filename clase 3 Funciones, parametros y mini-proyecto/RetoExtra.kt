import kotlin.random.Random

fun main() {
    println("---- Generación de contraseñas aleatorias ----")
    print("¿De qué longitud quiere su contraseña? ")
    val longitud = readln().toIntOrNull() ?: 8
    print("¿Cuántas contraseñas desea generar? ")
    val cantidad = readln().toIntOrNull() ?: 1

    print("¿Desea caractéres especiales en su contraseña? (s/n)")
    var password = if (readln()[0] == 's') contraEspecial(longitud, cantidad) else contraNormal(longitud, cantidad)

    println("Su nueva contraseña es:")
    for ((index, contra) in password.withIndex()) {
        println("Contraseña ${index+1}: $contra")
    }
}

fun contraNormal(longitud: Int, cantidad: Int): List<String> { 
    val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"
    val contrasenas = mutableListOf<String>()

    for (i in 1..cantidad) {
        var contra = ""
        for (j in 1..longitud) {
            val indice = Random.nextInt(caracteres.length)
            contra += (caracteres[indice])
        }
        contrasenas.add(contra)
    }
    return contrasenas
}

fun contraEspecial(longitud: Int, cantidad: Int): List<String> {
    val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-_.,¿?¡!=+*/<>"
    val contrasenas = mutableListOf<String>()

    for (j in 1..cantidad) {
        var contra = ""
        for (i in 1..longitud) {
            val indice = Random.nextInt(caracteres.length)
            contra += caracteres[indice]
        }
        contrasenas.add(contra)
    }
    return contrasenas
}