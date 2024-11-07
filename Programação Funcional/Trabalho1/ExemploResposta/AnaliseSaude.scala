import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object Main extends App {

  // Criação do SparkSession
  val spark = SparkSession.builder()
    .appName("Saúde")
    .master("local")  // Definido para rodar localmente
    .getOrCreate()
	
  // Carregando o CSV com a inferência de schema
  val dfParticipantes = spark.read
    .format("csv")
    .option("header", "true")      //A primeira linha do arquivo tem cabeçalho. Não começa diretamente nos dados	
    .option("inferSchema", "true") // Garante que os tipos corretos sejam inferidos e não ler tudo como texto
    .load("saude.csv")

  // Renomeando a coluna 'Idade' para facilitar o acesso
  val dfRenomeado = dfParticipantes
    .withColumnRenamed("Idade", "idade")

  // Calcule a idade média de todos os participantes na base de dados.
  val resultado = dfRenomeado
    .agg(avg("idade").as("idade_media"))

  // Exibindo o resultado completo (sem truncamento)
  resultado.show(false) 
  
  // Parando o SparkSession (opcional)
  spark.stop()
}
