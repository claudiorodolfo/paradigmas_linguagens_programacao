remover_duplicatas([], []).  % Caso base
remover_duplicatas([Cabeça | Cauda], [Cabeça | Resultado]) :-
    \+ membro(Cabeça, Cauda),  % Verifica se Cabeça não está na Cauda
    remover_duplicatas(Cauda, Resultado).
remover_duplicatas([Cabeça | Cauda], Resultado) :-
    membro(Cabeça, Cauda),  % Caso recursivo: se Cabeça está em Cauda
    remover_duplicatas(Cauda, Resultado).
