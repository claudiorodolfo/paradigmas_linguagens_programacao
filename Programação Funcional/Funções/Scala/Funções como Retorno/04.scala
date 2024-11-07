//Função que classifica a categoria: Retorna uma função que valida uma idade de acordo a categoria que pertence.
object Main extends App {
  def classificacaoCategoria(min: Int, max: Int): Int => Boolean = {
    (x: Int) => x >= min && x <= max
  }

  val categoriaAdulto = classificacaoCategoria(18,30)
  val categoriaMaster1 = classificacaoCategoria(30,35)
  println(categoriaAdulto(20)) // Saída: true
  println(categoriaAdulto(35)) // Saída: false
}