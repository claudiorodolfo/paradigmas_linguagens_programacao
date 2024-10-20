<?php
//PHP
//Não tem suporte a slicing (fatias)

// Definição e inicialização
$matriz = [
    [1, 2, 3, 4],
    [5, 6, 7, 8]
];

// Exibir os elementos da matriz
for ($i = 0; $i < count($matriz); $i++) {
    for ($j = 0; $j < count($matriz[$i]); $j++) {
        echo $matriz[$i][$j] . " ";
    }
    echo "\n";
}
?>
