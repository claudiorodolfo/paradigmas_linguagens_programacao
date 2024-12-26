% Fatos sobre meios de transporte
transporte(paris, aviao, 1200, 10).
transporte(paris, trem, 500, 24).
transporte(paris, carro, 300, 20).
transporte(tokio, aviao, 1500, 15).
transporte(tokio, navio, 900, 120).
transporte(tokio, trem, 700, 30).
transporte(rio_de_janeiro, onibus, 300, 12).
transporte(rio_de_janeiro, aviao, 800, 2).
transporte(rio_de_janeiro, carro, 100, 15).
transporte(londres, aviao, 1000, 8).
transporte(londres, trem, 700, 10).
transporte(londres, carro, 500, 12).
transporte(nova_iorque, aviao, 1200, 9).
transporte(nova_iorque, onibus, 200, 18).
transporte(nova_iorque, trem, 400, 12).
transporte(sydney, aviao, 1800, 18).
transporte(sydney, navio, 1500, 240).
transporte(sydney, trem, 900, 48).
transporte(dubai, aviao, 1000, 7).
transporte(dubai, carro, 600, 14).
transporte(dubai, trem, 800, 20).
transporte(roma, aviao, 900, 6).
transporte(roma, trem, 500, 12).
transporte(roma, carro, 400, 8).
transporte(cidade_do_cabo, aviao, 1400, 11).
transporte(cidade_do_cabo, navio, 1200, 240).
transporte(cidade_do_cabo, carro, 700, 30).
transporte(beijing, aviao, 1600, 14).
transporte(beijing, trem, 800, 20).
transporte(beijing, navio, 1300, 200).

% Regras para planejamento de viagem
viagem_viavel(Destino, Orcamento, TempoMax, Transporte, Custo, Tempo) :-

% Prioridade por ser custo ou tempo
melhor_viagem(Destino, Orcamento, TempoMax, Prioridade, Transporte, Custo, Tempo) :-

ordena_por_prioridade(Opcoes, custo, Ordenadas) :-