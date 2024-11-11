object Main {
  // Função que recebe uma lista qualquer e retorna o número de elementos na lista.
  def contaOcorrencias(elemento: Int, lista: List[Int]): Int = lista match {
    case Nil => 0
    case cabeca :: cauda => 
		(if (cabeca == elemento) 1 else 0) + contaOcorrencias(elemento, cauda)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 2, 4, 2, 5)
    println(contaOcorrencias(2, minhaLista)) // Saída: 3	
  }
}