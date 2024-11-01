object Main {
  // Função que determina o tipo do triângulo
  def tipoTriangulo(x: Double, y: Double, z: Double): String = {
    if (x <= 0 || y <= 0 || z <= 0) {
      "Não é um triângulo"
    } else if (x + y <= z || x + z <= y || y + z <= x) {
      "Não é um triângulo"
    } else if (x == y && y == z) {
      "Equilátero"
    } else if (x == y || y == z || x == z) {
      "Isósceles"
    } else {
      "Escaleno"
    }
  }

  // Exemplos de uso
  def main(args: Array[String]): Unit = {
    println(tipoTriangulo(3, 3, 3))  // "Equilátero"
    println(tipoTriangulo(3, 4, 3))  // "Isósceles"
    println(tipoTriangulo(3, 4, 5))  // "Escaleno"
    println(tipoTriangulo(1, 2, 3))  // "Não é um triângulo"
  }
}
