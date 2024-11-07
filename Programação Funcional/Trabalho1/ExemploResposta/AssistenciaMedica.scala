import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object Main extends App {

  // Criação do SparkSession
  val spark = SparkSession.builder()
    .appName("Pacientes")
    .master("local")  // Definido para rodar localmente
    .getOrCreate()
	
  // Carregando o CSV com a inferência de schema
  val dfAtendimentos = spark.read
    .format("csv")
    .option("header", "true")      //A primeira linha do arquivo tem cabeçalho. Não começa diretamente nos dados
    .option("inferSchema", "true") // Garante que os tipos corretos sejam inferidos e não ler tudo como texto
    .load("pacientes.csv")

  // Renomeando as colunas para facilitar o acesso
  val dfRenomeado = dfAtendimentos
    .withColumnRenamed("ID Atendimento", "atendimento")
    .withColumnRenamed("Paciente", "nomePaciente")
    .withColumnRenamed("Diagnóstico", "diagnostico")
    .withColumnRenamed("Tratamento", "tratamento")
    .withColumnRenamed("Idade", "idade")

  // Liste todos os atendimentos de pacientes com mais de 60 anos que receberam tratamento "Fisioterapia".
  val resultado = dfRenomeado
    .filter($"idade" > 60 && $"tratamento" === "Fisioterapia")
    .select("atendimento", "nomePaciente", "diagnostico")

  // Exibindo o resultado completo (sem truncamento)
  resultado.show(false)

  // Parando o SparkSession (opcional)
  spark.stop()
}
