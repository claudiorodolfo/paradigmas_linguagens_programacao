object Main {
  // Função que recebe uma lista qualquer e retorna o número de elementos na lista.
  def contaOcorrencias(a: Int, lista: List[Int]): Int = lista match {
    case Nil => 0
    case x :: xs => if (x == a) 1 + contaOcorrencias(a, xs) else contaOcorrencias(a, xs)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 2, 4, 2, 5)
    println(contaOcorrencias(2, minhaLista)) // Saída: 3	
  }
}