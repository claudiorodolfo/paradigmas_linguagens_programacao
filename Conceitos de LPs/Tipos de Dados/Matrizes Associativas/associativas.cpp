//C++
//Uso de biblioteca
#include <iostream>
#include <map>

using namespace std;

int main() {
    map<std::string, int> matriz;

    // Definição e inicialização
    matriz["um"] = 1;
    matriz["dois"] = 2;
    matriz["tres"] = 3;

    // Acessar elementos
    cout << "Valor para 'dois': " << matriz["dois"] << endl;

    // Remover um elemento
    matriz.erase("tres");

    // Iterar pela matriz
    for (const auto &par : matriz) {
        cout << par.first << ": " << par.second << endl;
    }

    return 0;
}
