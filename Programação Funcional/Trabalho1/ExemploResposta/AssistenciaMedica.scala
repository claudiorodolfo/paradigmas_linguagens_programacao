//Pacientes de idade avançada com tratamento específico: Liste todos os atendimentos de pacientes com mais de 60 anos que receberam tratamento “Fisioterapia”. Exiba o ID do atendimento, o nome do paciente e o diagnóstico.

object Main {

  case class Atendimento(
    id: Int,
    paciente: String,
    genero: String,
    idade: Int,
    diagnostico: String,
    tratamento: String,
    custoTratamento: Double,
    medicoResponsavel: String,
    duracaoTratamento: Int,
    dataInicio: String,
    dataTermino: String
  )

  def main(args: Array[String]): Unit = {
    val atendimentos = List(
      Atendimento(1, "Carlos Silva", "M", 65, "Artrite", "Fisioterapia", 200.0, "Dr. Almeida", 30, "2024-10-01", "2024-10-31"),
      Atendimento(2, "Mariana Costa", "F", 55, "Fratura", "Cirurgia", 1500.0, "Dra. Pereira", 10, "2024-09-15", "2024-09-25"),
      Atendimento(3, "João Souza", "M", 70, "Bursite", "Fisioterapia", 180.0, "Dr. Almeida", 25, "2024-10-05", "2024-10-30"),
      Atendimento(4, "Ana Lima", "F", 63, "Osteoporose", "Fisioterapia", 220.0, "Dra. Santos", 20, "2024-11-01", "2024-11-21"),
      Atendimento(5, "Pedro Oliveira", "M", 45, "Lombalgia", "Medicação", 120.0, "Dr. Siqueira", 15, "2024-09-20", "2024-10-05")
    )

    val pacientesIdososFisioterapia = atendimentos
      .filter(atendimento => atendimento.idade > 60 && atendimento.tratamento == "Fisioterapia")
      .map(atendimento => (atendimento.id, atendimento.paciente, atendimento.diagnostico))

    pacientesIdososFisioterapia.foreach { case (id, paciente, diagnostico) =>
      println(s"ID do Atendimento: $id, Paciente: $paciente, Diagnóstico: $diagnostico")
    }
  }
  //Saída:
  //ID do Atendimento: 1, Paciente: Carlos Silva, Diagnóstico: Artrite
  //ID do Atendimento: 3, Paciente: João Souza, Diagnóstico: Bursite
  //ID do Atendimento: 4, Paciente: Ana Lima, Diagnóstico: Osteoporose
}
