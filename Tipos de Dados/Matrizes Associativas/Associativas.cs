//C Sharp (C#)
//Uso de Biblioteca

using System;
using System.Collections.Generic;

class Associativas {
    static void Main() {
        Dictionary<string, int> matriz = new Dictionary<string, int>();

        // Definição e inicialização
        matriz["um"] = 1;
        matriz["dois"] = 2;
        matriz["tres"] = 3;

        // Acessar elementos
        Console.WriteLine("Valor para 'dois': " + matriz["dois"]);

        // Remover um elemento
        matriz.Remove("tres");

        // Iterar pela matriz
        foreach (var par in matriz) {
            Console.WriteLine(par.Key + ": " + par.Value);
        }
    }
}
