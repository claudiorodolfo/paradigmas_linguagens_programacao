//C Sharp (C#)
//C# oferece suporte a enumerações, mas não a subfaixas.
using System;

class Ordinais {
    enum DiaDaSemana { Segunda, Terca, Quarta, Quinta, Sexta, Sabado, Domingo }

    static void Main() {
        DiaDaSemana hoje = DiaDaSemana.Terca;

        // Exibindo valor ordinal
        Console.WriteLine("Hoje é: " + hoje);

        // Usando a posição ordinal
        Console.WriteLine("Posição ordinal: " + (int)hoje);

        if (hoje == DiaDaSemana.Terca) {
            Console.WriteLine("Hoje é terça-feira.");
        }
    }
}
