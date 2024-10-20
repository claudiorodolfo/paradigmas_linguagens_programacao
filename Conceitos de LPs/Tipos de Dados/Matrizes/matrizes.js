//JavaScript
//Não tem suporte a slicing (fatias)

// Definição e inicialização
let matriz = [
  [1, 2, 3, 4],
  [5, 6, 7, 8]
];

// Exibir os elementos da matriz
for (let i = 0; i < matriz.length; i++) {
  for (let j = 0; j < matriz[i].length; j++) {
    process.stdout.write(matriz[i][j] + " ");
  }
  console.log();
}
