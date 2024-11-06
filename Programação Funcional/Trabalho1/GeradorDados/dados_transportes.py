import pandas as pd
import random
import datetime

# Função para gerar uma data aleatória
def random_date(start, end):
    return start + (end - start) * random.random()

tam = 1000
# Análise de Dados de Transporte Público (ID da viagem, Data, Hora, Linha de ônibus, Número de passageiros, Tipo de veículo, Localização de partida, Localização de chegada, Tempo de viagem, Custo da viagem)
trafego = {
    "ID": list(range(1, tam+1)),
    "Data": [random_date(start_date, end_date).strftime("%Y-%m-%d") for _ in range(tam)],
    "Hora": [f"{random.randint(0, 23):02d}:{random.randint(0, 59):02d}" for _ in range(tam)],
    "Localização": random.choices(["Centro", "Zona Sul", "Zona Norte", "Zona Leste", "Zona Oeste"], k=tam),
    "Número de veículos": [random.randint(10, 500) for _ in range(tam)],
    "Tipo de veículo": random.choices(["Carro", "Moto", "Ônibus", "Caminhão"], k=tam),
    "Velocidade média (km/h)": [round(random.uniform(20, 80), 1) for _ in range(tam)],
    "Tempo de espera (min)": [random.randint(0, 30) for _ in range(tam)]
}
df_trafego = pd.DataFrame(trafego)
#df_trafego.to_csv("trafego_1000.csv", index=False)
print(df_trafego)