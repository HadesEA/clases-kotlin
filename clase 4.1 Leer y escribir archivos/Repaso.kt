// En esta parte veremos cómo:
// Escribir o crear archivos de texto
// Agregar texto a un archivo
// Leer línea por línea 
// Guardar datos generados para que "no se pierdan"

// Para ello utilizamos lo siguiente: 
import java.io.File

// File cuenta con lo siguiente:
// readText() para leer todo el contenido
// readLines() para leer cada línea como lista
// whiteText() para sobreescribir todo 
// appendText() para agregar texto al final

fun main() {
    val nombreArchivo = "datos.txt"

    // Escribir texto (sobrescribe si ya existe)
    File(nombreArchivo).writeText("Hola, este es el primer texto.\n")

    // Agregamos más texto
    File(nombreArchivo).appendText("Segunda línea agregada.\n")
    File(nombreArchivo).appendText("Tercer línea.\n")

    // Leer todo el contenido 
    val contenido = File(nombreArchivo).readText()
    println("=== Contenido completo ===")
    println(contenido)

    // Leer línea por línea
    val lineas = File(nombreArchivo).readLines()
    println("=== Lineas ===")
    for ((index, linea) in lineas.withIndex()) {
        println("${index + 1}: $linea")
    }
}