object Main {
  // Função para calcular o máximo divisor comum (MDC)
  def mdc(a: Int, b: Int): Int = {
    if (b == 0) a // Caso base: se b é zero, retorna a
    else mdc(b, a % b) // Chamada recursiva
  }

  // Função para calcular o mínimo múltiplo comum (MMC)
  def mmc(a: Int, b: Int): Int = {
    if (a == 0 || b == 0) 0 // Se um dos números for zero, o MMC é zero
    else Math.abs(a * b) / mdc(a, b) // Calcula o MMC usando a relação com o MDC
  }
  
  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(mmc(4, 6)) // Saída: 12
    println(mmc(5, 10)) // Saída: 10
    println(mmc(0, 5)) // Saída: 0 (qualquer número com zero é zero)
    println(mmc(7, 3)) // Saída: 21
  }
}