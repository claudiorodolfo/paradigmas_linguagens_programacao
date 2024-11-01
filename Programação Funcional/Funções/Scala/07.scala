import scala.math._

object Main {
  // Função que calcula o seno da metade do ângulo usando a identidade trigonométrica
  def senoMetadeAngulo(x: Double): (Double, Double) = {
    val resultado = sqrt((1 - cos(x)) / 2)
    (resultado, -resultado)
  }

  // Função principal
  def main(args: Array[String]): Unit = {
    val angulo = 60
    val (pos, neg) = senoMetadeAngulo(angulo)
    println(f"sen(x/2) é: +$pos%.4f e $neg%.4f")
  }
}
