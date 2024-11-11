object Main {
  // Função para retornar os elementos maiores que um número específico
  def maiores(elemento: Int, lista: List[Int]): List[Int] = lista match {
    case Nil => Nil
    case cabeca :: cauda => 
		if (cabeca > elemento) cabeca :: maiores(elemento, cauda) 
		else maiores(elemento, cauda)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(4, 6, 30, 3, 15, 3, 10, 7)
    println(maiores(10, minhaLista)) // Saída: List(30, 15)	
  }
}