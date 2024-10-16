//Rust
//Uso de Biblioteca

use std::collections::HashMap;

fn main() {
    let mut matriz = HashMap::new();

    // Definição e inicialização
    matriz.insert("um", 1);
    matriz.insert("dois", 2);
    matriz.insert("tres", 3);

    // Acessar elementos
    println!("Valor para 'dois': {}", matriz["dois"]);

    // Remover um elemento
    matriz.remove("tres");

    // Iterar pela matriz
    for (chave, valor) in &matriz {
        println!("{}: {}", chave, valor);
    }
}
