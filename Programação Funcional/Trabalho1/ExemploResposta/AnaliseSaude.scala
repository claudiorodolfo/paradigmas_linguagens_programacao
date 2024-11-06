//Idade média de todos os participantes: Calcule a idade média de todos os participantes na base de dados. Exiba apenas o valor da média.

object Main {

  case class DadosSaude(
    id: Int,
    idade: Int,
    genero: String,
    altura: Double,
    peso: Double,
    horasSono: Double,
    caloriasConsumidas: Int,
    passosPorDia: Int,
    atividadeFisicaMin: Int,
    pressaoArterial: String
  )

  def main(args: Array[String]): Unit = {
    val dados = List(
      DadosSaude(1, 25, "M", 1.75, 70.0, 7.0, 2200, 8000, 30, "120/80"),
      DadosSaude(2, 45, "F", 1.60, 65.0, 6.5, 1800, 6000, 20, "130/85"),
      DadosSaude(3, 30, "M", 1.82, 85.0, 8.0, 2500, 10000, 45, "115/75"),
      DadosSaude(4, 60, "F", 1.70, 78.0, 6.0, 2000, 5000, 15, "140/90")
    )

    val idadeMedia = dados.map(x => x.idade).sum.toDouble / dados.length

    println(f"Idade média dos participantes: $idadeMedia%.0f anos")
  }
  //Idade média dos participantes: 40.00 anos
}
