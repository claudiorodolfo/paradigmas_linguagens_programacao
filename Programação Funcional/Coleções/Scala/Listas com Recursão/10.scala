object Main {
    //Função que retorna uma nova lista onde cada elemento da lista original é multiplicado pelo número fornecido.
    def multiplicarElementos(lista: List[Int], multiplicador: Int): List[Int] = lista match {
      case Nil => Nil
      case cabeca :: cauda => (cabeca * multiplicador) :: multiplicarElementos(cauda, multiplicador)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 4, 5)
    println(multiplicarElementos(minhaLista, 2)) // Saída: List(2, 4, 6, 8, 10)
  }
}