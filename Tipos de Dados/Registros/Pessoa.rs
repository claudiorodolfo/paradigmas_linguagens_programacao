//Rust
//Aqui o registro é chamado de Estrutura (struct)

struct Pessoa {
    nome: String,
    idade: u32,
    altura: f32,
}

fn main() {
    let pessoa = Pessoa {
        nome: String::from("Marcos"),
        idade: 27,
        altura: 1.78,
    };

    // Exibindo valores
    println!("Nome: {}", pessoa.nome);
    println!("Idade: {}", pessoa.idade);
    println!("Altura: {} m", pessoa.altura);
}
