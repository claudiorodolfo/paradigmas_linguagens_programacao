//JavaScript
// Não suporta sobrecarga de subprogramas diretamente (o último método definido sobrescreve o anterior).
// Uma forma de simular subprogramas polimorficos é um único subprograma que filtra o dado.

function print(value) {
    if (typeof value === "string") {
        console.log(value);
    } else if (typeof value === "number") {
        console.log(value);
    }
}

print("Hello");  // imprime a string
print(10);       // imprime o número
