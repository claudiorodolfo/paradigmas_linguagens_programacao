//Rust
//Parametro Real: m
//Parametro Formal: matriz
// Observe o &mut indicando que a passagem de parametro é por referência e o dado é mutável

// Função para imprimir a matriz
fn imprimir_matriz(matriz: &mut [[i32; 4]; 2]) {
    for linha in matriz {
        for elemento in linha.iter() {
            print!("{} ", elemento);
        }
        println!();
    }
}

// Função para dobrar os elementos da matriz
// Passagem de Parâmetro por Referência
fn dobrar_matriz(matriz: &mut [[i32; 4]; 2]) {
    for linha in matriz.iter_mut() {
        for elemento in linha.iter_mut() {
            *elemento *= 2;
        }
    }
}

// Função para dobrar os elementos da matriz
// Passagem de Parâmetro por Valor
/*
fn dobrar_matriz(matriz: [[i32; 4]; 2]) {
	let mut nova_matriz = matriz; // Faz uma cópia da matriz original
    for linha in nova_matriz.iter_mut() {
        for elemento in linha.iter_mut() {
            *elemento *= 2;
        }
    }
}
*/

fn main() {
    let mut m: [[i32; 4]; 2] = [[1, 2, 3, 4], [5, 6, 7, 8]];

    println!("Antes de dobrar:");
    imprimir_matriz(&mut m);

    dobrar_matriz(&mut m);

    println!("Depois de dobrar:");
    imprimir_matriz(&mut m);

	/*
	//Passagem de parâmetro por valor
    let m: [[i32; 4]; 2] = [[1, 2, 3, 4], [5, 6, 7, 8]];
    imprimir_matriz(m);
    dobrar_matriz(m);
    imprimir_matriz(m);
	*/
}
