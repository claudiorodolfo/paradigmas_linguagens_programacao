//C++
//Em C++, podemos definir enumerações para valores ordinais personalizados, mas subfaixas não são suportadas diretamente.
#include <iostream>

using namespace std;

enum DiaDaSemana { Segunda, Terca, Quarta, Quinta, Sexta, Sabado, Domingo };

int main() {
    DiaDaSemana hoje = Terca;

    // Exibindo valor ordinal
    cout << "Hoje é: " << hoje << endl;

    // Usando a posição ordinal
    cout << "Posição ordinal: " << static_cast<int>(hoje) << endl;

    // Comparação
    if (hoje == Terca) {
        cout << "Hoje é terça-feira." << endl;
    }

    return 0;
}
