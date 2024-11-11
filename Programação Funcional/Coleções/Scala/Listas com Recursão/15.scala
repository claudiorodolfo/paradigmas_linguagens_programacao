object Main {
  //Função que retorna true se todos os elementos da lista forem menores ou iguais ao limite, e false caso contrário.
  def todosMenoresOuIguais(lista: List[Int], limite: Int): Boolean = lista match {
    case Nil => true
    case cabeca :: cauda =>
      if (cabeca <= limite) todosMenoresOuIguais(cauda, limite)
      else false
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val minhaLista = List(1, 2, 3, 4, 5)
    println(todosMenoresOuIguais(minhaLista, 5)) // Saída: true
    println(todosMenoresOuIguais(minhaLista, 4)) // Saída: false	
  }
}