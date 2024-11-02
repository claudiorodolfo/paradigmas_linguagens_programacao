object Main {
  // Função para verificar se existe uma única ocorrência de um elemento em uma lista
  def unicaOcorrencia(a: Int, lista: List[Int]): Boolean = lista match {
    case Nil => false // Se a lista estiver vazia, retorna false
    case x :: xs =>
      if (x == a) {
        // Se o elemento atual for igual ao que estamos procurando
        if (unicaOcorrencia(a, xs)) false // Se o elemento já foi encontrado na parte restante, retorna false
        else true // Caso contrário, retorna true
      } else {        
        unicaOcorrencia(a, xs) // Se o elemento atual não é igual a 'a', continua verificando na lista
      }
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