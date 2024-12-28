% Predicado para verificar se um número é par
par(X) :- X mod 2 =:= 0.

pares([], []).
pares([Cabeca | Cauda], [Cabeca | Resultado]) :-
    par(Cabeca),  % Chama o predicado auxiliar 
    pares(Cauda, Resultado).
    
pares([_|Cauda], Resultado) :-
    pares(Cauda, Resultado).
