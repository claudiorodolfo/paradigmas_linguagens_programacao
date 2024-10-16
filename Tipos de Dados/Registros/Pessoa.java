//Java
//Não tem registros. Classe é uma espécie de um Registro Aprimorado, pois também Abstrai Dados heterogêneos, mas adiciona Encapsulamento, Herança e Polimorfismo.

public class Pessoa {
    String nome;
    int idade;
    float altura;

    public Pessoa(String nome, int idade, float altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30, 1.75f);

        // Exibindo valores
        System.out.println("Nome: " + pessoa.nome);
        System.out.println("Idade: " + pessoa.idade);
        System.out.println("Altura: " + pessoa.altura + " m");
    }
}
