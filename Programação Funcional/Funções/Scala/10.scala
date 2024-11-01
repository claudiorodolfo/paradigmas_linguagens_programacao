object Main {
  //Faça uma função que recebe dois valores e retorna o menor.
  def menor(a: Double, b: Double): Double = if (a < b) a else b

  def main(args: Array[String]): Unit = {
    val x = 5
    val y = 10
    println(s"O menor entre $x e $y é: ${menor(x, y)}")
  }
}