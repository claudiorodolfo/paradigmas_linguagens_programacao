object Main extends App {
	val soma = (a: Int, b: Int) => a + b
	val subtracao = (a: Int, b: Int) => a - b
	val multiplicacao = (a: Int, b: Int) => a * b
	val divisao = (a: Int, b: Int) => if (b != 0) a / b else "Divisão por zero"

	// Exemplo de uso
	val numero1 = 8
	val numero2 = 2

	println(s"Soma: ${soma(numero1, numero2)}")
	println(s"Subtração: ${subtracao(numero1, numero2)}")
	println(s"Multiplicação: ${multiplicacao(numero1, numero2)}")
	println(s"Divisão: ${divisao(numero1, numero2)}")
}