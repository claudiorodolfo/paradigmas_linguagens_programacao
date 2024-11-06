//Essa abordagem torna a função filtrarFuncionarios reutilizável para qualquer critério de filtragem.
object Main extends App {
	case class Funcionario(nome: String, pontuacao: Int)

	val funcionarios = List(
		Funcionario("Alice", 85),
		Funcionario("Bruno", 65),
		Funcionario("Carlos", 90)
	)

	// Função de avaliação com base em um critério de pontuação
	def filtrarFuncionarios(funcionarios: List[Funcionario], criterio: Funcionario => Boolean): List[Funcionario] = {
		funcionarios.filter(criterio)
	}

	// Funcionários com pontuação acima de 80
	val funcionariosAcima80 = filtrarFuncionarios(funcionarios, (funcionario: Funcionario) => funcionario.pontuacao >= 80)
	
	println(s"Funcionários com pontuação acima de 80: $funcionariosAcima80")
	// Saída: List(Funcionario("Alice",85), Funcionario("Carlos",90))

}