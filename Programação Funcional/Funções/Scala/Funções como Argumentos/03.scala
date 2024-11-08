//Essa abordagem torna a função calcularTotalComBonus reutilizável para qualquer critério de filtragem.
object Main extends App {
	case class Venda(valor: Double, cidade: String)

	val vendas = List(
		Venda(1200.0, "São Paulo"),
		Venda(800.0, "Rio de Janeiro"),
		Venda(2000.0, "São Paulo")
	)

	// Função que calcula o total com bônus para vendas com base em um critério
	def calcularTotalComBonus(vendas: List[Venda], filtro: Venda => Boolean, bonus: Double): Double = {
	vendas.filter(filtro).map(x => x.valor * (1 + bonus)).sum
	}

	// Total com bônus para vendas acima de 1000
	val totalComBonusAcima1000 = calcularTotalComBonus(vendas, (venda: Venda) => venda.valor > 1000, 0.1)
	// Total com bônus para vendas em São Paulo
	val totalComBonusSaoPaulo = calcularTotalComBonus(vendas, (venda: Venda) => venda.cidade == "São Paulo", 0.1)
	
	println(s"Total com bônus para vendas acima de 1000: $totalComBonusAcima1000") // Saída: 3300.0
	println(s"Total com bônus para vendas em São Paulo: $totalComBonusSaoPaulo") // Saída: 3300.0
}
