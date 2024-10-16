//C++
#include <iostream>

using namespace std;
int main() {
    int valor;
    int* ponteiro;              // Declaração do ponteiro

    cout << "Informe um valor inteiro: ";
    cin >> valor;

    ponteiro = &valor;         // Atribui o endereço da variável 'valor' ao ponteiro

    // Exibindo o valor através do ponteiro
    cout << "O valor armazenado no ponteiro é: " << *ponteiro << endl;
	// Exibindo o endereço da variável apontada pelo ponteiro
    cout << "O endereço da variável valor é: " << ponteiro << endl;

    // Alterando o valor através do ponteiro
    *ponteiro += 10;
    cout << "O novo valor armazenado no ponteiro é: " << *ponteiro << endl;

    return 0;
}
