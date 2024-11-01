object Main {
  // Função que calcula a soma dos dígitos
  def somaDigitos(n: Int): Int = {
    if (n < 0) somaDigitos(-n) // Se o número for negativo, converte para positivo
    else if (n == 0) 0          // A soma dos dígitos de 0 é 0
    else (n % 10) + somaDigitos(n / 10) // Adiciona o último dígito e chama a função recursivamente
  }

  // Função que calcula a persistência aditiva
  def persistenciaAditiva(n: Int): Int = {
    def persistir(n: Int, cont: Int): Int = {
      if (n < 10) cont // Se n já é um dígito único, retorna o contador
      else persistir(somaDigitos(n), cont + 1) // Soma os dígitos e incrementa o contador
    }
    persistir(n, 0) // Chama a função auxiliar com contador inicial 0
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(persistenciaAditiva(39))      // 3
    println(persistenciaAditiva(999))     // 4
    println(persistenciaAditiva(4))       // 0
    println(persistenciaAditiva(123456))  // 2
  }
}