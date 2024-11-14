object Main extends App {
  def conversorTemperatura(destino: String): (String, Double) => Double = {
    (origem: String, temp: Double) =>
      (origem, destino) match {
        case ("Celsius", "Fahrenheit") => temp * 9 / 5 + 32
        case ("Celsius", "Kelvin") => temp + 273.0
        case ("Fahrenheit", "Celsius") => (temp - 32) * 5 / 9
        case ("Fahrenheit", "Kelvin") => (temp - 32) * 5 / 9 + 273.0
        case ("Kelvin", "Celsius") => temp - 273.0
        case ("Kelvin", "Fahrenheit") => (temp - 273.0) * 9 / 5 + 32
        case _ => throw new IllegalArgumentException("Unidade de destino inválida")
      }
  }

  // Testando a função
  val paraCelsius = conversorTemperatura("Celsius")
  println(paraCelsius("Fahrenheit", 32)) // Saída esperada: 0.0
  println(paraCelsius("Fahrenheit", 212)) // Saída esperada: 100.0
  println(paraCelsius("Kelvin", 273)) // Saída esperada: 0.0
  println(paraCelsius("Kelvin", 373)) // Saída esperada: 100.0  
}
