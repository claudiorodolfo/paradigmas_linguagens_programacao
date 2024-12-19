% Predicado para verificar se um número é par
par(X) :- X mod 2 =:= 0.

% Predicado para verificar se um número é maior que 5
maior_que_5(X) :- X > 5.

filtrar([], _, []).
filtrar([Cabeca | Cauda], Predicado, [Cabeca | Resultado]) :-
    call(Predicado, Cabeca),
    filtrar(Cauda, Predicado, Resultado).
filtrar([_ | Cauda], Predicado, Resultado) :-
    filtrar(Cauda, Predicado, Resultado).
