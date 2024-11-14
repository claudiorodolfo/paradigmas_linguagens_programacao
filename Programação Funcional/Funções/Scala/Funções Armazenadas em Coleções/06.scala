object Main extends App {
  val celsiusParaFahrenheit: (Double => Double) = (celsius: Double) => celsius * 9 / 5 + 32
  val fahrenheitParaKelvin:  (Double => Double) = (fahrenheit: Double) => (fahrenheit + 459.67) * 5 / 9

  val conversaoTemperatura = List(celsiusParaFahrenheit, fahrenheitParaKelvin)

  def aplicarConversoes(temperatura: Double, funcoes: List[Double => Double]): Double = {
    funcoes.foldLeft(temperatura)((temp, conversao) => conversao(temp))
  }

  println(aplicarConversoes(25.0, conversaoTemperatura)) // Conversão de Celsius para Kelvin
}