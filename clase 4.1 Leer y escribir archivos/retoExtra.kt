import java.io.File

fun main() {
    val file = "ingreso.txt"

    do {
        print("¿Qué texto desea guardar? ")
        val texto = readLine() ?: ""
        print("¿Quieres sobreescribir (w) o agregar (a) ")
        val opcion = readln()[0].lowercaseChar()
        if (opcion == 'w') {
            File(file).writeText(texto)
            File(file).appendText("\n")
        } else {
            File(file).appendText(texto)
            File(file).appendText("\n")
        }

        val contenido = File(file).readText()
        println("Texto completo")
        println(contenido)

        val lineas = File(file).readLines()
        for ((index, linea) in lineas.withIndex()) {
            println("${index + 1}. $linea")
        }

        print("¿Desea agregar otro texto? (s/n) ")
        val respuesta = readln()[0] 

    } while (respuesta == 's' || respuesta == 'S')
}