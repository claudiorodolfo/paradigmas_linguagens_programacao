import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Main extends App {
  def formatadorData(formato: String): String => String = {
    (data: String) => LocalDate.parse(data).format(DateTimeFormatter.ofPattern(formato))
  }

  val formatarDataBR = formatadorData("dd/MM/yyyy")
  println(formatarDataBR("2023-11-01")) // Saída: 01/11/2023
}