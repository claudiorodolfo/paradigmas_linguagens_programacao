object Main extends App {
		
	case class Produto(id: Int, nome: String, preco: Double, popularidade: Int, dataLancamento: String)

	def classificarProdutos(produtos: List[Produto], criterio: Produto => Double): List[Produto] = {
		produtos.sortBy(criterio)
	}

	// Exemplo de uso:
	val produtos = List(
		Produto(1, "ProdutoA", 15.0, 10, "2023-03-15"),
		Produto(2, "ProdutoB", 30.0, 8, "2023-02-10"),
		Produto(3, "ProdutoC", 10.0, 5, "2023-01-10")
	)

	// Classificação por preço
	val produtosPorPreco = classificarProdutos(produtos, (produto: Produto) => produto.preco)
	
	println(produtosPorPreco)
	// Saída esperada:
	// List(Produto(3, "ProdutoC", 10.0, 5, "2023-01-10"), Produto(1, "ProdutoA", 15.0, 10, "2023-03-15"), Produto(2, "ProdutoB", 30.0, 8, "2023-02-10"))
}