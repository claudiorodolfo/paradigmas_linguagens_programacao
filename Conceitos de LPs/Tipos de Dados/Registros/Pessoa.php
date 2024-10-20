<?php
//PHP
//Não tem registros. Classe é uma espécie de um Registro Aprimorado, pois também Abstrai Dados heterogêneos, mas adiciona Encapsulamento, Herança e Polimorfismo.

class Pessoa {
    public $nome;
    public $idade;
    public $altura;

    function __construct($nome, $idade, $altura) {
        $this->nome = $nome;
        $this->idade = $idade;
        $this->altura = $altura;
    }
}

// Criando um objeto
$pessoa = new Pessoa("Fernanda", 33, 1.70);

// Exibindo valores
echo "Nome: " . $pessoa->nome . "\n";
echo "Idade: " . $pessoa->idade . "\n";
echo "Altura: " . $pessoa->altura . " m\n";
?>
