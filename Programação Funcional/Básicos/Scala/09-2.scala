object Main {
  // Função que verifica se um ano é bissexto
  def isBissexto(ano: Int): Boolean = {
    ano % 400 == 0 || (ano % 100 != 0 && ano % 4 == 0)
  }

  // Função que gera a lista de anos bissextos desde o ano 1 até o ano atual
  def anosBissextos: List[Int] = {
    val anoAtual = 2024 // Substituir por uma função para obter o ano atual, se disponível
    (1 to anoAtual).filter(isBissexto).toList
  }

  // Função que encontra os 10 últimos anos bissextos
  def ultimos10AnosBissextos: List[Int] = {
    anosBissextos.takeRight(10)
  }

  // Função principal para exibir os 10 últimos anos bissextos
  def main(args: Array[String]): Unit = {
    println(ultimos10AnosBissextos)
  }
}
