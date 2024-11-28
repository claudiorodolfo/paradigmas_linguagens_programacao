object Main extends App {
    def somaNormal(x: Int, y: Int): Int = x + y
   
    def somaCurried(x: Int)(y: Int): Int = x + y

    println(somaNormal(5, 10))  // 15
    println(somaCurried(5)(10)) //15
	
    val somaComCinco = somaCurried(5) _   //posso passar parte dos argumentos e retornar uma função em vez de um valor
    println(somaComCinco(10)) // 15
    
    //Conversão da soma normal para a curried
    val soma = (x: Int, y: Int) => x + y
	
    val somaConvertidaCurried = soma.curried
    println(somaConvertidaCurried(5)(10)) // 15
    val somaComCincoCurried = somaConvertidaCurried(5)
    println(somaComCincoCurried(10)) // 15    
	
	//Conversão da soma curried para normal
	val soma2: Int => Int => Int = a => b => a + b
	
	val somaConvertidaNormal: (Int, Int) => Int = Function.uncurried(soma2)
	println(somaNormal(3, 4)) // Saída: 7
}