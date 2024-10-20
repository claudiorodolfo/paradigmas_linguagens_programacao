//Kotlin
//Kotlin oferece suporte a enum classes, que permitem definir enumerações.
enum class DiaDaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}

fun main() {
    val hoje = DiaDaSemana.TERCA

    // Exibindo valor ordinal
    println("Hoje é: $hoje")

    // Usando a posição ordinal
    println("Posição ordinal: ${hoje.ordinal}")

    if (hoje == DiaDaSemana.TERCA) {
        println("Hoje é terça-feira.")
    }
}
