object Main {

  def multiplicar(x: Int, y: Int): Int = {
    if (y == 0) 0
    else if (y > 0) x + multiplicar(x, y - 1)
    else -multiplicar(x, -y)
  }

  //Implemente uma função que calcule x elevado a y, ou seja, x^y, sem usar operadores de exponenciação ou multiplicação nativos.
  def exponencial(x: Int, y: Int): Int = {
    if (y == 0) 1 // Caso base: qualquer número elevado a 0 é 1
    else if (y > 0) multiplicar(x, exponencial(x, y - 1)) // x multiplicado por x^(y-1)
    else throw new IllegalArgumentException("Exponenciação para expoentes negativos não é suportada")
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(exponencial(2, 10))  // Saída: 1024
	println(exponencial(3, 4))  // Saída: 81
    println(exponencial(5, 0))  // Saída: 1
    println(exponencial(5, 3))  // Saída: 125
  }
}