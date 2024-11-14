import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Main extends App  {

  def aplicarProcessamento(texto: String, funcoes: List[String => String]): String = {
    funcoes.foldLeft(texto)((resultado, funcao) => funcao(resultado))
  }

  // Adiciona 5 dias à data e retorna a nova data
  val adicionarDias: String => String = data => LocalDate.parse(data).plusDays(5).toString
  // Formata a data no formato brasileiro (dd/MM/yyyy)
  val formatarDataBR: String => String = data => LocalDate.parse(data).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

  val pipelineData = List(adicionarDias, formatarDataBR)

  println(aplicarProcessamento("2023-11-01", pipelineData)) // Processamento de data em etapas
}
