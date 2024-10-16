//Kotlin
//Tem suporte a slicing (fatias)

fun main() {
    // Definição e inicialização
    val matriz = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)		
    )

    // Exibir os elementos da matriz
    for (linha in matriz) {
        for (elemento in linha) {
            print("$elemento ")
        }
        println()
    }
	
    // 1) Fatiar a segunda e terceira linhas (índices 1 e 2)
    val fatiaLinhas = matriz.sliceArray(1..2)
    // 2) Fatiar a primeira e segunda colunas (índices 0 e 1)
    val fatiaColunas = matriz.map { it.sliceArray(0..1) }

    // Imprimir os resultados
    println("Fatia da segunda e terceira linhas:")
    fatiaLinhas.forEach { println(it.contentToString()) }
    println("Fatia da primeira e segunda colunas:")
    fatiaColunas.forEach { println(it.contentToString()) }
}
