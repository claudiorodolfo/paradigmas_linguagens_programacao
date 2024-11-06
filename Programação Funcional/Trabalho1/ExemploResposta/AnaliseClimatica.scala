//Temperaturas médias em toda a base de dados: Calcule a temperatura média (média entre a máxima e a mínima) de todos os registros. Exiba apenas o valor da média.

object Main {

  case class RegistroClima(
    data: String,
    cidade: String,
    tempMax: Double,
    tempMin: Double,
    precipitacao: Double,
    umidade: Double,
    velocidadeVento: Double
  )

  def main(args: Array[String]): Unit = {
    val registros = List(
      RegistroClima("2024-01-01", "São Paulo", 30.0, 20.0, 5.0, 80.0, 15.0),
      RegistroClima("2024-01-02", "Rio de Janeiro", 32.0, 22.0, 0.0, 75.0, 10.0),
      RegistroClima("2024-01-03", "Curitiba", 25.0, 15.0, 2.5, 85.0, 12.0),
      RegistroClima("2024-01-04", "Brasília", 28.0, 18.0, 3.0, 70.0, 8.0)
    )

    val mediaTemperaturaGeral = registros
      .map(registro => (registro.tempMax + registro.tempMin) / 2) // Média por registro
      .sum / registros.length // Média de todas as médias

    println(f"Temperatura média geral: $mediaTemperaturaGeral%.2f°C")
  }
  //Saída:
  //Temperatura média geral: 23.75°C
}
