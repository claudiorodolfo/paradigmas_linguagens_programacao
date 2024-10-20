//Kotlin
fun main() {
    val str1 = "Olá"
    val str2 = "Mundo"

    // Concatenar
    val concatenado = "$str1 $str2"
    println("Concatenado: $concatenado")

    // Substring
    val sub = concatenado.substring(0, 3)
    println("Substring: $sub")

    // Comparar strings
    val iguais = str1 == str2
    println("As strings são iguais? $iguais")

    // Tamanho da string
    println("Tamanho de str1: ${str1.length}")
}
