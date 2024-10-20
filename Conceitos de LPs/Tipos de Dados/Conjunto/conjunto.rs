//Rust

use std::collections::HashSet;

fn main() {
    // Definindo e inicializando conjuntos
    let conjunto_a: HashSet<i32> = [1, 2, 3, 4, 5].iter().cloned().collect();
    let conjunto_b: HashSet<i32> = [4, 5, 6, 7, 8].iter().cloned().collect();

    // União
    let uniao: HashSet<_> = conjunto_a.union(&conjunto_b).collect();

    // Intersecção
    let intersecao: HashSet<_> = conjunto_a.intersection(&conjunto_b).collect();

    // Diferença
    let diferenca: HashSet<_> = conjunto_a.difference(&conjunto_b).collect();

    // Exibindo resultados
    println!("União: {:?}", uniao);
    println!("Intersecção: {:?}", intersecao);
    println!("Diferença: {:?}", diferenca);
}
