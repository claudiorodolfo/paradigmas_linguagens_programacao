//Kotlin
//Não tem registros. Classe é uma espécie de um Registro Aprimorado, pois também Abstrai Dados heterogêneos, mas adiciona Encapsulamento, Herança e Polimorfismo.

data class Pessoa(val nome: String, val idade: Int, val altura: Double)

fun main() {
    val pessoa = Pessoa("Bruna", 29, 1.68)

    // Exibindo valores
    println("Nome: ${pessoa.nome}")
    println("Idade: ${pessoa.idade}")
    println("Altura: ${pessoa.altura} m")
}
