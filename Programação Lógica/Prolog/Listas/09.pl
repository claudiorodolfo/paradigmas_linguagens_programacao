eliminar(_, [], []).  % Caso base: lista vazia
eliminar(X, [X | Cauda], Cauda).  % Remove o elemento se for a cabeça
eliminar(X, [Cabeca | Cauda], [Cabeca | Resultado]) :- 
    eliminar(X, Cauda, Resultado).  % Caso recursivo
