object Main {
  /**
    * Cálculo das raízes de uma equação do segundo grau, definida pelos valores de a, b, c.
    * Retorna uma tupla com as raízes (x1, x2).
    * Lança uma exceção se as raízes forem negativas.
    */
  def raizSegGrau(a: Double, b: Double, c: Double): (Double, Double) = {
    val delta = b * b - 4 * a * c
    if (delta < 0) throw new IllegalArgumentException("Raízes negativas!") 
    else {
      val x1 = (-b - math.sqrt(delta)) / (2 * a)
      val x2 = (-b + math.sqrt(delta)) / (2 * a)
      (x1, x2)
    }
  }

  def main(args: Array[String]): Unit = {
    // Teste com raízes reais
    println(raizSegGrau(1, -3, 2))  // Deverá retornar (1.0, 2.0)

    // Teste com raízes iguais
    println(raizSegGrau(1, -2, 1))  // Deverá retornar (1.0, 1.0)

    // Teste com erro de raízes negativas
    try {
      println(raizSegGrau(1, 1, 1))  // Deverá lançar um erro "Raízes negativas!"
    } catch {
      case e: IllegalArgumentException => println(e.getMessage)
    }
  }
}
