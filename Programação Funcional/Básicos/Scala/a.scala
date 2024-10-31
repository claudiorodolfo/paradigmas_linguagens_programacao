object Main {
  // Escreva uma função que aplique um filtro a uma lista de números, retornando apenas aqueles que são pares. 
  def filtrarPares(lista: List[Int]): List[Int] = {
    lista.filter(_ % 2 == 0)
  }

  def filtrarPares2(array: Array[Int]): Array[Int] = {
    array.filter(_ % 2 == 0)  
  }
  
  // Função principal para testar
  def main(args: Array[String]): Unit = {
    println(s"Resultado: ${filtrarPares(List(1,2,3,4,5,6,7,8,9))}")
    println(s"Resultado: ${filtrarPares2(Array(1,2,3,4,5,6,7,8,9)).mkString(", ")}")	
	//println(filtrarPares(List(1,2,3,4,5,6,7,8,9)))	
  }  
}