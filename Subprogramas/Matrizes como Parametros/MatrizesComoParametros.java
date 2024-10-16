//Java
//Parametro Real: m
//Parametro Formal: matriz
//Passagem de Parâmetro do tipo Matriz é, por padrão, por Referência

public class MatrizesComoParametros {
    // Função para imprimir a matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    // Função para dobrar os elementos da matriz
    public static void dobrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] *= 2;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        
        System.out.println("Antes de dobrar:");
        imprimirMatriz(m);

        dobrarMatriz(m);

        System.out.println("Depois de dobrar:");
        imprimirMatriz(m);
    }
}
