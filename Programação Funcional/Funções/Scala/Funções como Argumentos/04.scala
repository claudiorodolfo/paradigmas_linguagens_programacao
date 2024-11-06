object Main extends App {
	case class Evento(id: Int, nome: String, mensagem: String, prioridade: String)
	def notificarEventos(eventos: List[Evento], filtro: Evento => Boolean): List[Evento] = {
		eventos.filter(filtro)
	}

	// Exemplo de uso:
	val eventos = List(
		Evento(1, "Manutenção", "Manutenção de rotina", "baixo"),
		Evento(2, "Alerta", "Alto uso de memória", "alto"),
		Evento(3, "Atualização", "Nova versão disponível", "médio")
	)

	// Filtro para eventos com prioridade "alto"
	val eventosPrioridadeAlta = notificarEventos(eventos, (evento: Evento) => evento.prioridade == "alto")
	println(eventosPrioridadeAlta)
	// Saída esperada: List(Evento(2, "Alerta", "Alto uso de memória", "alto"))
}