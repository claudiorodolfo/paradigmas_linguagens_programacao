object Main extends App {
	val operacaoCondicional = (operacao: (Int, Int) => Int, condicao: (Int, Int) => Boolean, a: Int, b: Int) => {
		if (condicao(a, b)) operacao(a, b) else 0
	}
	
	val condicaoMaiorQue = (a: Int, b: Int) => a > b
	val condicaoIgual = (a: Int, b: Int) => a == b
	val operacaoSomar = (a: Int, b: Int) => a + b
	val operacaoMultiplicar = (a: Int, b: Int) => a * b
	
	println(operacaoCondicional(operacaoSomar, condicaoMaiorQue, 10, 5)) // Deve imprimir 15
	println(operacaoCondicional(operacaoMultiplicar, condicaoIgual, 10, 5)) // Deve imprimir 0
}