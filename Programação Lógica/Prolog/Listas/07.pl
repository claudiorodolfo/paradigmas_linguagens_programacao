concatenar([], Lista, Lista).
concatenar([Cabeca | Cauda], Lista, [Cabeca | Resultado]) :-
    concatenar(Cauda, Lista, Resultado).
    
reverter([], []).  % Caso base
reverter([Cabeca | Cauda], Resultado) :- 
    reverter(Cauda, CaudaRevertida),
    concatenar(CaudaRevertida, [Cabeca], Resultado).