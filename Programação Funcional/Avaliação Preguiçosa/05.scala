//Usando Int só conseguimos gerar até 12! = 479.001.600. O tipo Int só vai até 2.147.483.647 
object Main extends App {
  // Define uma lista infinita de fatoriais usando Int
  lazy val fatoriais: LazyList[Int] = LazyList.iterate((1, 1)) {
    case (acc, n) => (acc * n, n + 1)
  }.map { t => t._1 }

  // Obtém os primeiros 12 fatoriais e os converte em uma List
  val primeiros12 = fatoriais.take(12).toList

  // Exibe os primeiros 12 fatoriais
  println(s"Os primeiros 12 fatoriais: $primeiros12")
}