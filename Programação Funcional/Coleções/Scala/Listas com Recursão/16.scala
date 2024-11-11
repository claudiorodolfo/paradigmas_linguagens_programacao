object Main {
  //Função que aplica uma função recebida a cada elemento da lista e retornar uma nova lista com os resultados.
  def aplicarFuncao(lista: List[Int], funcao: Int => Int): List[Int] = lista match {
    case Nil => Nil
    case cabeca :: cauda => funcao(cabeca) :: aplicarFuncao(cauda, funcao)
  }


  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 4, 5)
	val triplo = (x: Int) => x * 3
    println(aplicarFuncao(minhaLista, triplo)) // Saída: List(3,6,9,12,15)
  }
}