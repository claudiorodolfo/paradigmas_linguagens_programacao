object Main {
  //Crie uma função que retorne o n-ésimo número da sequência de Fibonacci. Na sequência de Fibonacci, cada número é a soma dos dois números anteriores, com os dois primeiros números sendo 0 e 1.
  def fibonacci(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(fibonacci(0))  // Saída: 0
    println(fibonacci(1))  // Saída: 1
    println(fibonacci(5))  // Saída: 5
    println(fibonacci(10)) // Saída: 55
  }
}