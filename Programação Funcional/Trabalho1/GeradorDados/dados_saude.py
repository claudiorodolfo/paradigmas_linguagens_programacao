import pandas as pd
import random
import datetime

# Função para gerar uma data aleatória
def random_date(start, end):
    return start + (end - start) * random.random()

tam = 1000
# Dados de Saúde e Atividade Física (ID, Idade, Gênero, Altura, Peso, Horas de sono, Calorias consumidas, Passos por dia, Atividade física (min), Pressão arterial)
saude = {
    "ID": list(range(1, tam+1)),
    "Idade": [random.randint(18, 70) for _ in range(tam)],
    "Gênero": random.choices(["Masculino", "Feminino"], k=tam),
    "Altura": [round(random.uniform(1.50, 2.00), 2) for _ in range(tam)],
    "Peso": [round(random.uniform(50, 120), 2) for _ in range(tam)],
    "Horas de sono": [round(random.uniform(4, 10), 1) for _ in range(tam)],
    "Calorias consumidas": [random.randint(1500, 3500) for _ in range(tam)],
    "Passos por dia": [random.randint(tam, 15000) for _ in range(tam)],
    "Atividade física (min)": [random.randint(0, 180) for _ in range(tam)],
    "Pressão arterial": [f"{random.randint(90, 140)}/{random.randint(60, 90)}" for _ in range(tam)]
}

# Converte os dados em DataFrame
df_saude = pd.DataFrame(saude)
#df_saude.to_csv(index=False)
print(df_saude)