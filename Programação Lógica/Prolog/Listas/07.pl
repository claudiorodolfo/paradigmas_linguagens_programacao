reverter([], []).  % Caso base
reverter([Cabeca | Cauda], Resultado) :- 
    reverter(Cauda, CaudaRevertida),
    concatenar(CaudaRevertida, [Cabeca], Resultado).
