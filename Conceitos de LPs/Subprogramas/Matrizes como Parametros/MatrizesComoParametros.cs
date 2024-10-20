//C Sharp (C#)
//Parametro Real: m
//Parametro Formal: matriz
//Passagem de Parâmetro do tipo Matriz é, por padrão, por Referência

using System;

class MatrizesComoParametros {
    // Função para imprimir a matriz
    public static void ImprimirMatriz(int[,] matriz) {
        for (int i = 0; i < matriz.GetLength(0); i++) {
            for (int j = 0; j < matriz.GetLength(1); j++) {
                Console.Write(matriz[i, j] + " ");
            }
            Console.WriteLine();
        }
    }

    // Função para dobrar os elementos da matriz
    public static void DobrarMatriz(int[,] matriz) {
        for (int i = 0; i < matriz.GetLength(0); i++) {
            for (int j = 0; j < matriz.GetLength(1); j++) {
                matriz[i, j] *= 2;
            }
        }
    }

    static void Main() {
        int[,] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        
        Console.WriteLine("Antes de dobrar:");
        ImprimirMatriz(m);

        DobrarMatriz(m);

        Console.WriteLine("Depois de dobrar:");
        ImprimirMatriz(m);
    }
}
