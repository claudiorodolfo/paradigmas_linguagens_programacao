//C Sharp (C#)
using System;

class CadeiaCaracteres {
    static void Main() {
        string str1 = "Olá";
        string str2 = "Mundo";

        // Concatenar
        string concatenado = str1 + " " + str2;
        Console.WriteLine("Concatenado: " + concatenado);

        // Substring
        string sub = concatenado.Substring(0, 3);
        Console.WriteLine("Substring: " + sub);

        // Comparar strings
        bool iguais = str1.Equals(str2);
        Console.WriteLine("As strings são iguais? " + iguais);

        // Tamanho da string
        Console.WriteLine("Tamanho de str1: " + str1.Length);
    }
}
