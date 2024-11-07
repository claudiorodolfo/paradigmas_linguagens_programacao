import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object Main extends App {

  // Criação do SparkSession
  val spark = SparkSession.builder()
    .appName("Transporte")
    .master("local")  // Definido para rodar localmente
    .getOrCreate()

  // Carregando o CSV com a inferência de schema
  val dfViagens = spark.read
    .format("csv")
    .option("header", "true")      //A primeira linha do arquivo tem cabeçalho. Não começa diretamente nos dados
    .option("inferSchema", "true") // Garante que os tipos corretos sejam inferidos e não ler tudo como texto
    .load("viagens.csv")

  // Renomeando as colunas para facilitar o acesso
  val dfRenomeado = dfViagens
    .withColumnRenamed("ID da viagem", "idViagem")
    .withColumnRenamed("Linha de ônibus", "linhaOnibus")
    .withColumnRenamed("Tipo de veículo", "tipoVeiculo")
    .withColumnRenamed("Número de passageiros", "numPassageiros")

  // Selecionando as viagens com mais de 50 passageiros
  val resultado = dfRenomeado
    .filter($"numPassageiros" > 50)
    .select("idViagem", "linhaOnibus", "tipoVeiculo")

  // Exibindo o resultado completo (sem truncamento)
  resultado.show(false)

  // Parando o SparkSession (opcional)
  spark.stop()
}
