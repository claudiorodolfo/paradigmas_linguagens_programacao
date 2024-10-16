<?php
//PHP
//Suporte Nativo

// Definição e inicialização
$matriz = array(
    "um" => 1,
    "dois" => 2,
    "tres" => 3
);

// Acessar elementos
echo "Valor para 'dois': " . $matriz["dois"] . "\n";

// Remover um elemento
unset($matriz["tres"]);

// Iterar pela matriz
foreach ($matriz as $chave => $valor) {
    echo "$chave: $valor\n";
}
?>
