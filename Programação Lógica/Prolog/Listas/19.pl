dividir_meio(Lista, PrimeiraMetade, SegundaMetade) :-
    length(Lista, Comprimento),         % Obtém o comprimento da lista
    Meio is Comprimento // 2,           % Calcula o ponto de divisão (metade inteira)
    dividir(Lista, Meio, PrimeiraMetade, SegundaMetade).
% Caso base: nenhuma divisão restante
dividir(Lista, 0, [], Lista).
% Divide a lista recursivamente
dividir([Cabeca | Cauda], N, [Cabeca | Primeira], Segunda) :-
    N > 0, N1 is N - 1, dividir(Cauda, N1, Primeira, Segunda).
