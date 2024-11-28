object Main extends App {
    var multiplicador = 2 // Variável capturada pela closure
    val multiplica = (x: Int) => x * multiplicador // Closure
    println(multiplica(5)) // Saída: 10

    multiplicador = 3	//Mudei uma variável externa, e a função vai ter resposta diferente
    println(multiplica(5)) // Saída: 15
}