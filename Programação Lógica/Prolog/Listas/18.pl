produto_escalar([], [], 0).  % Caso base
produto_escalar([X | Xs], [Y | Ys], Produto) :-
    produto_escalar(Xs, Ys, ProdutoRestante),
    Produto is X * Y + ProdutoRestante.
