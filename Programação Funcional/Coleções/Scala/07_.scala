object Main {
  // Função para duplicar os elementos de uma lista
  def duplica[A](lista: List[A]): List[A] = lista.flatMap(e => List(e, e))

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3)
    println(duplica(minhaLista)) // Saída: List(1, 1, 2, 2, 3, 3)
  }
}