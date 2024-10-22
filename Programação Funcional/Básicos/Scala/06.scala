object Main {
  // Função que recebe um tipo Integer e retorna ele dividido por 2
  def dividePor2(x: Int): Int = x / 2

  // Função principal para testar
  def main(args: Array[String]): Unit = {
    println(dividePor2(20))  // Deve retornar 10
    println(dividePor2(21))  // Deve retornar 10
  }
}