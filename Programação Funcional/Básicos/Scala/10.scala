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

  // Função que divide a lista de anos bissextos em duas partes
  def divideAnosBissextos: (List[Int], List[Int]) = {
    val half = anosBissextos.length / 2
    anosBissextos.splitAt(half)
  }

  // Função principal para exibir a tupla com as duas metades
  def main(args: Array[String]): Unit = {
    println(divideAnosBissextos)
  }
}
