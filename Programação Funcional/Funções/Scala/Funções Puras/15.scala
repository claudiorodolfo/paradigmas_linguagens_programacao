object Main {
  // Função que tem como entrada o valor total da passagem e a idade do passageiro e produz o valor a ser pago. O preço de uma passagem de avião em um trecho pode variar dependendo da idade do passageiro. Pessoas com 60 anos ou mais pagam 60% do preço total. Crianças até 10 anos pagam 50% e bebês (abaixo de 2 anos) pagam 10%. 

  def calcularValorPassagem(precoTotal: Double, idade: Int): Double = {
    idade match {
      case _ if idade >= 60 => precoTotal * 0.6   // Desconto de 40% para 60 anos ou mais
      case _ if idade <= 1  => precoTotal * 0.1   // Desconto de 90% para bebês
      case _ if idade <= 10 => precoTotal * 0.5   // Desconto de 50% para crianças até 10 anos
      case _            => precoTotal         // Sem desconto para demais idades
    }
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val precoTotal = 100.0
    val idade = 65
    println(s"Valor a ser pago: R$$ ${calcularValorPassagem(precoTotal, idade)}")
  }
}