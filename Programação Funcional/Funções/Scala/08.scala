object Main {
  // Função que verifica se um ano é bissexto
  def isBissexto(ano: Int): Boolean = {
    ano % 400 == 0 || (ano % 100 != 0 && ano % 4 == 0)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    println(isBissexto(100))	//False
    println(isBissexto(1900))	//False
    println(isBissexto(2000))	//True
    println(isBissexto(2024))	//True
  }
}