//C Sharp (C#)
using System;

class Primitivas {
    static void Main() {
        sbyte inteiroPequeno = 100;             // Inteiro pequeno (1 byte)
        int inteiro = 1000;                     // Inteiro (4 bytes)
        long inteiroGrande = 1000000L;          // Inteiro grande (8 bytes)
        float pontoFlutuanteSimples = 3.14f;    // Ponto flutuante simples (4 bytes)
        double pontoFlutuanteDuplo = 3.14159265359; // Ponto flutuante de dupla precisão (8 bytes)
        bool booleano = true;                   // Booleano
        char caractere = 'A';                   // Caractere
        uint inteiroSemSinal = 2000;            // Inteiro sem sinal (4 bytes)

        Console.WriteLine("Inteiro pequeno: " + inteiroPequeno);
        Console.WriteLine("Inteiro: " + inteiro);
        Console.WriteLine("Inteiro grande: " + inteiroGrande);
        Console.WriteLine("Ponto flutuante simples: " + pontoFlutuanteSimples);
        Console.WriteLine("Ponto flutuante de dupla precisão: " + pontoFlutuanteDuplo);
        Console.WriteLine("Booleano: " + booleano);
        Console.WriteLine("Caractere: " + caractere);
        Console.WriteLine("Inteiro sem sinal: " + inteiroSemSinal);
    }
}
