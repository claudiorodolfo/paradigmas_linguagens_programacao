object Main {
  // Função para concatenar duas listas
  def concatena[A](lista1: List[A], lista2: List[A]): List[A] = lista1 match {
    case Nil => lista2 // Se a primeira lista estiver vazia, retorna a segunda lista
    case cabeca :: cauda => cabeca :: concatena(cauda, lista2) // Adiciona o primeiro elemento da lista1 e continua concatenando
}

  // Função principal
  def main(args: Array[String]): Unit = {
    val listaVazia1 = List.empty[Int]
    val listaVazia2 = List.empty[Int]
    val lista1 = List(1, 2)
    val lista2 = List(3, 4)

    println(concatena(listaVazia1, listaVazia2)) // Saída: List()
    println(concatena(lista1, lista2))           // Saída: List(1, 2, 3, 4)
  }
}