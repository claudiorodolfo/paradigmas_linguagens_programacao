pares([], []).

pares([Cabeca | Cauda], [Cabeca | Resultado]) :-
    0 is Cabeca mod 2, 
    pares(Cauda, Resultado).
    
pares([_|Cauda], Resultado) :-
    pares(Cauda, Resultado).