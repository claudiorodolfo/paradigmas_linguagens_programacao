object Main {
  // Função que calcula o fatorial de um número
  def fatorial(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("Fatorial de número negativo não é definido.")
    else if (n == 0) 1
    else n * fatorial(n - 1)
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(fatorial(5))  // 120
    println(fatorial(7))  // 5040
  }
}