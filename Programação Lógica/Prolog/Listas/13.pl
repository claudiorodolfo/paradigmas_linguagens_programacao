pertence(X, [X | _]).  % Caso base: elemento é a cabeça
pertence(X, [_ | Cauda]) :- 
    pertence(X, Cauda).  % Caso recursivo
nao_pertence(_, []).  % Caso base: elemento não está em uma lista vazia
nao_pertence(X, [Y | Cauda]) :-
    X \= Y,  % X é diferente de Y
    nao_pertence(X, Cauda).
remover_duplicatas([], []).  % Caso base
remover_duplicatas([Cabeca | Cauda], [Cabeca | Resultado]) :-
    nao_pertence(Cabeca, Cauda),  % Verifica se Cabeça não está na Cauda
    remover_duplicatas(Cauda, Resultado).
remover_duplicatas([Cabeca | Cauda], Resultado) :-
    pertence(Cabeca, Cauda),  % Caso recursivo: se Cabeça está em Cauda
    remover_duplicatas(Cauda, Resultado).
