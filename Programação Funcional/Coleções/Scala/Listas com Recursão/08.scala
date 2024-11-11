object Main {
  //Função que retorna uma nova lista contendo apenas os números ímpares.
  def filtrarImpares(lista: List[Int]): List[Int] = lista match {
    case Nil => Nil
    case cabeca :: cauda =>
      if (cabeca % 2 != 0) cabeca :: filtrarImpares(cauda)
      else filtrarImpares(cauda)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 4, 5, 6)
    println(filtrarImpares(minhaLista)) // Saída: List(1, 3, 5)
  }
}