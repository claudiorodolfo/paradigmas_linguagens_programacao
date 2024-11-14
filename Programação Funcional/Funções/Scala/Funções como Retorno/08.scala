object Main extends App {
  def areaRetangulo(destino: String): (String, Double, Double) => Double = {
    (origem: String, base: Double, altura: Double) =>
      (origem, destino) match {
        case ("cm", "cm") | ("m", "m") => base * altura
        case ("cm", "m") => base * altura / Math.pow(10, 4)  // Converte de cm² para m²
        case ("m", "cm") => base * altura * Math.pow(10, 4)  // Converte de m² para cm²
        case _ => throw new IllegalArgumentException("Unidade de destino inválida")
      }
  }

  // Testando a função
  val areaEmMetro = areaRetangulo("m")
  println(s"${areaEmMetro("m", 2.0, 4.0)} m²")    // Saída esperada: 8.0 m²
  println(s"${areaEmMetro("cm", 200.0, 400.0)} m²") // Saída esperada: 8.0 m²
}
