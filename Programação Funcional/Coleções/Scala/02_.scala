object Main {
  // Função que recebe uma lista qualquer e retorna o maior elemento da lista.
  def maior(lista: List[Int]): Int = if (lista.isEmpty) 0 else lista.max
  
  // Função principal
  def main(args: Array[String]): Unit = {
    val listaVazia = List.empty[Int]
    val listaVazia2 = List()
    val minhaLista = List(10, 23, 5, 67, 42)
    println(maior(minhaLista)) // Saída: 67
	println(maior(listaVazia)) // Saída: 0
	println(maior(listaVazia2)) // Saída: 0
  }
}