dividir_meio(Lista, PrimeiraMetade, SegundaMetade) :-
    length(Lista, Tamanho),
    Meio is Tamanho // 2,
    length(PrimeiraMetade, Meio),
    append(PrimeiraMetade, SegundaMetade, Lista).
