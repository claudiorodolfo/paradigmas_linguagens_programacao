object Main extends App {
  val verificarNome: Map[String, String] => Boolean = campos => campos.get("nome").exists(_.nonEmpty)
  val verificarEmail: Map[String, String] => Boolean = campos => campos.get("email").exists(_.contains("@"))
  val verificarTelefone: Map[String, String] => Boolean = campos => campos.get("telefone").exists(_.nonEmpty)

  val validacoesFormulario = List(verificarNome, verificarEmail, verificarTelefone)

  def validarFormulario(campos: Map[String, String], validacoes: List[Map[String, String] => Boolean]): Boolean = {
    validacoes.forall(validacao => validacao(campos))
  }

  val formulario = Map("nome" -> "João", "email" -> "joao@example.com", "telefone" -> "123456789")
  println(validarFormulario(formulario, validacoesFormulario)) // Saída: true
}