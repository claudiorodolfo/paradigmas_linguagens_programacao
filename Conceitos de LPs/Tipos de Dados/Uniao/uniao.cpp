//C++
#include <iostream>

using namespace std;

//A depender do momento a União Forma vai ter possuir internamente ou uma estrutura circulo, ou uma estrutura triangulo, ou uma estrutura retangulo.
union Forma {

    struct {
        float raio;
    } circulo;

    struct {
        float base, altura;
    } triangulo;

    struct {
        float largura, altura;
    } retangulo;
};

int main() {
    Forma forma;

    // Exemplo: Usando a forma como círculo
    forma.circulo.raio = 5.0;
    cout << "Círculo com raio: " << forma.circulo.raio << endl;

    // Exemplo: Usando a forma como retângulo
    forma.retangulo.largura = 10.0;
    forma.retangulo.altura = 20.0;
    cout << "Retângulo com largura: " << forma.retangulo.largura 
              << " e altura: " << forma.retangulo.altura << endl;

    return 0;
}
