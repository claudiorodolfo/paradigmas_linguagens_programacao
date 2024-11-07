//Gerador de Funções de Validação com Base no Tipo: Retorna uma função que valida um valor com base no tipo de dado.
object Main extends App {
  def getFuncaoValidacao(tipoDado: String): String => Boolean = {
    tipoDado.toLowerCase match {
      case "email" => (entrada: String) => entrada.contains("@") && entrada.contains(".")
      case "phone" => (entrada: String) => entrada.matches("\\d{11}")
      case _       => (entrada: String) => false
    }
  }

  val validadorEmail = getFuncaoValidacao("email")
  println(validadorEmail("test@example.com")) // Saída: true
}