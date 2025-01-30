soma_n(_, 0, 0).  % Caso base
soma_n([Cabeca | Cauda], N, Soma) :-
    N > 0, 
    N1 is N - 1,
    soma_n(Cauda, N1, SomaCauda),
    Soma is Cabeca + SomaCauda.
