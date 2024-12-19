duplicar([], []).  % Caso base
duplicar([Cabeça | Cauda], [Cabeça, Cabeça | Resultado]) :-
    duplicar(Cauda, Resultado).  % Recursão
