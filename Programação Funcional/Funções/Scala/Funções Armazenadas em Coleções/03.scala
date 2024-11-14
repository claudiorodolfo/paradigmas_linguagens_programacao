object Main extends App {
  val dobrar: (Int => Int) = (x: Int) => x * 2
  val adicionar10: (Int => Int) = (x: Int) => x + 10
  val inverterSinal: (Int => Int) = (x: Int) => -x

  val operacoes = List(dobrar, adicionar10, inverterSinal)

  def aplicarOperacoes(valor: Int, operacoes: List[Int => Int]): Int = {
    operacoes.foldLeft(valor)((resultado, operacao) => operacao(resultado))
  }

  println(aplicarOperacoes(5, operacoes)) // Saída: -20
}