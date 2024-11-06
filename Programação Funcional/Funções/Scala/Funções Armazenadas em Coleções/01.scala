//Exemplo prático do uso de: Funções Armazenadas em Estruturas de Dados
//Pipeline de Validação de Formulário: Suponha que estamos processando formulários com dados do usuário e queremos validar campos como "nome", "email" e "idade". Podemos armazenar uma série de funções de validação em uma lista e aplicá-las em sequência para garantir que os dados atendam aos critérios desejados.
//Essa abordagem torna o sistema de validação modular e fácil de adaptar a novos critérios de validação.
object Main extends App {
	case class Usuario(nome: String, email: String, idade: Int)

	val validarNome: Usuario => Boolean = usuario => usuario.nome.nonEmpty
	val validarEmail: Usuario => Boolean = usuario => usuario.email.contains("@")
	val validarIdade: Usuario => Boolean = usuario => usuario.idade >= 18

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
