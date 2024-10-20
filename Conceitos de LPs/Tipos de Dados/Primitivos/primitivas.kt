//Kotlin
fun main() {
    val pequeno: Byte = 127              // Inteiro pequeno
    val inteiro: Int = 2147483647         // Inteiro padrão
    val grande: Long = 9223372036854775807 // Inteiro grande
    val pontoFlutuante: Float = 3.14f     // Ponto flutuante simples
    val duplaPrecisao: Double = 3.1415926535 // Ponto flutuante de dupla precisão
    val booleano: Boolean = true          // Booleano
    val caractere: Char = 'K'             // Caractere
    val inteiroSemSinal: UInt = 4294967295U // Inteiro sem sinal (Kotlin suporta inteiros sem sinal)

    println("Byte: $pequeno")
    println("Int: $inteiro")
    println("Long: $grande")
    println("Float: $pontoFlutuante")
    println("Double: $duplaPrecisao")
    println("Boolean: $booleano")
    println("Char: $caractere")
    println("UInt: $inteiroSemSinal")
}
