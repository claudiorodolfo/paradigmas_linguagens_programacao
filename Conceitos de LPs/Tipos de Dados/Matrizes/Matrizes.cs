//C Sharp (C#)
//Não tem suporte a slicing (fatias)
using System;

class Matrizes {
    static void Main() {
        // Definição e inicialização
        int[,] matriz = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

        // Exibir os elementos da matriz
        for (int i = 0; i < matriz.GetLength(0); i++) {
            for (int j = 0; j < matriz.GetLength(1); j++) {
                Console.Write(matriz[i, j] + " ");
            }
            Console.WriteLine();
        }
    }
}
