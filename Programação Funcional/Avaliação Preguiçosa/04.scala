object Main extends App {
  // Define uma lista infinita de números primos usando um filtro
  lazy val numerosPrimos: LazyList[Int] = LazyList.from(2).filter(n => (2 until n).forall(d => n % d != 0))

  // Obtém os primeiros 10 números primos e os converte em uma List
  val primeiros10Primos = numerosPrimos.take(10).toList

  // Exibe os primeiros 10 números primos
  println(s"Os primeiros 10 números primos: $primeiros10Primos")
}