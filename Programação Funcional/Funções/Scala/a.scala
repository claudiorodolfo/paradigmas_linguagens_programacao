object Main {
  /**
    * A função média recebe dois parâmetros do tipo Double e retorna um Double
    * que é a média aritmética dos valores de entrada.
    */
  def media(x: Double, y: Double): Double = (x + y) / 2.0

  def main(args: Array[String]): Unit = {
    // Exemplos de teste
    println(media(10, 15))    // Deverá retornar 12.5
    println(media(20, 30))    // Deverá retornar 25.0
  }
}
