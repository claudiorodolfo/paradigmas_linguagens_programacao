pertence(X, [X | _]).  % Caso base: elemento é a cabeça
pertence(X, [_ | Cauda]) :- 
    pertence(X, Cauda).  % Caso recursivo
