object Main {
  // Função que retorna true se a entrada for menor que -1 ou (maior que 1 e múltiplo de 2)
  def condicao(x: Int): Boolean = (x < -1) || (x > 1 && x % 2 == 0)

  // Função principal
  def main(args: Array[String]): Unit = {
    println(condicao(-3))  // Deve retornar True
    println(condicao(4))   // Deve retornar True
    println(condicao(5))   // Deve retornar False
  }
}
