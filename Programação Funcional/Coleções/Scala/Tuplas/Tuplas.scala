object Main extends App {
  case class Pessoa(nome: String, idade: Int)
  
  val pessoas = List(Pessoa("Maria", 30), Pessoa("Joao", 20))
  val pessoasNome = pessoas.map(x => x.nome)
  println(pessoasNome)
  
  val imoveisColeta = List(("Apartamento", 3), ("Casa", 5), ("Loja", 2))
  val tiposDeImoveis = imoveisColeta.map(x => x._1)    //pega os primeiros itens da tupla
  val tiposDeImoveis2 = imoveisColeta.map(x => x._2) //pega os segundos itens da tupla
  println(tiposDeImoveis) // List("Apartamento", "Casa", "Loja")
  println(tiposDeImoveis2) // List(3, 5, 2)
}