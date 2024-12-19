ordenada([]).  % Lista vazia é considerada ordenada
ordenada([_]).  % Lista com um elemento é considerada ordenada
ordenada([X, Y | Cauda]) :-
    X =< Y,  % Verifica se X é menor ou igual a Y
    ordenada([Y | Cauda]).
