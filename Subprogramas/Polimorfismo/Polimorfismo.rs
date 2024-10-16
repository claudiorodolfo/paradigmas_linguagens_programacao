//Rust não suporta diretamente sobrecarga de subprogramas. 
//O polimorfismo é implementado por meio de traits (semelhantes às interfaces em outras linguagens).

struct Polimorfismo;

impl Polimorfismo {
    fn print_str(&self, s: &str) {
        println!("{}", s);
    }

    fn print_int(&self, i: i32) {
        println!("{}", i);
    }
}

fn main() {
    let p = Polimorfismo;
    p.print_str("Hello");  // chama o método que aceita string
    p.print_int(10);       // chama o método que aceita int
}
