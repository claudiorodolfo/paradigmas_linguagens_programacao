object Main extends App {
  def filtroNumeros(criterio: String): List[Int] => List[Int] = {
    criterio match {
        case "pares"     => (lista: List[Int]) => lista.filter(x => x % 2 == 0)
        case "impares"   => (lista: List[Int]) => lista.filter(x => x  % 2 != 0)
        case "positivos" => (lista: List[Int]) => lista.filter(x => x  > 0)
        case _           => (lista: List[Int]) => lista 
    }
  }

  val minhaLista = List(1, 2, 3, 4, 5, 6)
  val filtrarPares = filtroNumeros("pares")
  println(filtrarPares(minhaLista)) // Saída: List(2, 4, 6)
}