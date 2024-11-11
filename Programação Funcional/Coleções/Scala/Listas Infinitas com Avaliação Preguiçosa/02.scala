object Main extends App {
  // Define uma lista infinita de números ímpares
  lazy val numerosImpares: LazyList[Int] = LazyList.from(1, 2)

  // Obtém os primeiros 10 números ímpares e os converte em uma List
  val primeiros10Impares = numerosImpares.take(10).toList

  // Exibe os primeiros 10 números ímpares
  println(s"Os primeiros 10 números ímpares: $primeiros10Impares")
}