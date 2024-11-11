object Main {
    //Função que retorna uma lista com o quadrado de cada elemento.
  def quadrados(lista: List[Int]): List[Int] = lista match {
    case Nil => Nil
    case cabeca :: cauda => (cabeca * cabeca) :: quadrados(cauda)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 4, 5)
    println(quadrados(minhaLista)) // Saída: List(1, 4, 9, 16, 25)
  }
}