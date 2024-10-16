//Kotlin 

fun main() {
    // Definindo e inicializando conjuntos
    val conjuntoA = setOf(1, 2, 3, 4, 5)
    val conjuntoB = setOf(4, 5, 6, 7, 8)

    // União
    val uniao = conjuntoA union conjuntoB

    // Intersecção
    val intersecao = conjuntoA intersect conjuntoB

    // Diferença
    val diferenca = conjuntoA subtract conjuntoB

    // Exibindo resultados
    println("União: $uniao")
    println("Intersecção: $intersecao")
    println("Diferença: $diferenca")
}
