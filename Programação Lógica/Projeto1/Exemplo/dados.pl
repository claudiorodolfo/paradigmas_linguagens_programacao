% Fatos
cidade(sao_paulo, brasil, 12.33).
cidade(rio_de_janeiro, brasil, 6.78).
cidade(tokyo, japao, 37.4).
cidade(paris, franca, 2.14).

% Regra que identifica cidades com população maior que 10 milhões.
populacao_alta(Cidade) :- cidade(Cidade, _, Populacao), Populacao > 10.
