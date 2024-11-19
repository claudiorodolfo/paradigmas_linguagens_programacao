import plotly._
import plotly.element._
import plotly.layout._
import plotly.Plotly._

object Main extends App {
  val trace = Scatter(
    x = Seq(1, 2, 3, 4), // Valores do eixo X
    y = Seq(10, 15, 13, 17) // Valores do eixo Y
  )

  val layout = Layout().withTitle("Exemplo de Plotagem")

  // Plotar o gráfico
  plot(
    path = "exemplo-plotagem.html",// Caminho do arquivo HTML de saída
    traces = Seq(trace),           // Traços a serem exibidos
    layout = layout,               // Layout do gráfico
    config = Config(),             // Configuração (opcional, aqui está a padrão)
    useCdn = true,                 // Usa a CDN para recursos do Plotly
    openInBrowser = true,          // Abre o gráfico no navegador automaticamente
    addSuffixIfExists = true       // Evita sobrescrever arquivos existentes
  )
}
