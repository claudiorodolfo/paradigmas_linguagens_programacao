//Java
//Não tem suporte a slicing (fatias)
public class Matrizes {
    public static void main(String[] args) {
        // Definição e inicialização
        int[][] matriz = { {1, 2, 3, 4}, {5, 6, 7, 8} };

        // Exibir os elementos da matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
