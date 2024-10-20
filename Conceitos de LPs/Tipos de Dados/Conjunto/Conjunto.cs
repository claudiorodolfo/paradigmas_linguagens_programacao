//CSharp

using System;
using System.Collections.Generic;

class Conjunto {
    static void Main() {
        // Definindo e inicializando conjuntos
        HashSet<int> conjuntoA = new HashSet<int> { 1, 2, 3, 4, 5 };
        HashSet<int> conjuntoB = new HashSet<int> { 4, 5, 6, 7, 8 };

        // União
        HashSet<int> uniao = new HashSet<int>(conjuntoA);
        uniao.UnionWith(conjuntoB);

        // Intersecção
        HashSet<int> intersecao = new HashSet<int>(conjuntoA);
        intersecao.IntersectWith(conjuntoB);

        // Diferença
        HashSet<int> diferenca = new HashSet<int>(conjuntoA);
        diferenca.ExceptWith(conjuntoB);

        // Exibindo resultados
        Console.WriteLine("União: " + string.Join(", ", uniao));
        Console.WriteLine("Intersecção: " + string.Join(", ", intersecao));
        Console.WriteLine("Diferença: " + string.Join(", ", diferenca));
    }
}
