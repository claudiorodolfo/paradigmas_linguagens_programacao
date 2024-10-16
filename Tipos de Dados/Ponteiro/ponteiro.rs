//Rust
use std::io;

fn main() {
    let mut entrada = String::new();
    println!("Informe um valor inteiro: ");
    io::stdin().read_line(&mut entrada).expect("Falha ao ler a entrada");

    let mut valor: i32 = entrada.trim().parse().expect("Por favor, insira um número");

    let ponteiro: *mut i32 = &mut valor; // Atribui o endereço da variável 'valor' ao ponteiro

    unsafe {
        // Exibindo o valor através do ponteiro
        println!("O valor armazenado no ponteiro é: {}", *ponteiro);
        // Exibindo o endereço da variável apontada pelo ponteiro
        println!("O endereço da variável valor é: {:?}", ponteiro);
        
        // Alterando o valor através do ponteiro
        *ponteiro += 10;
        println!("O novo valor armazenado no ponteiro é: {}", *ponteiro);
    }
}
