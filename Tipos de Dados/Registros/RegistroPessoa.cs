//C Sharp (C#)
//Aqui o registro é chamado de Estrutura (struct)

using System;

struct Pessoa {
    public string Nome;
    public int Idade;
    public float Altura;
}

class RegistroPessoa {
    static void Main() {
        Pessoa pessoa;

        // Atribuindo valores
        pessoa.Nome = "Carlos";
        pessoa.Idade = 40;
        pessoa.Altura = 1.80f;

        // Exibindo valores
        Console.WriteLine("Nome: " + pessoa.Nome);
        Console.WriteLine("Idade: " + pessoa.Idade);
        Console.WriteLine("Altura: " + pessoa.Altura + " m");
    }
}
