reverter([], []).  % Caso base
reverter([Cabeça | Cauda], Resultado) :- 
    reverter(Cauda, CaudaRevertida),
    concatenar(CaudaRevertida, [Cabeça], Resultado).
