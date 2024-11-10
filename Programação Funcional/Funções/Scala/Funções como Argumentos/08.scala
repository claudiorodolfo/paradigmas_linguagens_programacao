object Main extends App {
  val aplicarOperacao = (operacao: (Int, Int) => Int, a: Int, b: Int) => operacao(a, b)
  val multiplicar = (a: Int, b: Int) => a * b
  val menor = (a: Int, b: Int) => if (a < b) a else b
  println(aplicarOperacao(multiplicar, 3, 4)) // Deve imprimir 12
  println(aplicarOperacao(menor, 3, 4)) // Deve imprimir 3
}