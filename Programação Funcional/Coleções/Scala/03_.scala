object Main {
  // Função que recebe uma lista qualquer e retorna o número de elementos na lista.
  def contaOcorrencias[A](elemento: A, lista: List[A]): Int = lista.count(x => x == elemento)

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 2, 4, 2, 5)
    println(contaOcorrencias(2, minhaLista)) // Saída: 3	
  }
}