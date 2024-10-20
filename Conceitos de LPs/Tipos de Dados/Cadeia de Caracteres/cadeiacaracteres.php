<?php
	//PHP
    $str1 = "Olá";
    $str2 = "Mundo";

    // Concatenar
    $concatenado = $str1 . " " . $str2;
    echo "Concatenado: $concatenado\n";

    // Substring
    $sub = substr($concatenado, 0, 3);
    echo "Substring: $sub\n";

    // Comparar strings
    $iguais = ($str1 === $str2);
    echo "As strings são iguais? " . ($iguais ? 'sim' : 'não') . "\n";

    // Tamanho da string
    echo "Tamanho de str1: " . strlen($str1) . "\n";
?>
