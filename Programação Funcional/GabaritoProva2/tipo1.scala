object Main extends App {
   //////////////////// QUESTÃO 1
  case class Pessoa(nome: String, idade: Int, altura: Double)
  
  def maiorLista(lista: List[Pessoa]): Pessoa = {
    // Função auxiliar aninhada
    def maiorListaRecursao(lista: List[Pessoa], maiorAtual: Pessoa): Pessoa = lista match {
      case List()          => maiorAtual // Caso base: lista vazia, retorna o maior atual
      case cabeca :: cauda => maiorListaRecursao(cauda, if (cabeca.altura > maiorAtual.altura) cabeca else maiorAtual)
    }
    // Verifica se a lista está vazia
    if (lista.isEmpty) 
      throw new NoSuchElementException("Lista está vazia")
    else 
      maiorListaRecursao(lista, lista.head) // Inicializa com o primeiro elemento
  }
  // Entrada
  val entrada1_Q1 = List(
    Pessoa("Maria", 30, 1.60), 
    Pessoa("João", 25, 1.75), 
    Pessoa("Roberto", 18, 1.72)
  )  
  val entrada2_Q1 = List(
    Pessoa("Roberto", 18, 1.72)
  )  
  val entrada3_Q1 = List()    
  // Processamento
  val saida1_Q1 = maiorLista(entrada1_Q1)
  val saida2_Q1 = maiorLista(entrada2_Q1)
  //val saida3_Q1 = maiorLista(entrada3_Q1)
  // Saída
  println("************** QUESTÃO 1 **************")
  println(saida1_Q1)
  println(saida2_Q1)
  //println(saida3_Q1)
  
  //////////////////// QUESTÃO 2  
  case class Log(usuario: String, acao: String, data: String)
  
  def processarLogs(logs: List[Log]) = {
    // Contar quantos usuários realizaram a ação "Login"
    val totalLogins = logs.count(x => x.acao == "Login")

    // Listar usuários únicos que realizaram a ação "Logout"
    val usuariosLogout = logs
      .filter(x => x.acao == "Logout")
      .map(x => x.usuario)
      .distinct

    // Retornar os primeiros 3 logs em ordem alfabética pelo nome do usuário
    val primeiros3Logs = logs
      .sortBy(x => x.usuario)
      .take(3)

    println(s"Logins: $totalLogins")
    println(s"Usuários que fizeram Logout: ${usuariosLogout}")
    println(s"Primeiros 3 logs: ${primeiros3Logs}")
  }
  
    // Entrada
    val entrada1_Q2 = List(
      Log("Alice", "Login", "2024-12-10"),
      Log("Bob", "Logout", "2024-12-10"),
      Log("Alice", "Logout", "2024-12-10"),
      Log("Charlie", "Login", "2024-12-10")
    )
    val entrada2_Q2 = List(
      Log("Alice", "Login", "2024-12-10")
    )
    val entrada3_Q2 = List()
    
    // Processamento e Saída
    println("************** QUESTÃO 2 **************")
    processarLogs(entrada1_Q2)
    processarLogs(entrada2_Q2)
    processarLogs(entrada3_Q2)

  //////////////////// QUESTÃO 3
  // Função geradora de funções de cálculo de área com base no tipo da figura
  def gerarAreaFigura(tipo: String): Double => Double = {
    tipo match {
      case "Triângulo" => (lado) => (math.sqrt(3)/4) * math.pow(lado, 2)
      case "Quadrado"  => (lado) => math.pow(lado, 2)
      case "Pentágono" => (lado) => 5*(math.sqrt(3)/4) * math.pow(lado, 2)
      case _           => (_) => throw new IllegalArgumentException("Figura geométrica não suportada")
    }
  }
  
  def calcularArea(areaFunc: Double => Double, lado: Double): Double = {
    areaFunc(lado)
  }
  //Entrada e Processamento
  val areaTriangulo = gerarAreaFigura("Triângulo")
  val saida1_Q3 = calcularArea(areaTriangulo, 5.0)
  val areaQuadrado: Double => Double = gerarAreaFigura("Quadrado")
  val saida2_Q3 = calcularArea(areaQuadrado, 5.0)
  //val areaHexagono: Double => Double = gerarAreaFigura("Hexágono")
  //val saida3_Q3 = calcularArea(areaHexagono, 5.0) 
  // Saída
  println("************** QUESTÃO 3 **************")  
  println(f"$saida1_Q3%.2f")
  println(f"$saida2_Q3%.2f")
  //println(f"$saida3_Q3%.2f")
}