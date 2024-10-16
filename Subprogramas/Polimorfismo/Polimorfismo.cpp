//C++

#include <iostream>

using namespace std;

class Polimorfismo {
public:
    void imprimir(const string& s) {
        cout << s << std::endl;
    }

    void imprimir(int i) {
        cout << i << endl;
    }
};

int main() {
    Polimorfismo p;
    p.imprimir("Hello");  // chama o método que aceita string
    p.imprimir(10);       // chama o método que aceita int
    return 0;
}
