object Main {
  // Função que retorna true se a entrada for múltiplo de 3 e 5, false caso contrário
  def mult35(x: Int): Boolean = (x % 3 == 0) && (x % 5 == 0)

  // Função principal
  def main(args: Array[String]): Unit = {
    println(mult35(12))  // Deve retornar False
    println(mult35(15))  // Deve retornar True
  }
}
