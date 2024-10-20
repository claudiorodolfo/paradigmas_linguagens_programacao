//Rust
fn main() {
    let str1 = "Olá";
    let str2 = "Mundo";

    // Concatenar
    let concatenado = format!("{} {}", str1, str2);
    println!("Concatenado: {}", concatenado);

    // Substring
    let sub = &concatenado[0..3];
    println!("Substring: {}", sub);

    // Comparar strings
    let iguais = str1 == str2;
    println!("As strings são iguais? {}", iguais);

    // Tamanho da string
    println!("Tamanho de str1: {}", str1.len());
}
