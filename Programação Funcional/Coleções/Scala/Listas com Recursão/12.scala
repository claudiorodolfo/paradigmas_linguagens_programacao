object Main {
  // Função para verificar se existe uma única ocorrência de um elemento em uma lista
  def filtrarPositivos(lista: List[Int]): List[Int] = lista match {
    case Nil => Nil
    case cabeca :: cauda =>
      if (cabeca > 0) cabeca :: filtrarPositivos(cauda)
      else filtrarPositivos(cauda)
}

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, -2, 3, 4, -5)
    println(filtrarPositivos(minhaLista)) // Saída: List(1, 3, 4)
  }
}