filtrar([], _, []).
filtrar([Cabeça | Cauda], Predicado, [Cabeca | Resultado]) :-
    call(Predicado, Cabeca),
    filtrar(Cauda, Predicado, Resultado).
filtrar([_|Cauda], Predicado, Resultado) :-
    filtrar(Cauda, Predicado, Resultado).
