//Rust

use std::ops::Add;

#[derive(Debug)]
struct Ponto {
    x: i32,
    y: i32,
}

// Implementando a sobrecarga do operador +
impl Add for Ponto {
    type Output = Ponto;

    fn add(self, outro: Ponto) -> Ponto {
        Ponto {
            x: self.x + outro.x,
            y: self.y + outro.y,
        }
    }
}

fn main() {
    let p1 = Ponto { x: 2, y: 3 };
    let p2 = Ponto { x: 4, y: 5 };
	// Usando o operador + sobrecarregado
    let p3 = p1 + p2;  

    println!("p3 = ({}, {})", p3.x, p3.y);
}
