//Exemplo prático do uso de: Funções como Retorno de Outras Funções
//Criação de Funções para Cálculos de Imposto: Em um sistema fiscal, cada tipo de produto pode ter uma taxa de imposto diferente. Podemos criar uma função que gera uma função de cálculo de imposto específica para cada taxa.
//A função calcularImposto retorna uma função específica para cada taxa de imposto, facilitando o cálculo de diferentes categorias.
object Main extends App {
	def calcularImposto(taxa: Double): Double => Double = {
	(valor: Double) => valor * taxa
	}

	val impostoEletronico = calcularImposto(0.2) // Função para aplicar 20% de imposto
	val impostoAlimento = calcularImposto(0.05) // Função para aplicar 5% de imposto

	println(impostoEletronico(100)) // Calcula 20% de 100
	println(impostoAlimento(300)) // Calcula 5% de 300
}