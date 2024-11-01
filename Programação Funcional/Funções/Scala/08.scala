object Main {
  // Função que verifica se um ano é bissexto
  def isBissexto(ano: Int): Boolean = {
    ano % 400 == 0 || (ano % 100 != 0 && ano % 4 == 0)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    println(isBissexto(100))
    println(isBissexto(1900))	
    println(isBissexto(2000))
    println(isBissexto(2024))	
  }
}