object Main {
  // Função que verifica se um número é primo
  def isPrimo(n: Int): Boolean = {
    if (n <= 1) false // Números menores ou iguais a 1 não são primos
    else (2 to math.sqrt(n).toInt).forall(x => n % x != 0) // Verifica se n não é divisível por nenhum número até a raiz quadrada de n
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(isPrimo(2))   // true
    println(isPrimo(3))   // true
    println(isPrimo(4))   // false
    println(isPrimo(17))  // true
    println(isPrimo(20))  // false
    println(isPrimo(29))  // true
  }
}