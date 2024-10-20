//C++
#include <iostream>
using namespace std;
class Ponto {
public:
    int x, y;

    Ponto(int x, int y) {
	    this->x = x;
    	this->y = y;
	}

    // Sobrecarga do operador +
    Ponto operator+(Ponto& outro) {
        return Ponto(x + outro.x, y + outro.y);
    }
};

int main() {
    Ponto p1(2, 3);
    Ponto p2(4, 5);
	// Usando o operador + sobrecarregado
    Ponto p3 = p1 + p2;  

    cout << "p3 = (" << p3.x << ", " << p3.y << ")" << endl;
    return 0;
}
