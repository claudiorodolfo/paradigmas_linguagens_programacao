//C++

#include <iostream>

using namespace std;

class Sobrecarregado {
public:
    void imprimir(string s) {
        cout << s << endl;
    }

    void imprimir(int i) {
        cout << i << endl;
    }
};

int main() {
    Sobrecarregado p;
    p.imprimir("Hello");  // chama o método que aceita string
    p.imprimir(10);       // chama o método que aceita int
    return 0;
}
