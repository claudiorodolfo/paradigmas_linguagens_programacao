<?php
//PHP
//Parametro Real: $m
//Parametro Formal: $matriz
// Observe o & no parâmetro do subprograma dobrarMatriz, indicando que a passagem de parametro é por referência

// Função para imprimir a matriz
function imprimirMatriz($matriz) {
    foreach ($matriz as $linha) {
        echo implode(" ", $linha) . "\n";
    }
}

// Função para dobrar os elementos da matriz
// Passagem de Parâmetro por Referência
function dobrarMatriz(&$matriz) {
    foreach ($matriz as &$linha) {
        foreach ($linha as &$elemento) {
            $elemento *= 2;
        }
    }
}

/*
// Passagem de Parâmetro por Valor
function dobrarMatriz($matriz) {
    foreach ($matriz as $linha) {
        foreach ($linha as $elemento) {
            $elemento *= 2;
        }
    }
}
*/

$m = [[1, 2, 3, 4], [5, 6, 7, 8]];

echo "Antes de dobrar:\n";
imprimirMatriz($m);

dobrarMatriz($m);

echo "Depois de dobrar:\n";
imprimirMatriz($m);
?>
