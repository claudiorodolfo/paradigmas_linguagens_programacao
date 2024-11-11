object Main {
  // Função que recebe uma lista qualquer e retorna o número de elementos na lista.
  def nroElementos[A](lista: List[A]): Int = lista match {
    case List() => 0
    case cabeca :: cauda => 1 + nroElementos(cauda)
  }
  
  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 4, 5)
    println(nroElementos(minhaLista)) // Saída: 5
  }
}