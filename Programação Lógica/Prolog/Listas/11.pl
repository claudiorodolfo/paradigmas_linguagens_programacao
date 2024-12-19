soma_lista([], 0).  % Caso base: a soma de uma lista vazia é 0
soma_lista([Cabeça | Cauda], Soma) :- 
    soma_lista(Cauda, SomaCauda), 
    Soma is Cabeça + SomaCauda.
