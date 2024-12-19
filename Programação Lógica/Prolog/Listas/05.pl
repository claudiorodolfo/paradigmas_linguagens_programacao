ultimo([X], X).  % Caso base: o último elemento é o único
ultimo([_|Cauda], X) :- ultimo(Cauda, X).
