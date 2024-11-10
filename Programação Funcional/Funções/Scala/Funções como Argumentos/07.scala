object Main extends App{
  val aplicarDuasVezes = (funcao: Int => Int, x: Int) => funcao(funcao(x))
  
  val dobro = (x: Int) => x * 2
  
  println(aplicarDuasVezes(dobro, 3)) // Deve imprimir 12
}
