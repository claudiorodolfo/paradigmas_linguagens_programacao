object Main {
  // Função que verifica se um ano é bissexto
  def isBissexto(ano: Int): Boolean = {
    ano % 400 == 0 || (ano % 100 != 0 && ano % 4 == 0)
  }

  // Função que gera uma lista dos primeiros 10 anos bissextos
  def primeirosBissextos: List[Int] = {
    Stream.from(1).filter(isBissexto).take(10).toList
  }

  // Função principal para exibir os 10 primeiros anos bissextos
  def main(args: Array[String]): Unit = {
    println(primeirosBissextos)
  }
}
