object Main {
  // Função que determina se uma String é um palíndromo. A função deve retornar true se a palavra for a mesma de trás para frente, ignorando diferenças de maiúsculas e minúsculas.
  def isPalindromo(s: String): Boolean = {
    // Caso base: se a string é vazia ou tem um único caractere
    if (s.length <= 1) true
    else {
      // Compara o primeiro e o último caractere
      if ((s.head).toString().toLowerCase == (s.last).toString().toLowerCase) {
        // Chamada recursiva com a string sem o primeiro e o último caractere
        isPalindromo(s.substring(1, s.length - 1))
      } else {
        false // Não é um palíndromo
      }
    }
  }
  
  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(isPalindromo("racecar")) // Saída: true
    println(isPalindromo("hello")) // Saída: false
  }
}
