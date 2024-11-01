object Main {
  //Função que receba dois inteiros a e b e retorne a soma de todos os números entre a e b, inclusive. Suponha que a <= b. Use recursão.
  def somaEntre(a: Int, b: Int): Int = {
    if (a > b) 0 // Caso base, although assumimos a <= b de acordo ao problema
    else a + somaEntre(a + 1, b) // Caso recursivo: soma a + soma dos números restantes
  }
  
  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(somaEntre(1, 5)) // Saída: 15 (1 + 2 + 3 + 4 + 5)
    println(somaEntre(3, 7)) // Saída: 25 (3 + 4 + 5 + 6 + 7)
    println(somaEntre(0, 0)) // Saída: 0 (soma de um único número)
    println(somaEntre(10, 10)) // Saída: 10 (soma de um único número)
  }
}