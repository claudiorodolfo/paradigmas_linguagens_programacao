% Fatos sobre animais
animal(urso, [habitat(floresta), comportamento(solitario), dieta(onivoro)]).
animal(gato, [habitat(urbano), comportamento(independente), dieta(carnivoro)]).
animal(peixe, [habitat(aquatico), comportamento(cardume), dieta(herbivoro)]).
animal(aguia, [habitat(montanha), comportamento(solitario), dieta(carnivoro)]).
animal(elefante, [habitat(savana), comportamento(social), dieta(herbivoro)]).
animal(leao, [habitat(savana), comportamento(social), dieta(carnivoro)]).
animal(lobo, [habitat(floresta), comportamento(em_bando), dieta(carnivoro)]).
animal(cavalo, [habitat(campo), comportamento(social), dieta(herbivoro)]).
animal(cobra, [habitat(floresta), comportamento(solitario), dieta(carnivoro)]).
animal(coelho, [habitat(campo), comportamento(em_grupo), dieta(herbivoro)]).
animal(pinguim, [habitat(polo_sul), comportamento(em_colonia), dieta(carnivoro)]).
animal(canguru, [habitat(australia), comportamento(em_grupo), dieta(herbivoro)]).
animal(falacao, [habitat(amazonia), comportamento(social), dieta(frugivoro)]).
animal(golfinho, [habitat(oceano), comportamento(social), dieta(carnivoro)]).
animal(tigre, [habitat(floresta), comportamento(solitaria), dieta(carnivoro)]).
animal(urso_polar, [habitat(polo_norte), comportamento(solitario), dieta(carnivoro)]).
animal(flamingo, [habitat(pantanal), comportamento(em_grupo), dieta(herbivoro)]).
animal(jacaré, [habitat(pantanal), comportamento(solitario), dieta(carnivoro)]).
animal(arara, [habitat(amazonia), comportamento(social), dieta(frugivoro)]).
animal(coruja, [habitat(floresta), comportamento(solitario), dieta(carnivoro)]).
animal(cervo, [habitat(floresta), comportamento(em_grupo), dieta(herbivoro)]).
animal(tubarao, [habitat(oceano), comportamento(solitario), dieta(carnivoro)]).
animal(ornitorrinco, [habitat(australia), comportamento(solitario), dieta(onivoro)]).
animal(antilope, [habitat(savana), comportamento(em_bando), dieta(herbivoro)]).
animal(camelo, [habitat(deserto), comportamento(em_grupo), dieta(herbivoro)]).
animal(zebra, [habitat(savana), comportamento(em_grupo), dieta(herbivoro)]).
animal(panda, [habitat(bambu), comportamento(solitario), dieta(herbivoro)]).
animal(raposa, [habitat(campo), comportamento(solitario), dieta(onivoro)]).
animal(guaxinim, [habitat(urbano), comportamento(noturno), dieta(onivoro)]).
animal(tatu, [habitat(cerrado), comportamento(noturno), dieta(insetivoro)]).


% Regras para identificar o animal com base em uma lista de características fornecida
identificar_animal(Respostas, AnimaisComProbabilidades) :-

% Calcular a probabilidade de correspondência das características
calcular_probabilidade(Respostas, Caracteristicas, Probabilidade) :-
