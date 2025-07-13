import java.io.File

val archivoTareas = "tareas.txt"

fun main() {
    do {
        println("\n=== Gestor de Tareas ===")
        println("1. Ver tareas")
        println("2. Agregar nueva tarea")
        println("3. Eliminar tarea")
        println("4. Marcar tarea como completada")
        println("5. Salir")
        print("Elige una opción: ")
        val opcion = readln().toIntOrNull() 

        when (opcion) {
            1 -> verTareas()
            2 -> agregarTarea()
            3 -> eliminarTarea()
            4 -> marcarCompletada()
            5 -> println("Hasta luego!")
            else -> println("Opción inválida. Por favor, elija una opción válida")
        }
    } while (opcion != 5)
}

fun verTareas() {
    val tareas = File(archivoTareas).readLinesOrNull() ?: emptyList()
    if (tareas.isEmpty()) {
        println("No tienes tareas aún.")
    } else {
        println("\n=== Lista de tareas ===")
        for ((index, tarea) in tareas.withIndex()) {
            val partes = tarea.split(";")
            val estado = if (partes[0] == "1") "Ø" else "O"
            println("${index+1}. $estado ${partes[1]}")
        }
        println("\n1. Mostrar completadas")
        println("\n2. Mostrar pendientes")
        println("\n3. Mostrar ordenado")
        println("\n4. Salir")
        print("Seleccione una opción: ")
        val opcion = readln().toIntOrNull()
        when (opcion) {
            1 -> {
                println("\n=== Lista de completados ===")
                for ((index, tarea) in tareas.withIndex()) {
                    val partes = tarea.split(";")
                    if (partes[0] == "1") println("${index + 1}. ${partes[1]}")
                }
            }
            2 -> {
                println("\n=== Lista de pendientes ===")
                for ((index, tarea) in tareas.withIndex()) {
                    val partesp = tarea.split(";")
                    if (partesp[0] == "0") println("${index + 1}. ${partesp[1]}")
                }
            }
            3 -> {
                println("\n=== Lista de ordenado ===")
                tareas.sortedBy { it.split(";")[1] }.forEach { println(it) }
            }
        }        
    }
}

fun agregarTarea() {
    print("Escribe la nueva tarea: ")
    val texto = readln().uppercase()
    File(archivoTareas).appendText("0;$texto\n")
    println("Tarea agregada correctamente.")
}

fun eliminarTarea() {
    verTareas()
    println("Escribe el número de la tarea que deseas eliminar: ")
    val numero = readln().toIntOrNull()
    if (numero != null) {
        val tareas = File(archivoTareas).readLinesOrNull() ?: emptyList()
        if (numero in 1..tareas.size) {
            val tarea = tareas[numero - 1]
            File(archivoTareas).writeText(tareas.filterIndexed { index, _ -> index != numero - 1 }.joinToString("\n"))
            println("Tarea eliminada correctamente.")
        } else {
            println("Número de tarea inválido.")
        }
    } else {
        println("Número de tarea inválido.")
    }
}

fun marcarCompletada() {
    val tareas = File(archivoTareas).readLinesOrNull()?.toMutableList() ?: mutableListOf()
    if (tareas.isEmpty()) {
        println("No hay tareas para marcar.")
        return
    }

    println("\n=== Lista de tareas ===")
    for ((index, tarea) in tareas.withIndex()) {
        val partes = tarea.split(";")
        val estado = if (partes[0] == "1") "Ø" else "O"
        println("${index+1}. $estado ${partes[1]}")
    }

    print("Número de la tarea a marcar como completada: ")
    val num = readln().toIntOrNull()

    if (num == null || num !in 1..tareas.size) {
        println("Número inválido.")
    } else {
        val partes = tareas[num-1].split(";")
        tareas[num-1] = "1;${partes[1]}"
        File(archivoTareas).writeText(tareas.joinToString("\n"))
        println("Tarea marcada como completada.")
    }
}

// Función auxiliar para evitar error si el archivo no existe
fun File.readLinesOrNull(): List<String>? =
    if (exists()) readLines() else null