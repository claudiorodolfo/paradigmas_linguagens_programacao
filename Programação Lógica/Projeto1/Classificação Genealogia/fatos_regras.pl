% Fatos básicos
pai(jose, maria).
pai(jose, joao).
pai(carlos, pedro).
pai(antonio, luiza).
pai(antonio, claudio).
pai(fernando, julia).
pai(fernando, roberto).
pai(marcos, ana).
pai(marcos, lucas).
pai(pedro, fernanda).
pai(pedro, thiago).
pai(joao, sofia).
pai(joao, felipe).
pai(ricardo, aline).
pai(ricardo, gabriel).

mae(ana, maria).
mae(ana, joao).
mae(helena, pedro).
mae(claudia, luiza).
mae(claudia, claudio).
mae(lucia, julia).
mae(lucia, roberto).
mae(renata, ana).
mae(renata, lucas).
mae(mariana, fernanda).
mae(mariana, thiago).
mae(sofia, sofia).
mae(sofia, felipe).
mae(elaine, aline).
mae(elaine, gabriel).

% Definindo o sexo das pessoas
sexo(jose, masculino).
sexo(joao, masculino).
sexo(carlos, masculino).
sexo(antonio, masculino).
sexo(fernando, masculino).
sexo(marcos, masculino).
sexo(pedro, masculino).
sexo(ricardo, masculino).
sexo(thiago, masculino).
sexo(claudio, masculino).
sexo(felipe, masculino).
sexo(gabriel, masculino).
sexo(maria, feminino).
sexo(ana, feminino).
sexo(helena, feminino).
sexo(claudia, feminino).
sexo(lucia, feminino).
sexo(renata, feminino).
sexo(mariana, feminino).
sexo(sofia, feminino).
sexo(elaine, feminino).
sexo(julia, feminino).
sexo(fernanda, feminino).
sexo(luiza, feminino).
sexo(aline, feminino).

% Regras para inferir parentescos
irmao(X, Y) :- 
irma(X, Y) :- 
avo_paterno(X, Y) :-
avo_materno(X, Y) :-
neto(X, Y) :-
tio(X, Y) :- 
tia(X, Y) :-
sobrinho(X, Y) :- 
sobrinha(X, Y) :-
parente(X, Y) :- 
