object Main {
  //Faça uma função que recebe dois valores e retorna o menor entre eles.
  def menor(a: Double, b: Double): Double = if (a < b) a else b

  def main(args: Array[String]): Unit = {
    val x = 5
    val y = 10
	val z = 3
    println(s"O menor entre $x, $y, e $z é: ${menor(menor(x, y), z)}")
  }
}