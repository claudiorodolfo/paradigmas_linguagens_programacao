object Main {
  //Implemente uma função que calcule x vezes y, ou seja, x*y, sem usar operador de multiplicação nativa.
  def multiplicar(x: Int, y: Int): Int = {
    if (y == 0) 0 // Caso base: qualquer número multiplicado por zero é zero
    else if (y > 0) x + multiplicar(x, y - 1) // Caso positivo: soma x, y vezes
    else -multiplicar(x, -y) // Caso negativo: inverte o sinal para números negativos
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(multiplicar(5, 3))   // Saída: 15
    println(multiplicar(5, -3))  // Saída: -15
    println(multiplicar(-5, -3)) // Saída: 15
    println(multiplicar(5, 0))   // Saída: 0
  }
}