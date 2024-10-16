//JavaScript
//Parametro Real: m
//Parametro Formal: matriz
//Passagem de Parâmetro do tipo Matriz é, por padrão, por Referência

// Função para imprimir a matriz
function imprimirMatriz(matriz) {
    matriz.forEach(linha => {
        console.log(linha.join(" "));
    });
}

// Função para dobrar os elementos da matriz
function dobrarMatriz(matriz) {
    for (let i = 0; i < matriz.length; i++) {
        for (let j = 0; j < matriz[i].length; j++) {
            matriz[i][j] *= 2;
        }
    }
}

const m = [[1, 2, 3, 4], [5, 6, 7, 8]];

console.log("Antes de dobrar:");
imprimirMatriz(m);

dobrarMatriz(m);

console.log("Depois de dobrar:");
imprimirMatriz(m);
