concatenar([], Lista, Lista).
concatenar([Cabeça | Cauda], Lista, [Cabeça | Resultado]) :-
    concatenar(Cauda, Lista, Resultado).
