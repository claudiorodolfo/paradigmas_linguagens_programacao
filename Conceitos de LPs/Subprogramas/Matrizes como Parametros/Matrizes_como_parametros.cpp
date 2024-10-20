//C++
//Parametro Real: m
//Parametro Formal: matriz
//Passagem de Parâmetro do tipo Matriz é, por padrão, por Referência

#include <iostream>
using namespace std;

// Função para imprimir a matriz
void imprimirMatriz(int matriz[2][4], int linhas, int colunas) {
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            cout << matriz[i][j] << " ";
        }
        cout << endl;
    }
}

// Função para dobrar os elementos da matriz
void dobrarMatriz(int matriz[2][4], int linhas, int colunas) {
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            matriz[i][j] *= 2;
        }
    }
}

int main() {
    int m[2][4] = {{1, 2, 3, 4}, {5, 6, 7, 8}};
    
    cout << "Antes de dobrar:" << endl;
    imprimirMatriz(m, 2, 4);

    dobrarMatriz(m, 2, 4);

    cout << "Depois de dobrar:" << endl;
    imprimirMatriz(m, 2, 4);
    
    return 0;
}