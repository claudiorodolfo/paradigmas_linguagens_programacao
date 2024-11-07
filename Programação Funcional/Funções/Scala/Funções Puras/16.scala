object Main {
  // Função que verifica se um número é primo
  def isPrimo(n: Int): Boolean = {
    if (n <= 1) false // Números menores ou iguais a 1 não são primos
    //Aqui, (2 to math.sqrt(n).toInt) cria um intervalo de números começando em 2 até o valor da raiz quadrada de n convertido para inteiro.
    //O método forall testa se a condição n % x != 0 (ou seja, n não é divisível por x) é true para todos os valores de x no intervalo.
    //Se n não for divisível por nenhum dos números entre 2 e a raiz quadrada de n, então forall retorna true, indicando que n é primo.
	//forall é a função inversa da exists
    else (2 to math.sqrt(n).toInt).forall(x => n % x != 0) // Verifica se n não é divisível por nenhum número até a raiz quadrada de n
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
	//println((0 to 10).mkString(" "))
	
	//(0 to 10).foreach(println)
	
	range(intervalo_fechado, intervalo_aberto)
	//val lista = List.range(0, 11)
    //println(lista.mkString(" "))
	
    println(isPrimo(2))   // true
    println(isPrimo(3))   // true
    println(isPrimo(4))   // false
    println(isPrimo(17))  // true
    println(isPrimo(20))  // false
    println(isPrimo(29))  // true
  }
}