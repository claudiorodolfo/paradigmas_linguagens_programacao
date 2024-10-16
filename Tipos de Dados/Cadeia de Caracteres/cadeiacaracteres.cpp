//C++
#include <iostream>
#include <string>

using namespace std;

int main() {
    string str1 = "Olá";
    string str2 = "Mundo";

    // Concatenar
    string concatenado = str1 + " " + str2;
    cout << "Concatenado: " << concatenado << endl;

    // Substring
    string sub = concatenado.substr(0, 3);
    cout << "Substring: " << sub << endl;

    // Comparar strings
    bool iguais = (str1 == str2);
    cout << "As strings são iguais? " << iguais << endl;

    // Tamanho da string
    cout << "Tamanho de str1: " << str1.length() << endl;
    
    return 0;
}
