object Main extends App {
  def arredondador(casas: Int): Double => Double = {
    val fator = math.pow(10, casas)
    (numero: Double) => { 
	  val truncado = (numero * fator).toLong
	  truncado / fator
	}
  }

  val duasCasas = arredondador(2)
  val tresCasas = arredondador(3)
  println(duasCasas(3.14159)) // Saída: 3.14
  println(tresCasas(3.14159)) // Saída: 3.141
}