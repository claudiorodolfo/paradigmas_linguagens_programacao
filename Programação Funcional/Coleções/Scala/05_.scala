object Main {
  // Função para retornar os elementos maiores que um número específico
  def maiores(valor: Int, lista: List[Int]): List[Int] = lista.filter(x => x > valor)

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(4, 6, 30, 3, 15, 3, 10, 7)
    println(maiores(10, minhaLista)) // Saída: List(30, 15)	
  }
}