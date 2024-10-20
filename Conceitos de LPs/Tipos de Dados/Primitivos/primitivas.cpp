//C++
#include <iostream>
using namespace std;

int main() {
    signed char inteiroPequeno = 100;      // Inteiro pequeno (1 byte)
    int inteiro = 1000;                    // Inteiro (4 bytes)
    long long int inteiroGrande = 1000000; // Inteiro grande (8 bytes)
    float pontoFlutuanteSimples = 3.14f;   // Ponto flutuante simples (4 bytes)
    double pontoFlutuanteDuplo = 3.14159265359; // Ponto flutuante de dupla precisão (8 bytes)
    bool booleano = true;                  // Booleano
    char caractere = 'A';                  // Caractere
    unsigned int inteiroSemSinal = 2000;   // Inteiro sem sinal

    cout << "Inteiro pequeno: " << (int)inteiroPequeno << endl;
    cout << "Inteiro: " << inteiro << endl;
    cout << "Inteiro grande: " << inteiroGrande << endl;
    cout << "Ponto flutuante simples: " << pontoFlutuanteSimples << endl;
    cout << "Ponto flutuante de dupla precisão: " << pontoFlutuanteDuplo << endl;
    cout << "Booleano: " << booleano << endl;
    cout << "Caractere: " << caractere << endl;
    cout << "Inteiro sem sinal: " << inteiroSemSinal << endl;

    return 0;
}
