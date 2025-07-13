// Importamos aquellas herramientas necesarias
import kotlin.random.Random
import java.io.File

// Función para crear las contraseña de longitud indicada, la cantidad de veces indicada
fun genContra(longitud: Int, cantidad: Int): List<String> {
    val alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    val contras = mutableListOf<String>()

    for (i in 1..cantidad) {
        var contra = ""
        for (j in 1..longitud) {
            contra += alfabeto[Random.nextInt(0, alfabeto.length)]
        }
        contras.add(contra)
    }
    return contras
}

// Función para generar contraseñas especiales con n cantidad de caracteres y m cantidad de contraseñas
fun genContraEsp(longitud: Int, cantidad: Int): List<String> {
    val alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_.,;:/-*+|@^~(){}[]"
    val contras = mutableListOf<String>()

    for (i in 1..cantidad) {
        var contra = ""
        for (j in 1..longitud) {
            contra += alfabeto[Random.nextInt(0, alfabeto.length)]
        }
        contras.add(contra)
    }
    return contras
}

fun blocNotas() {
    val bloc = "bloc.txt"

    do {
        print("\n¿Qué quieres agregar al bloc de notas? ")
        val texto = readln()
        print("\n¿Quieres sobreescribir (w) o agregar (a)? ")
        val opcion = readln()[0]

        when (opcion){
            'w' -> File(bloc).writeText(texto)
            'a' -> File(bloc).appendText("\n$texto")
            else -> println("Cómo le hiciste para tronar esto....?")
        }

        val contenido = File(bloc).readText()
        println("\n\n $contenido")

        print("\n\n¿Quieres agregar otro texto? (s/n)")
        val respuesta = readln()[0].lowercaseChar()
    } while (respuesta == 's')
}

fun conversorTemperaturaCaF(temperatura: Int) {
    val Fahrenheit = (temperatura * 1.8) + 32
    return println("Conversion de $temperatura °C a $Fahrenheit °F")
}

fun conversorTemperaturaFaC(temperatura: Int) {
    val Centigrados = (temperatura - 32) / 1.8
    return println("Conversion de $temperatura °F a $Centigrados °C")
}

fun main() {
    do {
        println("\n\n\n=== Menú de utilidades ===")
        println("1. Generador de contraseñas")
        println("2. Bloc de Notas")
        println("3. Conversor de temperaturas")
        println("4. Salir")
        print("¿Qué opción deseas realizar? ")
        val opcion = readln().toIntOrNull()

        when (opcion) {
            1 -> {
                do {
                    println("\n\n=== Generador de contraseñas ===")
                    print("\n¿De qué longitud desea sus contraseñas? ")
                    val longitud = readln().toIntOrNull() ?: 8
                    print("\n¿Cuantas contraseñas desea generar? ")
                    val cantidad = readln().toIntOrNull() ?: 4
                    print("\n¿Quiere caracteres especiales en las contraseñas? (s/n) ")
                    val opcontra = if (readln()[0].lowercaseChar() == 's') genContraEsp(longitud, cantidad) else genContra(longitud, cantidad)
                    println(opcontra)
                    print("\n¿Quiere generar más contraseñas? (s/n) ")
                    val respuesta1 = readln()[0].lowercaseChar()
                } while (respuesta1 == 's')
            }
            2 -> blocNotas()
            3 -> {
                do {
                    print("\nIngrese la temperatura: ")
                    val temperatura = readln().toIntOrNull() ?: 0
                    println("\n\n=== Conversor de temperaturas ===")
                    println("1. Convertir de °C a °F")
                    println("2. Convertir de °F a °C")
                    print("\n¿Qué opción desea realizar? (1 o 2) ")
                    val conversion =  if (readln().toIntOrNull() == 1) conversorTemperaturaCaF(temperatura) else conversorTemperaturaFaC(temperatura)
                    print("\n¿Quiere realizar otra conversión? (s/n) ")
                    val respuesta2 = readln()[0].lowercaseChar()
                } while (respuesta2 == 's')
            }
            4 -> println("Hasta luego!")
            else -> println("Opción no válida")
        }
    } while (opcion != 4)
}