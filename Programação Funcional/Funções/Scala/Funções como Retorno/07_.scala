object Main extends App {
  def conversorTemperatura(destino: String): (String, Double) => Double = {
    
      destino match {
        case "Fahrenheit" => {
			(origem: String, temp: Double) =>
			  origem match {
				case "Celsius" => temp * 9 / 5 + 32
				case "Kelvin" => (temp - 273.0) * 9 / 5 + 32
			}
		}
		
        case "Kelvin" => {
			(origem: String, temp: Double) =>
			  origem match {
				case "Fahrenheit" => (temp - 32) * 5 / 9 + 273.0
				case "Celsius" => temp + 273.0
			}		
		}
		
        case "Celsius" => {
			(origem: String, temp: Double) =>
			  origem match {
				case "Fahrenheit" => (temp - 32) * 5 / 9
				case "Kelvin" => temp - 273.0
			}
		}
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
