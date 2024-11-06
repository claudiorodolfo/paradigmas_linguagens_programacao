object Main {
  //Crie uma função que conte o número de dígitos em um inteiro n. Por exemplo, contarDigitos(12345) deve retornar 5.
  def contarDigitos(n: Int): Int = {
    if (n < 0) contarDigitos(-n) // Se o número for negativo, converte para positivo
    else if (n < 10) 1 // Caso base: um dígito
    else 1 + contarDigitos(n / 10) // Divida por 10 e conte o próximo dígito
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(contarDigitos(12345))  // Saída: 5
    println(contarDigitos(0))      // Saída: 1
    println(contarDigitos(-9876))  // Saída: 4
  }
}