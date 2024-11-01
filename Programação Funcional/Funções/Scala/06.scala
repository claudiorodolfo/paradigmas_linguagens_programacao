object Main {
  // Função que recebe um tipo Integer e retorna ele dividido por 2
  def dividePor2(x: Int): Double = x / 2.0

  // Função principal
  def main(args: Array[String]): Unit = {
    println(dividePor2(20))  // Deve retornar 10
    println(dividePor2(21))  // Deve retornar 10
  }
}