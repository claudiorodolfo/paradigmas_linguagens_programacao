object Main extends App {
  val garantirLimite: Double => Double = leitura => if (leitura > 100) 100 else leitura
  val normalizar: Double => Double = leitura => leitura / 100
  val ajustarPrecisao: Double => Double = leitura => BigDecimal(leitura).setScale(2,   BigDecimal.RoundingMode.HALF_UP).toDouble

  val processamentoSensor = List(garantirLimite, normalizar, ajustarPrecisao)

  def aplicarConversoes(valor: Double, funcoes: List[Double => Double]): Double = {
    funcoes.foldLeft(valor)((v, conversao) => conversao(v))
  }

  println(aplicarConversoes(120.75, processamentoSensor)) // Processamento de leitura do sensor
}