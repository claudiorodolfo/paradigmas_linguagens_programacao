import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object Main extends App {

  // Criação do SparkSession
  val spark = SparkSession.builder()
    .appName("Imóveis")
    .master("local")  // Definido para rodar localmente
    .getOrCreate()
	
  // Carregando o CSV com a inferência de schema
  val dfImoveis = spark.read
    .format("csv")
    .option("header", "true")      //A primeira linha do arquivo tem cabeçalho. Não começa diretamente nos dados
    .option("inferSchema", "true") // Garante que os tipos corretos sejam inferidos e não ler tudo como texto
    .load("imoveis.csv")

  // Renomeando as colunas para facilitar o acesso
  val dfRenomeado = dfImoveis
    .withColumnRenamed("ID", "id")
    .withColumnRenamed("Área (m²)", "area")
    .withColumnRenamed("Preço", "preco")
    .withColumnRenamed("Cidade", "cidade")
    .withColumnRenamed("Bairro", "bairro")

  // Selecionando os imóveis com área maior que 100 m² e preço superior a 1.000.000
  val resultado = dfRenomeado
    .filter($"area" > 100 && $"preco" > 1000000)
    .select("id", "cidade", "bairro", "preco")

  // Exibindo o resultado completo (sem truncamento)
  resultado.show(false)

  // Parando o SparkSession (opcional)
  spark.stop()
}
