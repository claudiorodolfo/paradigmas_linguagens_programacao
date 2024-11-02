object Main {
  // Função para retornar os elementos maiores que um número específico
  def maiores(x: Int, lista: List[Int]): List[Int] = lista match {
    case Nil => Nil
    case a :: t => if (a > x) a :: maiores(x, t) else maiores(x, t)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(4, 6, 30, 3, 15, 3, 10, 7)
    println(maiores(10, minhaLista)) // Saída: List(30, 15)	
  }
}