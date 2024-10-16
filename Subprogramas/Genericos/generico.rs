//Rust 

fn maior_valor<T: PartialOrd>(a: T, b: T) -> T {
    if a > b { a } else { b }
}

fn main() {
    println!("Maior entre 10 e 20: {}", maior_valor(10, 20));
    println!("Maior entre 3.14 e 2.71: {}", maior_valor(3.14, 2.71));
}
