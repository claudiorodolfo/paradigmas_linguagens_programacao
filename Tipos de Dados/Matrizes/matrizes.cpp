//C++
//Não tem suporte a slicing (fatias)
#include <iostream>
using namespace std;

int main() {
    // Definição e inicialização
    int matriz[2][4] = {{1, 2, 3, 4}, {5, 6, 7, 8}};

    // Exibir os elementos da matriz
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 4; j++) {
            cout << matriz[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}
