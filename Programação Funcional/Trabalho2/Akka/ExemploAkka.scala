import akka.actor.{Actor, ActorSystem, Props}

// Define o ator Saudador
class Saudador extends Actor {
  // Define o comportamento do ator Saudador
  def receive = {
    case "Oi" =>
      println("Saudador: Olá, como vai?")
      // Envia uma mensagem para o ator Resposta
      val respostaActor = context.actorSelection("/user/resposta")
      respostaActor ! "Tudo bem, e você?"
  }
}

// Define o ator Resposta
class Resposta extends Actor {
  // Define o comportamento do ator Resposta
  def receive = {
    case "Tudo bem, e você?" =>
      println("Resposta: Estou bem, obrigado!")
      // Responde com uma saudação final
      sender() ! "Que bom! Até mais!"
  }
}

object Main extends App {
  // Cria o sistema de atores
  val system = ActorSystem("SaudacaoSystem")

  // Cria o ator Resposta
  val resposta = system.actorOf(Props[Resposta], "resposta")

  // Cria o ator Saudador
  val saudador = system.actorOf(Props[Saudador], "saudador")

  // Envia a mensagem inicial para o ator Saudador
  saudador ! "Oi"
}