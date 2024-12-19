duplicar([], []).  % Caso base
duplicar([Cabeca | Cauda], [Cabeca, Cabeca | Resultado]) :-
    duplicar(Cauda, Resultado).  % Recursão
