object Main extends App {
  // Define uma lista infinita de anos bissextos
  lazy val anosBissextos: LazyList[Int] = LazyList.from(1).filter(ano => (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0))

  // Obtém os primeiros 10 anos bissextos e os converte em uma List
  val primeiros10Bissextos = anosBissextos.take(10).toList

  // Exibe os primeiros 10 anos bissextos
  println(s"Os primeiros 10 anos bissextos: $primeiros10Bissextos")
}
