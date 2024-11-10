object Main {
  // Função que forneçe uma temperatura em graus Fahrenheit a partir de uma temperatura em graus Celsius
  def celsiusParaFahrenheit (x: Double): Double = x * 1.8 + 32
 
  // Função principal
  def main(args: Array[String]): Unit = {
    println(celsiusParaFahrenheit(0))    //32
    println(celsiusParaFahrenheit(100))  //212
    println(celsiusParaFahrenheit(37.8)) //aproximadamente 100
  }
}