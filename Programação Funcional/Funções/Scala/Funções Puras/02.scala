class Teste(val idade: Int) {}

object Main {
  // Função mult3 que retorna verdadeiro se o número for múltiplo de 3
  def mult3(x: Int): Boolean = x % 3 == 0
 
  // Função principal
  def main(args: Array[String]): Unit = {
  	val t = new Teste(30)
    println(s"O Resultado é: ${mult3(t.idade)}")
    //println(mult3(10)) // Deve retornar false
  }
}