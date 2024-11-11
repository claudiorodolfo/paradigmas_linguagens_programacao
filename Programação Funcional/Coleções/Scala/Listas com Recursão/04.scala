object Main {
  // Função para verificar se existe uma única ocorrência de um elemento em uma lista
  def unicaOcorrencia[A](elemento: A, lista: List[A]): Boolean = {
    def contar(lista: List[A]): Int = lista match {
      case Nil => 0
      case cabeca :: cauda => 
        (if (cabeca == elemento) 1 else 0) + contar(cauda)
    }
    contar(lista) == 1
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val lista1 = List(1, 2, 3, 2)
    val lista2 = List(3, 1)
    val lista3 = List(2)

    println(unicaOcorrencia(2, lista1)) // Saída: false
    println(unicaOcorrencia(2, lista2)) // Saída: false
    println(unicaOcorrencia(2, lista3)) // Saída: true	
  }
}