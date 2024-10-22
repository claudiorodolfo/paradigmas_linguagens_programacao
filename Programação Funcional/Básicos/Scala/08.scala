object Main {
  // Função que verifica se um ano é bissexto
  def isBissexto(ano: Int): Boolean = {
    ano % 400 == 0 || (ano % 100 != 0 && ano % 4 == 0)
  }

  // Função que gera a lista de anos bissextos desde o ano 1 até o ano atual
  def anosBissextos(atual: Int): List[Int] = {
    (1 to atual).filter(isBissexto).toList
  }

  // Função principal para exibir a lista
  def main(args: Array[String]): Unit = {
    val anoAtual = 2024  // Substituir por uma função para obter o ano atual, se disponível
    println(anosBissextos(anoAtual))
  }
}