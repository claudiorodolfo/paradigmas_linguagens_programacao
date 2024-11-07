//Gerador de Funções de Formatação de Strings: 
object Main extends App {
  def getFuncaoFormatadora(style: String): String => String = {
    style.toLowerCase match {
      case "uppercase" => (text: String) => text.toUpperCase
      case "lowercase" => (text: String) => text.toLowerCase
      case "titlecase" => (text: String) => text.split(" ").map(x => x.capitalize).mkString(" ")
      case _           => (text: String) => text
    }
  }

  val formatadorTitulo = getFuncaoFormatadora("titlecase")
  println(formatadorTitulo("hello scala world")) // Saída: Hello Scala World
}