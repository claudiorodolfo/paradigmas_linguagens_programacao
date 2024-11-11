//Usando o BitInt conseguimos gerar até 20! = 2.432.902.008.176.640.000. O tipo BigInt só vai até 9.223.372.036.854.775.807.
object Main extends App {
  // Define uma lista infinita de fatoriais
  lazy val fatoriais: LazyList[BigInt] = LazyList.iterate((BigInt(1), BigInt(1))) {
    case (acc, n) => (acc * n, n + 1)
  }.map { t => t._1 }

  // Obtém os primeiros 20 fatoriais e os converte em uma List
  val primeiros20 = fatoriais.take(20).toList

  // Exibe os primeiros 20 fatoriais
  println(s"Os primeiros 20 fatoriais: $primeiros20")
}

