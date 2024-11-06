import pandas as pd
import random
import datetime

# Função para gerar uma data aleatória
def random_date(start, end):
    return start + (end - start) * random.random()
	
tam = 1000
start_date = datetime.datetime(2023, 1, 1)
end_date = datetime.datetime(2023, 12, 31)
# Histórico de Temperatura e Precipitação (ID,Data, Cidade, Temperatura Máxima (°C), Temperatura Mínima (°C), Precipitação (mm), Umidade (%), Velocidade do vento (km/h))
temperatura = {
    "ID": list(range(1, tam+1)),
    "Data": [random_date(start_date, end_date).strftime("%Y-%m-%d") for _ in range(tam)],
    "Cidade": random.choices(["São Paulo", "Rio de Janeiro", "Curitiba", "Porto Alegre", "Belo Horizonte"], k=tam),
    "Temperatura Máxima (°C)": [round(random.uniform(25, 40), 1) for _ in range(tam)],
    "Temperatura Mínima (°C)": [round(random.uniform(10, 25), 1) for _ in range(tam)],
    "Precipitação (mm)": [round(random.uniform(0, 150), 2) for _ in range(tam)],
    "Umidade (%)": [random.randint(40, 100) for _ in range(tam)],
    "Velocidade do vento (km/h)": [round(random.uniform(0.5, 15.0), 1) for _ in range(tam)]
}
# Converte os dados em DataFrame
df_temperatura = pd.DataFrame(temperatura)
#df_temperatura.to_csv(index=False)
print(df_temperatura)