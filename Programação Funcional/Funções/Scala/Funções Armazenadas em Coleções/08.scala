object Main extends App {
  val converterMaiusculasCodigo: String => String = _.toUpperCase
  val removerCaracteresEspeciais: String => String = _.replaceAll("[^A-Z0-9]", "")
  val adicionarPrefixo: String => String = codigo => s"PROD-$codigo"

  val pipelineCodigo = List(converterMaiusculasCodigo, removerCaracteresEspeciais, adicionarPrefixo)

  def aplicarProcessamento(texto: String, funcoes: List[String => String]): String = {
    funcoes.foldLeft(texto)((resultado, funcao) => funcao(resultado))
  }

  println(aplicarProcessamento("abc-123!", pipelineCodigo)) // Saída: PROD-ABC123
}