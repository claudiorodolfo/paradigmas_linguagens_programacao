//C Sharp (C#
using System;

class Program {
    static void PrintNumbers(params int[] numbers) {
        foreach (int number in numbers) {
            Console.WriteLine(number);
        }
    }


    static void Main() {
		// Chama o método com um número variável de parâmetros
        PrintNumbers(1, 2, 3, 4, 5);  
    }
}

