//C++
#include <iostream>
#include <set>

using namespace std;

int main() {
    // Definindo e inicializando conjuntos
    set<int> conjuntoA = {1, 2, 3, 4, 5};
    set<int> conjuntoB = {4, 5, 6, 7, 8};

    // União
    set<int> uniao;
    set_union(conjuntoA.begin(), conjuntoA.end(),
                   conjuntoB.begin(), conjuntoB.end(),
                   inserter(uniao, uniao.begin()));

    // Intersecção
    set<int> intersecao;
    set_intersection(conjuntoA.begin(), conjuntoA.end(),
                          conjuntoB.begin(), conjuntoB.end(),
                          inserter(intersecao, intersecao.begin()));

    // Diferença
    set<int> diferenca;
    set_difference(conjuntoA.begin(), conjuntoA.end(),
                        conjuntoB.begin(), conjuntoB.end(),
                        inserter(diferenca, diferenca.begin()));

    // Exibindo resultados
    cout << "União: ";
    for (int i : uniao) cout << i << " ";
    cout << "\nIntersecção: ";
    for (int i : intersecao) cout << i << " ";
    cout << "\nDiferença: ";
    for (int i : diferenca) cout << i << " ";
    cout << endl;

    return 0;
}
