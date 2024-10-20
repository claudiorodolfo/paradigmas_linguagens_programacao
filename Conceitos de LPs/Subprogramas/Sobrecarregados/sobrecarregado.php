<?php
// PHP
// Não suporta sobrecarga de subprogramas diretamente (o último método definido sobrescreve o anterior).
// Uma forma de simular subprogramas sobrecarregados é um único subprograma que filtra o dado.

function imprimir($value) {
    if (is_string($value)) {
        echo $value;
    } elseif (is_int($value)) {
        echo $value;
    }
}

imprimir("Hello");  // imprime a string
imprimir(10);       // imprime o inteiro
?>