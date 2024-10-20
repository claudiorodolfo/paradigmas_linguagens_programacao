//JavaScript

// Definindo e inicializando conjuntos
const conjuntoA = new Set([1, 2, 3, 4, 5]);
const conjuntoB = new Set([4, 5, 6, 7, 8]);

// Função para união
function uniao(setA, setB) {
    return new Set([...setA, ...setB]);
}

// Função para intersecção
function intersecao(setA, setB) {
    return new Set([...setA].filter(x => setB.has(x)));
}

// Função para diferença
function diferenca(setA, setB) {
    return new Set([...setA].filter(x => !setB.has(x)));
}

// Exibindo resultados
console.log("União:", Array.from(uniao(conjuntoA, conjuntoB)));
console.log("Intersecção:", Array.from(intersecao(conjuntoA, conjuntoB)));
console.log("Diferença:", Array.from(diferenca(conjuntoA, conjuntoB)));
