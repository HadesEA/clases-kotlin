fun main() {
    var opcion: Int

    do {
        println("\n=== Menú ===")
        println("1. Saludar")
        println("2. Mostrar tabla de multiplicar")
        println("3. Salir")
        print("Elige una opción: ")
        
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> println("¡Hola! ¿Cómo estás?")
            2 -> {
                print("¿Qué número quieres multiplicar? ")
                val numero = readLine()?.toIntOrNull() ?: 0
                for (i in 1..10) {
                    println("$numero x $i = ${numero * i}")
                }
            }
            3 -> println("¡Adiós!")
            else -> println("Opción no válida")
        }
    } while (opcion != 3)
}
