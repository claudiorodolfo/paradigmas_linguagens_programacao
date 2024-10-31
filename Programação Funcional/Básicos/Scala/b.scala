object Main {
  // Crie uma função que some todos os elementos de uma lista utilizando recursão.
  def somaLista(lista: List[Int]): Int = lista match {
    case Nil => 0
    case x :: xs => x + somaLista(xs)
  }

 // Crie uma função que some todos os elementos de um array utilizando recursão.
  def somaArray(array: Array[Int], index: Int = 0): Int = {
    if (index >= array.length)  // Verifica se o índice está fora dos limites do array
      0
    else
      array(index) + somaArray(array, index + 1) // Soma o elemento atual e chama a função recursivamente com o próximo índice
  }
  
  // Função principal para testar
  def main(args: Array[String]): Unit = {
    println(s"Resultado: ${somaArray(Array(1,2,3,4,5,6,7,8,9))}")
    println(s"Resultado: ${somaLista(List(1,2,3,4,5,6,7,8,9))}")
	//println(somaArray(Array(1,2,3,4,5,6,7,8,9)))	
    //println(somaLista(List(1,2,3,4,5,6,7,8,9)))	
  }  
}
