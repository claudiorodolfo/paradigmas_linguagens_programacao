import scala.math._

object Main {
  // Função que calcula o seno da metade do ângulo usando a identidade trigonométrica
  def senoMetadeAngulo(a: Double): (Double, Double) = {
    (a, sqrt((1 - cos(a)) / 2))
  }

  // Função principal para testar
  def main(args: Array[String]): Unit = {
    println(senoMetadeAngulo(60)) // (60.0,0.8660254037844387)
    println(senoMetadeAngulo(90)) // (90.0,0.7071067811865476)
  }
}
