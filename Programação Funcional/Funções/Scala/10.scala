object Main {
  // Função que verifica se três lados podem formar um triângulo
  def ehTriangulo(x: Float, y: Float, z: Float): Boolean = {
    (x + y > z) && (x + z > y) && (y + z > x)
  }

  // Função principal para testar ehTriangulo
  def main(args: Array[String]): Unit = {
    println(ehTriangulo(3, 4, 5))  // Deve retornar true
    println(ehTriangulo(1, 2, 3))  // Deve retornar false
  }
}
