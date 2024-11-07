import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object Main extends App {

  // Criação do SparkSession
  val spark = SparkSession.builder()
    .appName("Temperatura")
    .master("local")  // Definido para rodar localmente
    .getOrCreate()
	
  // Carregando o CSV com a inferência de schema
  val dfTemperatura = spark.read
    .format("csv")
    .option("header", "true")      //A primeira linha do arquivo tem cabeçalho. Não começa diretamente nos dados
    .option("inferSchema", "true") // Garante que os tipos corretos sejam inferidos e não ler tudo como texto
    .load("temperatura.csv")

  // Renomeando as colunas para facilitar o acesso
  val dfRenomeado = dfTemperatura
    .withColumnRenamed("Temperatura Máxima (°C)", "tempMax")
    .withColumnRenamed("Temperatura Mínima (°C)", "tempMin")

	
  // Calcule a temperatura média (média entre a máxima e a mínima) de todos os registros.
  val resultado = dfRenomeado
    .withColumn("media_temperatura", ($"tempMax" + $"tempMin") / 2)
    .agg(avg("media_temperatura").as("temperatura_media_geral"))

  // Exibindo o resultado completo (sem truncamento)
  resultado.show(false)

  // Parando o SparkSession (opcional)
  spark.stop()
}