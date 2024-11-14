object Main extends App {
  val apenasPositivos: Int => Boolean = (x: Int) => x > 0
  val apenasPares: Int => Boolean = (x: Int) => x % 2 == 0
  val menorQue100: Int => Boolean = (x: Int) => x < 100

  val filtros = List(apenasPositivos, apenasPares, menorQue100)

  def aplicarFiltros(numeros: List[Int], filtros: List[Int => Boolean]): List[Int] = {
    numeros.filter(numero => filtros.forall(filtro => filtro(numero)))
  }

  println(aplicarFiltros(List(-10, 20, 30, 150, 5), filtros)) // Saída: List(20, 30)
}