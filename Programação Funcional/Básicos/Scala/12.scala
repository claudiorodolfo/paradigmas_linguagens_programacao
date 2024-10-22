object Main {
  // Função que converte uma string de dígitos em uma lista de inteiros
  def stringParaListaDeInteiros(str: String): List[BigInt] = {
    str.map(c => BigInt(c.toString)).toList
  }

  // Função principal para testar a conversão
  def main(args: Array[String]): Unit = {
    val str = "0123456789"
    val listaDeInteiros = stringParaListaDeInteiros(str)
    println(listaDeInteiros)
  }
}