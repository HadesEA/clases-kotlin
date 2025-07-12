fun main() {
    var opcion: Char

    do {
        println("Ingrese un número para devolver qué dia es:")
        var numero = readln().toIntOrNull()
        val nombreDia = when (numero) {
            1 -> "Lunes"
            2 -> "Martes"
            3 -> "Miércoles"
            4 -> "Jueves"
            5 -> "Viernes"
            6, 7 -> "Fin de semana"
            else -> "Opcion no valida"
        }
        println("El dia de la semana es: $nombreDia ")
        println("¿Desea continuar? (s/n):")
        opcion = readln()[0]
    } while (opcion == 's' || opcion == 'S') 
}