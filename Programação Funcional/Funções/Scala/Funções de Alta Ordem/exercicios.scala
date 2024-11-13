//************* Definição dos Dados
case class Funcionario(
  nome: String, 
  salario: Double, cargo: 
  Cargo.Value, 
  departamentos: List[Departamento.Value]
)

case class Produto(
  nome: String, 
  preco: Double, 
  estoque: Int

)
case class Cliente(
  nome: String, 
  totalGasto: Double

)
case class Venda(
  data: String, 
  valor: Double
)

case class Projeto(
  nome: String, 
  participantes: List[Funcionario]
)

//Tipos Enumerados
object Cargo extends Enumeration {
  type Cargo = Value
  val EngenheiroSoftware, GerenteProjetos, AnalistaNegocios, Desenvolvedor = Value
}

object Departamento extends Enumeration {
  type Departamento = Value
  val TI, Vendas, RH, Marketing, Financas = Value
}

object Main extends App {
//************* Base de Dados
  // Lista de Funcionários
  val funcionarios = List(
    Funcionario("Alice", 7500.0, Cargo.EngenheiroSoftware, List(Departamento.TI)),
    Funcionario("Bob", 12000.0, Cargo.GerenteProjetos, List(Departamento.TI, Departamento.Financas)),
    Funcionario("Carlos", 6000.0, Cargo.AnalistaNegocios, List(Departamento.Vendas, Departamento.Marketing)),
    Funcionario("Diana", 5000.0, Cargo.Desenvolvedor, List(Departamento.TI, Departamento.Marketing)),
    Funcionario("Elena", 4500.0, Cargo.AnalistaNegocios, List(Departamento.RH)),
    Funcionario("Fernando", 10000.0, Cargo.EngenheiroSoftware, List(Departamento.TI, Departamento.Financas)),
    Funcionario("Gabriel", 5400.0, Cargo.AnalistaNegocios, List(Departamento.Vendas, Departamento.Marketing)),
    Funcionario("Helena", 10200.0, Cargo.GerenteProjetos, List(Departamento.Financas))
  )

  // Lista de Produtos
  val produtos = List(
    Produto("Notebook", 4500.0, 15),
    Produto("Smartphone", 2500.0, 30),
    Produto("Cadeira de Escritório", 800.0, 20),
    Produto("Teclado Mecânico", 300.0, 50),
    Produto("Monitor", 1200.0, 25)
  )

  // Lista de Clientes
  val clientes = List(
    Cliente("Lucas", 8500.0),
    Cliente("Mariana", 12000.0),
    Cliente("José", 4500.0),
    Cliente("Fernanda", 6000.0),
    Cliente("Roberta", 3500.0)
  )

  // Lista de Vendas
  val vendas = List(
    Venda("2024-01-01", 3000.0),
    Venda("2024-02-15", 4500.0),
    Venda("2024-03-10", 2500.0),
    Venda("2024-04-20", 5200.0),
    Venda("2024-05-05", 4800.0)
  )

  // Lista de Projetos
  val projetos = List(
    Projeto("Sistema ERP", List(funcionarios(0), funcionarios(1), funcionarios(3))),
    Projeto("App de Vendas", List(funcionarios(4), funcionarios(2), funcionarios(7))),
    Projeto("Integração de Marketing", List(funcionarios(5), funcionarios(2), funcionarios(6))),
    Projeto("Portal de RH", List(funcionarios(4), funcionarios(7), funcionarios(1)))
  )
  
  // Questão 01
  println(s"***************** QUESTÃO 01 *****************")
  def funcionariosAcimaDeSalario(salarioLimite: Double): List[Funcionario] = {
    funcionarios.filter(_.salario > salarioLimite)
  }
  val salarioFiltro = 7000.0
  val funcionariosComSalarioAlto = funcionariosAcimaDeSalario(salarioFiltro)
  println(s"Funcionários que recebem acima de R$$ $salarioFiltro:")
  funcionariosComSalarioAlto.foreach(println)
  
    // Questão 02
    // Questão 03
    // Questão 04
    // Questão 05
    // Questão 06
    // Questão 07
    // Questão 08
    // Questão 09
    // Questão 10
    // Questão 11
    // Questão 12
    // Questão 13
    // Questão 14
    // Questão 15
    // Questão 16
    // Questão 17
    // Questão 18
    // Questão 19
    // Questão 20
    // Questão 21
    // Questão 22
    // Questão 23
    // Questão 24
    // Questão 25
    // Questão 26
    // Questão 27
    // Questão 28
    // Questão 29    
    // Questão 30
}