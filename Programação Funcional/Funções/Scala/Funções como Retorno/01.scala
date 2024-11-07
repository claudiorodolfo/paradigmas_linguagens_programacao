//Função que Retorna um Multiplicador Personalizado: Retorna uma função que multiplica um número por um valor específico.

object Main extends App {
  def multiplica(x: Int): Int => Int = {
    (y: Int) => x * y
  }

  val dobro = multiplica(2)
  val triplo = multiplica(3)
  println(triplo(10)) // Saída: 30
}