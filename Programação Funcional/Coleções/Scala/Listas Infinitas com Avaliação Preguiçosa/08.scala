object Main extends App {
  // Define uma lista infinita de números de Fibonacci
  lazy val numerosFibonacci: LazyList[BigInt] = BigInt(0) #:: BigInt(1) #:: numerosFibonacci.zip(numerosFibonacci.tail).map { case (a, b) => a + b }

  // Obtém os primeiros 10 números de Fibonacci e os converte em uma List
  val primeiros10Fibonacci = numerosFibonacci.take(10).toList

  // Exibe os primeiros 10 números de Fibonacci
  println(s"Os primeiros 10 números de Fibonacci: $primeiros10Fibonacci")
}
