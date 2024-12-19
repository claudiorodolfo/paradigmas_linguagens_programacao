produto_lista([], 1).  % Caso base: o produto de uma lista vazia é 1
produto_lista([Cabeça | Cauda], Produto) :- 
    produto_lista(Cauda, ProdutoCauda), 
    Produto is Cabeça * ProdutoCauda.
