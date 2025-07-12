fun main() {
    // una variable val con tu color favorito
    val colorFavorito = "Negro"

    // Una variable var con el año actual, súmandole 1 y mostrando el resultado
    var añoActual = 2025
    añoActual += 1
    println("El próximo año será: $añoActual")

    // Una variable var que pueda ser null, primero null y luego sea string 
    var comidaFavorita: String? = null
    comidaFavorita = "Spaghetti"

    // Imprimimos todo junto en una frase 
    println("Mi color favorito es: $colorFavorito, el año que viene será $añoActual, y me gusta comer $comidaFavorita")
}

// Corremos el programa en terminal con este comando:
// kotlinc VariablesTipos.kt -include-runtime -d VariablesTipos.jar
// java -jar VariablesTipos.jar