//Kotlin
//Parametro Real: m
//Parametro Formal: matriz
//Passagem de Parâmetro do tipo Matriz é, por padrão, por Referência

// Função para imprimir a matriz
fun imprimirMatriz(matriz: Array<IntArray>) {
    for (linha in matriz) {
        println(linha.joinToString(" "))
    }
}

// Função para dobrar os elementos da matriz
fun dobrarMatriz(matriz: Array<IntArray>) {
    for (i in matriz.indices) {
        for (j in matriz[i].indices) {
            matriz[i][j] *= 2
        }
    }
}

fun main() {
    val m = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8))
    
    println("Antes de dobrar:")
    imprimirMatriz(m)

    dobrarMatriz(m)

    println("Depois de dobrar:")
    imprimirMatriz(m)
}
