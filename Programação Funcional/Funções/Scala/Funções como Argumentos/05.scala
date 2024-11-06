object Main extends App {
	
	def transformarTexto(texto: String, transformacao: (String => String)): String = {
		transformacao(texto)
	}

	def removerPontuacao(texto: String): String = texto.replaceAll("[^\\w\\s]", "")
	def paraMinusculas(texto: String): String = texto.toLowerCase
	def removerEspacosExtras(texto: String): String = texto.replaceAll("\\s+", " ").trim
	
	// Exemplo de uso:
	val textoOriginal = "  Olá, Mundo! Vamos explorar Scala.  "

	val textoTransformado1 = transformarTexto(textoOriginal, removerPontuacao _)
	val textoTransformado2 = transformarTexto(textoTransformado1, paraMinusculas _)
	val textoTransformado3 = transformarTexto(textoTransformado2, removerEspacosExtras _)
	
	println(s"\"${textoTransformado3}\"")	
	// Saída esperada: "ol mundo vamos explorar scala"

}