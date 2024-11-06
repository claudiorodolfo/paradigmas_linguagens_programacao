object Main extends App {
	val descontoEstudante = (preco: Double) => preco * 0.9
	val descontoBlackFriday = (preco: Double) => preco * 0.8
	val descontoVIP = (preco: Double) => preco * 0.85

	// Exemplo de uso
	val precoOriginal = 100.0
	val tipoDesconto = "Black Friday" // pode ser "Estudante", "Black Friday" ou "VIP"

	val precoFinal = tipoDesconto match {
		case "Estudante" => descontoEstudante(precoOriginal)
		case "Black Friday" => descontoBlackFriday(precoOriginal)
		case "VIP" => descontoVIP(precoOriginal)
	}
	println(s"Preço com desconto: $precoFinal")
}