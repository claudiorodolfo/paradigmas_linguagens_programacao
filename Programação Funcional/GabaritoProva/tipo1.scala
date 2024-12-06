object Main extends App {
  //////////////////// QUESTÃO 1
  val definicao = "Funções de alta ordem são funções que podem receber outras funções como argumento ou retorná-las como resultado. Elas são úteis para abstrair padrões de lógica que se repetem, reduzindo redundância e aumentando a modularidade do código."
  val solucao = "Para resolver o problema indicado, em vez de ter várias funções para cada critério de filtro, poderíamos criar uma única função de filtro que recebe como argumento uma função de critério e aplica uma função de alta ordem do tipo filter a cada tarefa."
  println("************** QUESTÃO 1 **************")
  println(s"${definicao} ${solucao}")

  //////////////////// QUESTÃO 2
  //Lista de funções
  val somaCom2: (Int => Int) = x => x + 2
  val multiplicaPor5: (Int => Int) = x => x * 5
  val subtraiDe3: (Int => Int) = x => x - 3
  val operacoes: (List[Int => Int]) = List(somaCom2, multiplicaPor5, subtraiDe3)

  // Aplicar todas as funções da lista 'operacoes' sobre cada elemento de 'numeros'
  def aplicarOperacaoes(numeros: List[Int]): List[Int] = {
    numeros.map(num => operacoes.foldLeft(num)((acc, op) => op(acc)))
  }

  def repetirElementos(lista: List[Int]): List[Int] = {
    lista match {
      case List() => List()
      case cabeca :: cauda => cabeca :: cabeca :: cabeca :: repetirElementos(cauda)
    }
  }

  // ENTRADA
  val entrada1_Q2: (List[Int]) = List(1, 2, 3)
  val entrada2_Q2: (List[Int]) = List(10)
  val entrada3_Q2: (List[Int]) = List()
  // PROCESSAMENTO
  // Aplica as operações
  val aux1_Q2 = aplicarOperacaoes(entrada1_Q2)
  val aux2_Q2 = aplicarOperacaoes(entrada2_Q2)
  val aux3_Q2 = aplicarOperacaoes(entrada3_Q2)
  // Triplicar cada elemento do resultado final
  val saida1_Q2 = repetirElementos(aux1_Q2)
  val saida2_Q2 = repetirElementos(aux2_Q2)
  val saida3_Q2 = repetirElementos(aux3_Q2)
  // SAÍDA
  println("************** QUESTÃO 2 **************")
  println(saida1_Q2)
  println(saida2_Q2)
  println(saida3_Q2)

  //////////////////// QUESTÃO 3
  def somaLista(lista: List[Int]): Int = {
    // Função auxiliar recursiva
    def somaListaRecursao(lista: List[Int], acumulador: Int): Int = {
      lista match {
        case List() => acumulador // Caso base: lista vazia, retorna o acumulador
        case cabeca :: cauda => somaListaRecursao(cauda, acumulador + cabeca) // Soma o elemento atual e avança na recursão
      }
    }
    // Chamada inicial da função auxiliar com acumulador zerado
    somaListaRecursao(lista, 0)
  }

  // ENTRADA
  val entrada1_Q3 = List(1, 2, 3, 4, 5)
  val entrada2_Q3 = List(3)
  val entrada3_Q3 = List()
  // PROCESSAMENTO
  val saida1_Q3 = somaLista(entrada1_Q3)
  val saida2_Q3 = somaLista(entrada2_Q3)
  val saida3_Q3 = somaLista(entrada3_Q3)
  // SAÍDA
  println("************** QUESTÃO 3 **************")  
  println(saida1_Q3)
  println(saida2_Q3)
  println(saida3_Q3)

  //////////////////// QUESTÃO 4
  def processarLista(lista: List[Int]): List[Int] = {
    lista.filter(x => x % 2 == 0)      // Filtrar apenas os números pares
        .map(x => x * 3)               // Multiplicar os números pares por 3
        .sorted(Ordering.Int.reverse)  // Ordenar a lista em ordem decrescente
  }

  // ENTRADA
  val entrada1_Q4 = List(4, 7, 2, 9, 12, 5, 8)
  val entrada2_Q4 = List(5)
  val entrada3_Q4 = List()
  // PROCESSAMENTO
  val saida1_Q4 = processarLista(entrada1_Q4)
  val saida2_Q4 = processarLista(entrada2_Q4)
  val saida3_Q4 = processarLista(entrada3_Q4)
  // SAÍDA
  println("************** QUESTÃO 4 **************")
  println(saida1_Q4)
  println(saida2_Q4)
  println(saida3_Q4)

  //////////////////// QUESTÃO 5
  // Função 'filtrarEMapear' que recebe duas funções (filtro e mapeamento)
  def filtrarEMapear(filterFunc: Int => Boolean, mapFunc: Int => Int): List[Int] => List[Int] = {
    // Retorna uma nova função que recebe uma lista de Int e retorna uma lista de Boolean
    lista => lista.filter(filterFunc).map(mapFunc)
  }

  // Exemplo de funções de filtro e mapeamento
  val filtroPar: (Int => Boolean) = x => x % 2 == 0  // Filtro para números pares
  val quadrado: (Int => Int) = x => x * x            // Mapeamento para o quadrado do número

  // Usando a função 'processa' com os exemplos de filtro e mapeamento
  val processa = filtrarEMapear(filtroPar, quadrado)

  // ENTRADA
  val entrada1_Q5 = List(1, 2, 3, 4)
  val entrada2_Q5 = List(3,5)
  val entrada3_Q5 = List()
  // PROCESSAMENTO
  val saida1_Q5 = processa(entrada1_Q5)
  val saida2_Q5 = processa(entrada2_Q5)
  val saida3_Q5 = processa(entrada3_Q5)
  // SAÍDA
  println("************** QUESTÃO 5 **************")
  println(saida1_Q5)
  println(saida2_Q5)
  println(saida3_Q5)

  //////////////////// QUESTÃO 6
  // Função 'geradorDeValidador' que recebe uma função de validação e retorna uma nova função
  def geradorDeValidador(isValid: Int => Boolean): List[Int] => Boolean = {
    // A nova função valida se todos os elementos da lista são válidos
    lista => lista.exists(isValid)
  }

  // Exemplo de função de validação
  val par: (Int => Boolean) = x => x % 2 == 0   // Validação para números pares
  val maiorQue25: (Int => Boolean) = x => x > 25  // Validação para números maiores que 25
  val positivo: (Int => Boolean) = x => x > 0     // Validação para números positivos

  // ENTRADA
  val entrada1_Q6 = List(2, 6, 4)
  val entrada2_Q6 = List(10, 3, 20, 12)
  val entrada3_Q6 = List(2, 4, 6, 10, 15)
  // PROCESSAMENTO
  val existePar = geradorDeValidador(par)
  val existeMaiorQue25 = geradorDeValidador(maiorQue25)
  val existePositivo = geradorDeValidador(positivo)
  // SAÍDA
  println("************** QUESTÃO 6 **************")
  println(existePar(entrada1_Q6))
  println(existeMaiorQue25(entrada2_Q6))
  println(existePositivo(entrada3_Q6))
}