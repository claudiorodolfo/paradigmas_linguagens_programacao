//C++

#include <iostream>
using namespace std;

template <typename T>
T maiorValor(T a, T b) {
    return (a > b) ? a : b;
}

int main() {
    cout << "Maior entre 10 e 20: " << maiorValor(10, 20) << endl;
    cout << "Maior entre 3.14 e 2.71: " << maiorValor(3.14, 2.71) << endl;
    return 0;
}
