tamanho([], 0).  % Caso base
tamanho([_|Cauda], Tamanho) :- 
    tamanho(Cauda, TamanhoCauda),
    Tamanho is TamanhoCauda + 1.