//Imóveis com áreas amplas e preços altos: Selecione todos os imóveis com área maior que 100 m² e preço superior a 1.000.000. Exiba o ID, a cidade, o bairro e o preço.

object Main {

  case class Imovel(
    id: Int,
    cidade: String,
    bairro: String,
    area: Double,
    numQuartos: Int,
    numBanheiros: Int,
    preco: Double,
    anoConstrucao: Int,
    distanciaCentro: Double
  )

  def main(args: Array[String]): Unit = {
    val imoveis = List(
      Imovel(1, "São Paulo", "Jardins", 120.0, 3, 2, 1500000.0, 1990, 5.0),
      Imovel(2, "Rio de Janeiro", "Copacabana", 85.0, 2, 1, 900000.0, 1985, 2.0),
      Imovel(3, "Brasília", "Asa Sul", 200.0, 4, 3, 2500000.0, 2000, 7.0),
      Imovel(4, "Belo Horizonte", "Lourdes", 110.0, 3, 2, 1100000.0, 1995, 3.5),
      Imovel(5, "Porto Alegre", "Moinhos de Vento", 95.0, 2, 1, 750000.0, 1980, 4.0)
    )

    val imoveisAmploPrecoAlto = imoveis
      .filter(imovel => imovel.area > 100.0 && imovel.preco > 1000000.0)
      .map(imovel => (imovel.id, imovel.cidade, imovel.bairro, imovel.preco))

    imoveisAmploPrecoAlto.foreach { case (id, cidade, bairro, preco) =>
      println(s"ID do Imóvel: $id, Cidade: $cidade, Bairro: $bairro, Preço: R$$ $preco")
    }
  }
  //Saída:
  //ID do Imóvel: 1, Cidade: São Paulo, Bairro: Jardins, Preço: R$ 1500000.0
  //ID do Imóvel: 3, Cidade: Brasília, Bairro: Asa Sul, Preço: R$ 2500000.0
  //ID do Imóvel: 4, Cidade: Belo Horizonte, Bairro: Lourdes, Preço: R$ 1100000.0
}
