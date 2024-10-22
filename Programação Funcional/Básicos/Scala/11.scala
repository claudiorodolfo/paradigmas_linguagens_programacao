object Main {
  // Função que concatena duas strings com um espaço entre elas
  def concatenarStrings(str1: String, str2: String): String = {
    str1 + " " + str2
  }

  // Função principal para testar o concatenador de strings
  def main(args: Array[String]): Unit = {
    val string1 = "Olá"
    val string2 = "Mundo"
    println(concatenarStrings(string1, string2))
  }
}