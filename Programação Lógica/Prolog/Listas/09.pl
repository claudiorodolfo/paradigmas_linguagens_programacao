eliminar(_, [], []).  % Caso base: lista vazia
eliminar(X, [X | Cauda], Cauda).  % Remove o elemento se for a cabeça
eliminar(X, [Cabeça | Cauda], [Cabeça | Resultado]) :- 
    eliminar(X, Cauda, Resultado).  % Caso recursivo
