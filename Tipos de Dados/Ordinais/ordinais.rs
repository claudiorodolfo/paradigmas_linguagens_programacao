//Rust
//Rust oferece suporte a enumerações, mas não diretamente a subfaixas.
enum DiaDaSemana {
    Segunda,
    Terca,
    Quarta,
    Quinta,
    Sexta,
    Sabado,
    Domingo,
}

fn main() {
    let hoje = DiaDaSemana::Terca;

    // Usando a posição ordinal
    let posicao_ordinal = hoje as u32;
    println!("Posição ordinal: {}", posicao_ordinal);

    // Comparação
    match hoje {
        DiaDaSemana::Terca => println!("Hoje é terça-feira."),
        _ => println!("Outro dia."),
    }
}
