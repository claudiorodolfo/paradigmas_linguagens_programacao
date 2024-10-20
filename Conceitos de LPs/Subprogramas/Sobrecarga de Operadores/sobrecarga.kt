//Kotlin

// Definindo a classe Ponto
data class Ponto(val x: Int, val y: Int) {

    // Sobrecarga do operador + para somar dois pontos
    operator fun plus(outro: Ponto): Ponto {
        return Ponto(x + outro.x, y + outro.y)
    }
}

fun main() {
    // Criando dois pontos
    val p1 = Ponto(2, 3)
    val p2 = Ponto(4, 5)

    // Somando os pontos usando o operador +
    val p3 = p1 + p2

    // Exibindo o resultado
    println("Ponto resultante: $p3")
}