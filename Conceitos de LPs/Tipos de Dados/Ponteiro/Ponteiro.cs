//C Sharp (C#)
using System;

class Program {
    static unsafe void Main() {
        int valor;
        int* ponteiro; // Declaração do ponteiro

        Console.Write("Informe um valor inteiro: ");
        valor = int.Parse(Console.ReadLine());

        ponteiro = &valor; // Atribui o endereço da variável 'valor' ao ponteiro

        // Exibindo o valor através do ponteiro
        Console.WriteLine($"O valor armazenado no ponteiro é: {*ponteiro}");
        // Exibindo o endereço da variável apontada pelo ponteiro
        Console.WriteLine($"O endereço da variável valor é: {(long)ponteiro}");		
        
        // Alterando o valor através do ponteiro
        *ponteiro += 10;
        Console.WriteLine($"O novo valor armazenado no ponteiro é: {*ponteiro}");
    }
}
