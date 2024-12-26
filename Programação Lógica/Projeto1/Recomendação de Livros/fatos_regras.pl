% Fatos: Livros e suas características
livro("Dom Casmurro", [genero(romance), genero(classico), autor("Machado de Assis"), ano(1899)]).
livro("O Morro dos Ventos Uivantes", [genero(romance), genero(drama), autor("Emily Brontë"), ano(1847)]).
livro("1984", [genero(ficcao), genero(distopia), autor("George Orwell"), ano(1949)]).
livro("Orgulho e Preconceito", [genero(romance), genero(classico), autor("Jane Austen"), ano(1813)]).
livro("O Senhor dos Aneis", [genero(fantasia), genero(aventura), autor("J.R.R. Tolkien"), ano(1954)]).
livro("Moby Dick", [genero(aventura), genero(classico), autor("Herman Melville"), ano(1851)]).
livro("A Revolução dos Bichos", [genero(ficcao), genero(satira), autor("George Orwell"), ano(1945)]).
livro("Cem Anos de Solidão", [genero(ficcao), genero(realismo_magico), autor("Gabriel Garcia Márquez"), ano(1967)]).
livro("O Pequeno Príncipe", [genero(ficcao), genero(infantil), autor("Antoine de Saint-Exupéry"), ano(1943)]).
livro("A Metamorfose", [genero(ficcao), genero(drama), autor("Franz Kafka"), ano(1915)]).
livro("Crime e Castigo", [genero(drama), genero(classico), autor("Fyodor Dostoevsky"), ano(1866)]).
livro("Hamlet", [genero(drama), genero(tragedia), autor("William Shakespeare"), ano(1603)]).
livro("Iliada", [genero(epico), genero(classico), autor("Homero"), ano(-750)]).
livro("Odisseia", [genero(epico), genero(aventura), autor("Homero"), ano(-700)]).
livro("Dracula", [genero(horror), genero(classico), autor("Bram Stoker"), ano(1897)]).
livro("Frankenstein", [genero(horror), genero(ficcao), autor("Mary Shelley"), ano(1818)]).
livro("A Divina Comedia", [genero(epico), genero(poema), autor("Dante Alighieri"), ano(1320)]).
livro("Os Miseráveis", [genero(drama), genero(classico), autor("Victor Hugo"), ano(1862)]).
livro("O Grande Gatsby", [genero(drama), genero(classico), autor("F. Scott Fitzgerald"), ano(1925)]).
livro("Admiravel Mundo Novo", [genero(ficcao), genero(distopia), autor("Aldous Huxley"), ano(1932)]).
livro("A Montanha Magica", [genero(ficcao), genero(classico), autor("Thomas Mann"), ano(1924)]).
livro("O Sol e para Todos", [genero(drama), genero(classico), autor("Harper Lee"), ano(1960)]).
livro("Jane Eyre", [genero(romance), genero(drama), autor("Charlotte Brontë"), ano(1847)]).
livro("Alice no Pais das Maravilhas", [genero(fantasia), genero(infantil), autor("Lewis Carroll"), ano(1865)]).
livro("Memórias Postumas de Bras Cubas", [genero(romance), genero(classico), autor("Machado de Assis"), ano(1881)]).
livro("O Codigo Da Vinci", [genero(suspense), genero(misterio), autor("Dan Brown"), ano(2003)]).
livro("Harry Potter e a Pedra Filosofal", [genero(fantasia), genero(infantil), autor("J.K. Rowling"), ano(1997)]).
livro("O Alquimista", [genero(ficcao), genero(inspiracional), autor("Paulo Coelho"), ano(1988)]).
livro("Percy Jackson e o Ladrao de Raios", [genero(fantasia), genero(aventura), autor("Rick Riordan"), ano(2005)]).
livro("Jogos Vorazes", [genero(ficcao), genero(distopia), autor("Suzanne Collins"), ano(2008)]).

% Regra para calcular a correspondência com base nas preferências fornecidas
calcular_probabilidade(Preferencias, CaracteristicasLivro, Probabilidade) :-

% Regra principal: encontrar recomendações com base nas preferências
recomendacao(Preferencias, Livro, Probabilidade) :-

% Consultas auxiliares para verificar as características de um livro
genero(Livro, Genero) :-
autor(Livro, Autor) :-
ano(Livro, Ano) :-
