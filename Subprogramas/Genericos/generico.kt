//Kotlin

fun <T: Comparable<T>> maiorValor(a: T, b: T): T {
    return if (a > b) a else b
}

fun main() {
    println("Maior entre 10 e 20: ${maiorValor(10, 20)}")
    println("Maior entre 3.14 e 2.71: ${maiorValor(3.14, 2.71)}")
}
