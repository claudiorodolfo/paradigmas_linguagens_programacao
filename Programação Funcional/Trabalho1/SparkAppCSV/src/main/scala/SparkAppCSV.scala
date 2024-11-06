import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object CsvExemploFiltro {
  def main(args: Array[String]): Unit = {
    // Inicializa a SparkSession
    val spark = SparkSession.builder()
      .appName("CSV Exemplo Filtro")
      .master("local[*]") // Use "local[*]" para rodar localmente
      .getOrCreate()

    // Define o caminho do arquivo CSV
    val csvPath = "dados_pessoas.csv"

    // Lê o arquivo CSV, assumindo que ele contém cabeçalhos
    val df = spark.read
      .option("header", "true") // Informa que o CSV tem cabeçalho
      .option("inferSchema", "true") // Infere os tipos de dados automaticamente
      .csv(csvPath)

    // Exibe o schema do DataFrame para verificar a estrutura dos dados
    df.printSchema()

    // Filtra os dados pelo campo "sexo" (por exemplo, para obter apenas registros do sexo masculino)
    val dfFiltered = df.filter(col("sexo") === "M")

    // Mostra os resultados filtrados
    dfFiltered.show()

    // Para salvar o resultado filtrado em um novo arquivo CSV
    //dfFiltered.write
    //  .option("header", "true")
    //  .csv("resultado_filtrado.csv")

    // Fecha a sessão Spark
    spark.stop()
  }
}