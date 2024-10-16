//Rust
//A depender do momento a União Forma vai ter possuir internamente ou uma estrutura Circulo, ou uma estrutura Triangulo, ou uma estrutura Retangulo.

union Forma {
    circulo: Circulo,
    triangulo: Triangulo,
    retangulo: Retangulo,
}

struct Circulo {
    raio: f32,
}

struct Triangulo {
    base: f32,
    altura: f32,
}

struct Retangulo {
    largura: f32,
    altura: f32,
}

fn main() {
    let forma = Forma {
        circulo: Circulo { raio: 5.0 },
    };

    unsafe {
        // Usando como círculo
        println!("Círculo com raio: {}", forma.circulo.raio);
    }

    let forma = Forma {
        retangulo: Retangulo {
            largura: 10.0,
            altura: 20.0,
        },
    };

    unsafe {
        // Usando como retângulo
        println!("Retângulo com largura: {} e altura: {}", forma.retangulo.largura, forma.retangulo.altura);
    }
}
