//************* DEFINIÇÃO DOS DADOS
case class Funcionario(
  nome: String, 
  salario: Double, 
  cargo: Cargo.Value, 
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
//************* BASE DE DADOS
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
    Produto("Monitor", 1200.0, 0)
  )

  // Lista de Clientes
  val clientes = List(
    Cliente("Lucas", 8500.0),
    Cliente("Mariana", 12000.0),
    Cliente("José", 4500.0),
    Cliente("Fernanda Abreu", 6000.0),
    Cliente("Roberta", 3500.0)
  )

  // Lista de Vendas
  val vendas = List(
    Venda("2024-01-01", 300.0),
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
  
  // Meses
  val meses = List("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro")
	
  // Faturamento Mensal
  val faturamentoMensal = List(3000.0, 4500.0, 2500.0, 5200.0, 4800.0, 5000.0, 6000.0, 7000.0, 8000.0, 9000.0, 10000.0, 11000.0)
  
  //************* QUESTÕES 
  // Questão 01
  println("************* Questão 01 *************")
  val salarioLimite = 7000.0
  val funcionariosSalarioAlto = funcionarios.filter(x => x.salario > salarioLimite)
  funcionariosSalarioAlto.foreach(println)
  
  // Questão 02
  println("************* Questão 02 *************")
  val aumentoPorcento = 10.0
  val funcionariosAumento = funcionarios.map(f => f.copy(salario = f.salario * (100.0 + aumentoPorcento/100.0)))
  funcionariosAumento.foreach(println)
  
  // Questão 03
  println("************* Questão 03 *************")
  val totalVendas = vendas.map(x => x.valor).reduce((acc, valor) => acc + valor)
  println(totalVendas)
  
  // Questão 04
  println("************* Questão 04 *************")
  val totalEstoque = produtos.map(x => x.estoque).sum
  println(totalEstoque)

  // Questão 05
  println("************* Questão 05 *************")
  val existeEstoqueZero = produtos.exists(x => x.estoque == 0)
  println(existeEstoqueZero)
  
  // Questão 06
  val numCaracteres = 8
  println("************* Questão 06 *************")
  val clientesNomeLongo = clientes.filter(x => x.nome.length > numCaracteres)
  clientesNomeLongo.foreach(println)

  // Questão 07
  println("************* Questão 07 *************")
  val faturamentoAnual = faturamentoMensal.reduce((acc, valor) => acc + valor)
  println(faturamentoAnual)
  
  // Questão 08
  println("************* Questão 08 *************")
  val letraE = "e"
  val produtosComLetraEspecifica = produtos.filter(x => x.nome.contains(letraE))
  produtosComLetraEspecifica.foreach(println)

  // Questão 09
  println("************* Questão 09 *************")
  val totalEstoqueDuplicado = produtos.map(x => x.estoque * 2).sum
  println(totalEstoqueDuplicado)

  // Questão 10
  println("************* Questão 10 *************")
  val qntCaracteres = 10
  val produtosNomeLongo = produtos.count(x => x.nome.length > qntCaracteres)
  println(produtosNomeLongo)
  
  // Questão 11
  println("************* Questão 11 *************")
  val maiores5Gastos = 5
  val clientesTopGastos = clientes.sortBy(cliente => -cliente.totalGasto).take(maiores5Gastos)
  //val clientesTopGastos = clientes.map(cliente => cliente.totalGasto).sorted(Ordering.Double.reverse).take(maiores5Gastos)
  clientesTopGastos.foreach(println)

  // Questão 12
  println("************* Questão 12 *************")
  val entradas = 3
  val vendasRecentes = vendas.drop(entradas)
  vendasRecentes.foreach(println)
  
  // Questão 13
  println("************* Questão 13 *************")
  val vendasLimite = 1000
  val vendasAcimaMil = vendas.filter(x => x.valor > vendasLimite).size
  println(vendasAcimaMil)

  // Questão 14
  println("************* Questão 14 *************")
  val todosProdutosDisponiveis = produtos.forall(x => x.estoque > 0)
  println(todosProdutosDisponiveis)

  // Questão 15
  println("************* Questão 15 *************")
  val projetosNomeParCaracteres = projetos.filter(x => x.nome.length % 2 == 0)
  projetosNomeParCaracteres.foreach(println)
  
  // Questão 16
  println("************* Questão 16 *************")
  val somaQuadradosFaturamento = faturamentoMensal.map(v => v * v).reduce((acc, valor) => acc + valor)
  println(f"$somaQuadradosFaturamento%.2f")

  // Questão 17
  println("************* Questão 17 *************")
  val indiceProdutoSemEstoque = produtos.indexWhere(x => x.estoque == 0)
  println(indiceProdutoSemEstoque)

  // Questão 18
  println("************* Questão 18 *************")
  val clienteJose = "José"
  val clienteEspecificoPresente = clientes.exists(x => x.nome == clienteJose)
  println(clienteEspecificoPresente)
  
  // Questão 19
  println("************* Questão 19 *************")
  val primeiras10 = 10
  val totalPrimeirasCompras = vendas.take(primeiras10).map(x => x.valor).reduce((acc, valor) => acc + valor)
  println(totalPrimeirasCompras)
  
  // Questão 20
  println("************* Questão 20 *************")
  val produtosDisponiveis = produtos.filter(x => x.estoque > 0)
  produtosDisponiveis.foreach(println)
  
  // Questão 21
  println("************* Questão 21 *************")
  val faturamentoAcumulado = faturamentoMensal.scanLeft(0.0)((acc, valor) => acc + valor)
  faturamentoAcumulado.foreach(println)
  
  // Questão 22
  println("************* Questão 22 *************")  
  val totalEngenheirosSoftware = funcionarios.count(x => x.cargo == Cargo.EngenheiroSoftware)
  println(totalEngenheirosSoftware)

  // Questão 23
  println("************* Questão 23 *************")
  val venda500 = 500
  val produtoVendasAteLimite = vendas.takeWhile(x => x.valor >= venda500).map(y => y.valor).product
  println(f"$produtoVendasAteLimite%.2f")

  // Questão 24
  println("************* Questão 24 *************")
  val totalFaturamentoInvertido = faturamentoMensal.foldRight(0.0)((x, acc) => x + acc)
  println(totalFaturamentoInvertido)

  // Questão 25
  println("************* Questão 25 *************")  
  val estoqueProdutoDisponiveis = produtos.filter(x => x.estoque > 0).map(y => y.estoque).reduce((acc, valor) => acc * valor)
  println(estoqueProdutoDisponiveis)

  // Questão 26
  println("************* Questão 26 *************")
  val valorVendaMaxima = vendas.map(x => x.valor).reduce((a, b) => if (a > b) a else b)
  //val valorVendaMaxima = vendas.map(x => x.valor).max
  println(valorVendaMaxima)

  // Questão 27
  println("************* Questão 27 *************")
  val faturamentoMensal2 = List(1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0)
  val faturamentosComparaveis =  faturamentoMensal.zip(faturamentoMensal2).forall(x => true)
  println(faturamentosComparaveis)

  // Questão 28
  println("************* Questão 28 *************")
  meses.zip(faturamentoMensal).foreach { case (faturamento, mes) => println(s"$mes: R$$ $faturamento") }
}