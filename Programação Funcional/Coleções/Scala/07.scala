object Main {
  // Função para duplicar os elementos de uma lista
  def duplica[A](lista: List[A]): List[A] = lista match {
    case Nil => Nil // Se a lista estiver vazia, retorna uma lista vazia
    case a :: x => a :: a :: duplica(x) // Duplicar o primeiro elemento e continuar com o restante da lista
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3)
    println(duplica(minhaLista)) // Saída: List(1, 1, 2, 2, 3, 3)
  }
}