object Main {
  // Função que retorna true se a entrada for múltiplo de 5, false caso contrário
  def mult5(x: Int): Boolean = x % 5 == 0

  def mult5(x: Int): Boolean = {
	x % 5 == 0
  }
	
  // Função principal para testar
  def main(args: Array[String]): Unit = {
    println(mult5(9))  // Deve retornar False
    println(mult5(10)) // Deve retornar True
  }
}