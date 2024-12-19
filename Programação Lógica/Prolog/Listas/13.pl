remover_duplicatas([], []).  % Caso base
remover_duplicatas([Cabeca | Cauda], [Cabeca | Resultado]) :-
    \+ membro(Cabeca, Cauda),  % Verifica se Cabeça não está na Cauda
    remover_duplicatas(Cauda, Resultado).
remover_duplicatas([Cabeca | Cauda], Resultado) :-
    membro(Cabeca, Cauda),  % Caso recursivo: se Cabeça está em Cauda
    remover_duplicatas(Cauda, Resultado).
