<?php
//PHP
//PHP não tem co-rotinas nativas, mas pode-se simular um comportamento semelhante usando generators e funções assíncronas.
function tarefa1() {
    for ($i = 1; $i <= 3; $i++) {
        echo "Tarefa 1 - execução $i\n";
        yield;
        sleep(1);
    }
}

function tarefa2() {
    for ($i = 1; $i <= 2; $i++) {
        echo "Tarefa 2 - execução $i\n";
        yield;
        sleep(2);
    }
}

$t1 = tarefa1();
$t2 = tarefa2();

while ($t1->valid() || $t2->valid()) {
    if ($t1->valid()) $t1->next();
    if ($t2->valid()) $t2->next();
}
