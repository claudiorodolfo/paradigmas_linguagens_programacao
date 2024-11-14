object Main extends App {
	case class Usuario(nome: String, email: String, idade: Int)

	val validarNome:  (Usuario => Boolean) = (usuario: Usuario) => usuario.nome.nonEmpty
	val validarEmail: (Usuario => Boolean) = (usuario: Usuario) => usuario.email.contains("@")
	val validarIdade: (Usuario => Boolean) = (usuario: Usuario) => usuario.idade >= 18

	val validacoes = List(validarNome, validarEmail, validarIdade)

	def validarUsuario(usuario: Usuario, validacoes: List[Usuario => Boolean]): Boolean = {
		validacoes.forall(validacao => validacao(usuario))
	}

	// Testando com um usuário
	val usuario = Usuario("Maria", "maria@example.com", 22)
	val usuarioInvalido = Usuario("", "maria.example.com", 15)

	println(validarUsuario(usuario, validacoes))       // true, todos os critérios de validação foram atendidos
	println(validarUsuario(usuarioInvalido, validacoes)) // false, uma ou mais validações falharam
}
