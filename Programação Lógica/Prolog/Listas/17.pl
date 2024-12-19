pares([], []).
pares([Cabeça | Cauda], [Cabeça | Resultado]) :-
    0 is Cabeça mod 2, 
    pares(Cauda, Resultado).
pares([_|Cauda], Resultado) :-
    pares(Cauda, Resultado).
