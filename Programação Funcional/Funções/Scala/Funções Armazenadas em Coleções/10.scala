object Main extends App {
  val obterNomeArquivo: String => String = caminho => caminho.split("/").last
  val removerExtensao: String => String = nomeArquivo => nomeArquivo.split("\\.").head
  val converterMinusculasArquivo: String => String = _.toLowerCase

  val pipelineArquivo = List(obterNomeArquivo, removerExtensao, converterMinusculasArquivo)

  def aplicarProcessamento(texto: String, funcoes: List[String => String]): String = {
    funcoes.foldLeft(texto)((resultado, funcao) => funcao(resultado))
  }

  println(aplicarProcessamento("/caminho/para/arquivo.TXT", pipelineArquivo)) // Saída: "arquivo"
}