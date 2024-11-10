object Main extends App {
    case class Pessoa(nome: String, idade: Int)
    
    val pessoa = new Pessoa("Ana", 30)
    
    val paraTexto = (p: Pessoa) => s"Nome: ${p.nome}, Idade: ${p.idade}"
    println(paraTexto(pessoa)) // Deve imprimir "Nome: Ana, Idade: 30"
}