//JavaScript
//Suporte Nativo

// Definição e inicialização
let matriz = {
    "um": 1,
    "dois": 2,
    "tres": 3
};

// Acessar elementos
console.log("Valor para 'dois':", matriz["dois"]);

// Remover um elemento
delete matriz["tres"];

// Iterar pela matriz
for (let chave in matriz) {
    console.log(chave + ": " + matriz[chave]);
}
