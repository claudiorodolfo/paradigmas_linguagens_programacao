//Rust
//Não tem suporte a slicing (fatias)

fn main() {
    // Definição e inicialização
    let matriz = [[1, 2, 3, 4], [5, 6, 7, 8]];

    // Exibir os elementos da matriz
    for linha in matriz.iter() {
        for &elemento in linha.iter() {
            print!("{} ", elemento);
        }
        println!();
    }
}
