<?php
//PHP
//PHP 8.1 introduziu o suporte a enumerações.
enum DiaDaSemana: int {
    case Segunda = 0;
    case Terca = 1;
    case Quarta = 2;
    case Quinta = 3;
    case Sexta = 4;
    case Sabado = 5;
    case Domingo = 6;
}

$hoje = DiaDaSemana::Terca;

// Exibindo valor ordinal
echo "Hoje é: " . $hoje->name . "\n";

// Usando a posição ordinal
echo "Posição ordinal: " . $hoje->value . "\n";

if ($hoje === DiaDaSemana::Terca) {
    echo "Hoje é terça-feira.\n";
}
?>
