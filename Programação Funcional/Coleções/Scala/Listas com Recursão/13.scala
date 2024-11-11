object Main {
  //Função que retorna a soma de todos os elementos.
  def soma(lista: List[Int]): Int = lista match {
    case Nil => 0
    case cabeca :: cauda => cabeca + soma(cauda)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 4, 5)
    println(soma(minhaLista)) // Saída: 15
  }
}