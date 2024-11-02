object Main {
  //Implemente uma função que calcule x dividido y, ou seja, x/y, sem usar operador de divisão nativa, usando apenas subtrações sucessivas.
  def dividir(dividendo: Int, divisor: Int): Int = {
    if (divisor == 0) throw new ArithmeticException("Divisão por zero não é permitida.")
    else if (dividendo < divisor) 0  // Se o dividendo for menor que o divisor, retorna 0
    else 1 + dividir(dividendo - divisor, divisor)  // Subtrai o divisor do dividendo e incrementa o contador
  }
  
  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(dividir(10, 2))  // Saída: 5
    println(dividir(7, 3))   // Saída: 2
    println(dividir(20, 4))  // Saída: 5
  }
}