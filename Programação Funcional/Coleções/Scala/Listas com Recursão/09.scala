object Main {
  //Função que retorna uma lista com todas as strings que contêm a string de busca como substring
  def buscarSubstrings(lista: List[String], busca: String): List[String] = lista match {
    case Nil => Nil
    case cabeca :: cauda =>
      if (cabeca.contains(busca)) cabeca :: buscarSubstrings(cauda, busca)
      else buscarSubstrings(cauda, busca)
  }


  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List("ababa","tratr","abtbt","aatbatb","rtbrbt","abarbarb")
    println(buscarSubstrings(minhaLista, "at")) // Saída: List(tratr, aatbatb)
  }
}