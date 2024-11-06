object Main extends App {
	val celsiusParaFahrenheit = (c: Double) => c * 9/5 + 32
	val fahrenheitParaCelsius = (f: Double) => (f - 32) * 5/9
	val celsiusParaKelvin = (c: Double) => c + 273.0

	// Exemplo de uso
	val temperatura = 30.0
	val conversaoEscolhida = 1  // 1 - Celsius para Fahrenheit, 2 - Fahrenheit para Celsius, 3 - Celsius para Kelvin

	val resultado = conversaoEscolhida match {
		case 1 => celsiusParaFahrenheit(temperatura)
		case 2 => fahrenheitParaCelsius(temperatura)
		case 3 => celsiusParaKelvin(temperatura)
	}
	println(s"Temperatura convertida: $resultado")
}