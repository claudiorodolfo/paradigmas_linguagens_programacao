object Main {
  //Função para calcular o máximo divisor comum de dois números inteiros a e b com o Algoritmo de Euclides.
  def mdc(a: Int, b: Int): Int = {
    if (b == 0) a // Caso base: se b é zero, o MDC é a
    else mdc(b, a % b) // Chamada recursiva: MDC(b, a % b)
  }
  
  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(mdc(48, 18)) // Saída: 6
    println(mdc(56, 98)) // Saída: 14
    println(mdc(101, 10)) // Saída: 1
    println(mdc(100, 0)) // Saída: 100 (qualquer número com zero é ele mesmo)
  }
}