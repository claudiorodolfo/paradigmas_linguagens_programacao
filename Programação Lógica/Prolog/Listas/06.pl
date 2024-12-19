concatenar([], Lista, Lista).
concatenar([Cabeca | Cauda], Lista, [Cabeca | Resultado]) :-
    concatenar(Cauda, Lista, Resultado).