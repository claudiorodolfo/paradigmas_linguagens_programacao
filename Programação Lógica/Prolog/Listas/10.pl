produto_lista([], 1).  % Caso base: o produto de uma lista vazia é 1
produto_lista([Cabeca | Cauda], Produto) :- 
    produto_lista(Cauda, ProdutoCauda), 
    Produto is Cabeca * ProdutoCauda.
