#Python
#Não tem registros. Classe é uma espécie de um Registro Aprimorado, pois também Abstrai Dados heterogêneos, mas adiciona Encapsulamento, Herança e Polimorfismo.

class Pessoa:
    def __init__(self, nome, idade, altura):
        self.nome = nome
        self.idade = idade
        self.altura = altura

# Criando objeto da classe Pessoa
pessoa = Pessoa("Laura", 22, 1.60)

# Exibindo valores
print(f"Nome: {pessoa.nome}")
print(f"Idade: {pessoa.idade}")
print(f"Altura: {pessoa.altura} m")
