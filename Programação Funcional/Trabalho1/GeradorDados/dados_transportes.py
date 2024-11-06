import pandas as pd
import random
import datetime

# Função para gerar uma data aleatória
def random_date(start, end):
    return start + (end - start) * random.random()

tam = 1000
start_date = datetime.datetime(2023, 1, 1)
end_date = datetime.datetime(2023, 12, 31)
# Análise de Dados de Transporte Público (ID da viagem, Data, Hora, Linha de ônibus, Número de passageiros, Tipo de veículo, Localização de partida, Localização de chegada, Tempo de viagem, Custo da viagem)
trafego = {
    "ID da viagem": list(range(1, tam+1)),
    "Data": [random_date(start_date, end_date).strftime("%Y-%m-%d") for _ in range(tam)],
    "Hora": [f"{random.randint(0, 23):02d}:{random.randint(0, 59):02d}" for _ in range(tam)],
	"Linha de ônibus": ["Linha " + str(random.choice([101, 202, 303, 404, 505])) for _ in range(tam)],
	"Número de passageiros": [random.randint(5, 150) for _ in range(tam)],
    "Tipo de veículo": random.choices(["Articulado", "Elétrico", "Micro-ônibus", "Ônibus convencional"], k=tam),
	"Localização de partida": random.choices(["Centro", "Zona Sul", "Zona Norte", "Zona Leste", "Zona Oeste"], k=tam),	
	"Localização de chegada": random.choices(["Centro", "Zona Sul", "Zona Norte", "Zona Leste", "Zona Oeste"], k=tam),
    "Tempo de viagem": [random.randint(10, 90) for _ in range(tam)],		
    "Custo da viagem": [round(random.uniform(3.5, 7.5), 2) for _ in range(tam)]
}
# Converte os dados em DataFrame
df_trafego = pd.DataFrame(trafego)
#df_trafego.to_csv("trafego_1000.csv", index=False)
print(df_trafego)