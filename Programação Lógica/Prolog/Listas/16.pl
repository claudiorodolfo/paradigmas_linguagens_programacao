filtrar([], _, []).
filtrar([Cabeça | Cauda], Predicado, [Cabeça | Resultado]) :-
    call(Predicado, Cabeça),
    filtrar(Cauda, Predicado, Resultado).
filtrar([_|Cauda], Predicado, Resultado) :-
    filtrar(Cauda, Predicado, Resultado).
