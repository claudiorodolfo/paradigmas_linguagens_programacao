object Main {
  //Função que retorna uma string única com todas as strings concatenadas, separadas por um espaço.
  def concatenarStrings(lista: List[String]): String = lista match {
    case Nil => ""
    case cabeca :: Nil => cabeca
    case cabeca :: cauda => cabeca + " " + concatenarStrings(cauda)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List("Instituto","Federal","da","Bahia")
    println(concatenarStrings(minhaLista)) // Saída: Instituto Federal da Bahia
  }
}