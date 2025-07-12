fun main() {
    // Uso de condicionale simple
    val edad = 20
    val esMayor = if (edad >= 18) "Mayor de edad" else "Menor de edad"
    println(esMayor)

    // Uso de when (Switch en C#)
    val dia = 3
    val nombreDia = when (dia){
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miércoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6, 7 -> "Fin de semana"
        else -> "Día desconocido"
    }
    println(nombreDia)

    // Uso de for
    for (i in 1..5) {
        println("Número: $i ")
    }

    // Recorrer listas (similar a python)
    val frutas = listOf("Manzana", "Plátano", "Fresa")
    for (fruta in frutas) {
        println(fruta)
    }
    
    // Uso de While
    var contador = 0
    while (contador < 3) {
        print("Contador: $contador ")
        contador++
    }

    // Uso de do while
    var n = 0
    do {
        print("Contador: $n ")
        n++
    } while (n < 3)
}