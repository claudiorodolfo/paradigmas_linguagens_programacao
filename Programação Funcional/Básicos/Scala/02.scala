object Main {
  // Função mult3 que retorna verdadeiro se o número for múltiplo de 3
  def mult3(x: Int): Boolean = x % 3 == 0

  // Função principal para testar
  def main(args: Array[String]): Unit = {
    println(mult3(9))  // Deve retornar true
    println(mult3(10)) // Deve retornar false
  }
}