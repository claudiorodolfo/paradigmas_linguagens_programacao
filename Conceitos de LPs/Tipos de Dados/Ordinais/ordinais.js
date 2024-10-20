//JavaScript
//JavaScript não tem suporte nativo para enumerações ou subfaixas, mas podemos usar objetos e constantes para simular o comportamento.
const DiaDaSemana = {
    SEGUNDA: 0,
    TERCA: 1,
    QUARTA: 2,
    QUINTA: 3,
    SEXTA: 4,
    SABADO: 5,
    DOMINGO: 6
};

let hoje = DiaDaSemana.TERCA;

// Exibindo valor ordinal
console.log("Hoje é: TERCA");

// Usando a posição ordinal
console.log("Posição ordinal: " + hoje);

if (hoje === DiaDaSemana.TERCA) {
    console.log("Hoje é terça-feira.");
}
