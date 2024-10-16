<?php
//JavaScript
// Não suporta sobrecarga de subprogramas diretamente (o último método definido sobrescreve o anterior).
// Uma forma de simular subprogramas polimorficos é um único subprograma que filtra o dado.

class Polimorfismo {
    public function imprimir($value) {
        if (is_string($value)) {
            echo $value;
        } elseif (is_int($value)) {
            echo $value;
        }
    }
}

$p = new Polimorfismo();
$p->imprimir("Hello");  // imprime a string
$p->imprimir(10);       // imprime o inteiro
?>