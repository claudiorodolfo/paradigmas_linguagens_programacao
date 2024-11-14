object Main extends App {
  val removerEspacos: (String => String) = (x: String) => x.trim
  val converterMaiusculas: (String => String) = (x: String) => x.toUpperCase
  val removerPontuacao: (String => String) = (x: String) => x.replaceAll("[^\\w\\s]", "")

  val processamentoTexto = List(removerEspacos, converterMaiusculas, removerPontuacao)

  def aplicarProcessamento(texto: String, funcoes: List[String => String]): String = {
    funcoes.foldLeft(texto)((resultado, funcao) => funcao(resultado))
  }

  println(aplicarProcessamento("  Olá, mundo! ", processamentoTexto)) // "OLA MUNDO"
}