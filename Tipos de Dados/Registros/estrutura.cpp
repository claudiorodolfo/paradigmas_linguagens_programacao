//C++
//Aqui o registro é chamado de Estrutura (struct)
#include <iostream>
#include <string>

using namespace std;

struct Pessoa {
    string nome;
    int idade;
    float altura;
};

int main() {
    Pessoa pessoa;

    // Atribuindo valores
    pessoa.nome = "Maria";
    pessoa.idade = 25;
    pessoa.altura = 1.70;

    // Exibindo valores
    cout << "Nome: " << pessoa.nome << endl;
    cout << "Idade: " << pessoa.idade << endl;
    cout << "Altura: " << pessoa.altura << " m" << endl;

    return 0;
}
