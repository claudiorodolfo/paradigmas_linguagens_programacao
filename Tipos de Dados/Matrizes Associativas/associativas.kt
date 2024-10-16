//Kotlin
//Suporte Nativo

fun main() {
    val matriz = mutableMapOf(
        "um" to 1,
        "dois" to 2,
        "tres" to 3
    )

    // Acessar elementos
    println("Valor para 'dois': ${matriz["dois"]}")

    // Remover um elemento
    matriz.remove("tres")

    // Iterar pela matriz
    for ((chave, valor) in matriz) {
        println("$chave: $valor")
    }
}
