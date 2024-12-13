object Main extends App {
  //////////////////// QUESTÃO 1
  val definicao = "Um efeito colateral ocorre quando uma função altera o estado externo (por exemplo, escreve em um arquivo, modifica uma variável global ou faz chamadas de rede). Isso viola o princípio da pureza funcional, onde funções devem apenas calcular e retornar valores."
  val solucao = "Para resolver o problema indicado, podemos separar a lógica de recomendação da lógica de gravação. A função que retorna os filmes deve ser pura, sem dependências externas, e a gravação deve ser feita por outra função, tornando assim o sistema mais modular e fácil de testar, já que a recomendação e a gravação estão desacopladas."
  println("************** QUESTÃO 1 **************")
  println(s"${definicao} ${solucao}")

  //////////////////// QUESTÃO 2
  //Lista de funções
  val multiplicaPor10: (Int => Int) = x => x * 10
  val somaCom4: (Int => Int) = x => x + 4
  val subtraiDe5: (Int => Int) = x => x - 5
  val operacoes: (List[Int => Int]) = List(multiplicaPor10, somaCom4, subtraiDe5)

  // Aplicar todas as funções da lista 'operacoes' sobre cada elemento de 'numeros'
  def aplicarOperacaoes(numeros: List[Int]): List[Int] = {
    numeros.map(num => operacoes.foldLeft(num)((acc, op) => op(acc)))
  }

  def repetirElementos(lista: List[Int]): List[Int] = {
    lista match {
      case List() => List()
      case cabeca :: cauda => cabeca :: cabeca :: repetirElementos(cauda)
    }
  }

  // ENTRADA
  val entrada1_Q2: (List[Int]) = List(1, 2, 3)
  val entrada2_Q2: (List[Int]) = List(10)
  val entrada3_Q2: (List[Int]) = List()
  //PROCESSAMENTO
  // Aplica as operações
  val aux1_Q2 = aplicarOperacaoes(entrada1_Q2)
  val aux2_Q2 = aplicarOperacaoes(entrada2_Q2)
  val aux3_Q2 = aplicarOperacaoes(entrada3_Q2)
  // Duplicar cada elemento do resultado final
  val saida1_Q2 = repetirElementos(aux1_Q2)
  val saida2_Q2 = repetirElementos(aux2_Q2)
  val saida3_Q2 = repetirElementos(aux3_Q2)
  // SAÍDA
  println("************** QUESTÃO 2 **************")
  println(saida1_Q2)
  println(saida2_Q2)
  println(saida3_Q2)

  //////////////////// QUESTÃO 3
  def multiplicaLista(lista: List[Int]): Int = {
    // Função auxiliar recursiva
    def multiplicaListaRecursao(lista: List[Int], acumulador: Int): Int = {
      lista match {
        case List() => acumulador // Caso base: lista vazia, retorna o acumulador
        case cabeca :: cauda => multiplicaListaRecursao(cauda, acumulador * cabeca) // Multiplica o elemento atual e avança na recursão
      }
    }
    // Chamada inicial da função auxiliar com acumulador com 1
    multiplicaListaRecursao(lista, 1)
  }

  // ENTRADA
  val entrada1_Q3 = List(1, 2, 3, 4, 5)
  val entrada2_Q3 = List(3)
  val entrada3_Q3 = List()
  // PROCESSAMENTO
  val saida1_Q3 = multiplicaLista(entrada1_Q3)
  val saida2_Q3 = multiplicaLista(entrada2_Q3)
  val saida3_Q3 = multiplicaLista(entrada3_Q3)
  // SAÍDA
  println("************** QUESTÃO 3 **************")
  println(saida1_Q3)
  println(saida2_Q3)
  println(saida3_Q3)

  //////////////////// QUESTÃO 4
  def processarLista(lista: List[List[Int]]): List[Int] = {
    lista.flatMap(x => x)              // Combina todas as sublistas em uma única lista
         .distinct                     // Remove os valores duplicados
         .sorted(Ordering.Int.reverse) // Ordena a lista em ordem decrescente
  }

  // ENTRADA
  val entrada1_Q4 = List(List(3, 1, 4), List(1, 5, 9), List(2, 6, 5))
  val entrada2_Q4 = List(List(4, 1, 4))
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
  // Função 'filtrarSomar' que recebe duas funções (filtro e mapeamento)
  def filtrarSomar(filterFunc: Int => Boolean, mapFunc: Int => Int): List[Int] => Int = {
    // Retorna uma nova função que recebe uma lista de Int e retorna um Int
    lista => lista.filter(filterFunc).map(mapFunc).sum
  }

  // Exemplo de funções de filtro e mapeamento
  val filtroImpar: Int => Boolean = x => x % 2 == 1
  val mapDobro: Int => Int = x => x * 2
  
  // Usando a função 'processa' com os exemplos de filtro e mapeamento
  val processa = filtrarSomar(filtroImpar, mapDobro)

  // ENTRADA
  val entrada1_Q5 = List(1, 2, 3, 4)
  val entrada2_Q5 = List(3, 5)
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
    lista => lista.forall(isValid)
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
  val todosPares = geradorDeValidador(par)
  val todosMaioresQue25 = geradorDeValidador(maiorQue25)
  val todosPositivos = geradorDeValidador(positivo)
  // SAÍDA
  println("************** QUESTÃO 6 **************")
  println(todosPares(entrada1_Q6))
  println(todosMaioresQue25(entrada2_Q6))
  println(todosPositivos(entrada3_Q6))
}
