object Main extends App {
  // Define uma lista infinita de números naturais
  lazy val numerosNaturais: LazyList[Int] = LazyList.from(1)

  // Obtém os primeiros 10 números naturais e os converte em uma List
  val primeiros10 = numerosNaturais.take(10).toList

  // Exibe os primeiros 10 números naturais
  println(s"Os primeiros 10 números naturais: $primeiros10")
}
