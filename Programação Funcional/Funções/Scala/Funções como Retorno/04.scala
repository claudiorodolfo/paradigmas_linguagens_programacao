//Exemplo prático do uso de: Funções como Retorno de Outras Funções
//Função que classifica a categoria: Retorna uma função que valida uma idade de acordo a categoria que pertence.
object Main extends App {
  def faixaEtaria(min: Int, max: Int): Int => Boolean = {
    (x: Int) => x >= min && x <= max
  }

  val categoriaAdulto = faixaEtaria(18,30)
  val categoriaMaster1 = faixaEtaria(30,35)
  println(categoriaAdulto(20)) // Saída: true
  println(categoriaAdulto(35)) // Saída: false
}