object Main extends App {
	val paraMaiscula = (s: String) => s.toUpperCase
	val contaPalavras = (s: String) => s.split(" ").length
	val textoReverso = (s: String) => s.reverse

	// Exemplo de uso
	val frase = "Scala é interessante"

	println(s"Maiúsculas: ${paraMaiscula(frase)}")
	println(s"Número de palavras: ${contaPalavras(frase)}")
	println(s"Inverso: ${textoReverso(frase)}")
}