//Viagens com maior número de passageiros: Selecione as viagens com mais de 50 passageiros. Exiba o ID da viagem, a linha de ônibus e o tipo de veículo.

object Main {

  case class Viagem(
    id: Int,
    data: String,
    hora: String,
    linhaOnibus: String,
    numeroPassageiros: Int,
    tipoVeiculo: String,
    localizacaoPartida: String,
    localizacaoChegada: String,
    tempoViagem: Int,
    custoViagem: Double
  )

  def main(args: Array[String]): Unit = {
    val viagens = List(
      Viagem(1, "2023-11-01", "08:30", "Linha 101", 60, "Ônibus", "A", "B", 40, 3.5),
      Viagem(2, "2023-11-01", "09:00", "Linha 202", 45, "Ônibus", "B", "C", 30, 3.0),
      Viagem(3, "2023-11-01", "10:00", "Linha 303", 55, "Ônibus", "C", "D", 50, 4.0),
      Viagem(4, "2023-11-01", "11:30", "Linha 404", 48, "Micro-ônibus", "D", "E", 20, 2.5),
      Viagem(5, "2023-11-01", "12:00", "Linha 505", 52, "Ônibus", "E", "F", 35, 3.8)
    )

    val viagensComMaisDe50Passageiros = viagens
      .filter(x => x.numeroPassageiros > 50)
      .map(viagem => (viagem.id, viagem.linhaOnibus, viagem.tipoVeiculo))

    viagensComMaisDe50Passageiros.foreach { case (id, linhaOnibus, tipoVeiculo) =>
      println(s"ID da Viagem: $id, Linha de Ônibus: $linhaOnibus, Tipo de Veículo: $tipoVeiculo")
    }
  }
  //Saída:
  //ID da Viagem: 1, Linha de Ônibus: Linha 101, Tipo de Veículo: Ônibus
  //ID da Viagem: 3, Linha de Ônibus: Linha 303, Tipo de Veículo: Ônibus
  //ID da Viagem: 5, Linha de Ônibus: Linha 505, Tipo de Veículo: Ônibus
}
