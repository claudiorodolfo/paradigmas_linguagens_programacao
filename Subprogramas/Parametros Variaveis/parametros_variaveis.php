<?php
//PHP
function printNumbers(...$numbers) {
    foreach ($numbers as $number) {
        echo $number . "\n";
    }
}

// Chama a função com um número variável de parâmetros
printNumbers(1, 2, 3, 4, 5);

?>