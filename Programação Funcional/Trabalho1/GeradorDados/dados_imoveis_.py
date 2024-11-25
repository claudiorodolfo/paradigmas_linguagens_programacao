import pandas as pd
import random

tam = 1000
# 1. Previsão de Preços Imobiliários(ID, Cidade, Bairro, Área (m²), Número de quartos, Número de banheiros, Preço, Ano de construção, Distância do centro)
imoveis = {
    "ID": list(range(1, tam+1)),
    "Cidade": random.choices(["São Paulo", "Rio de Janeiro", "Curitiba", "Porto Alegre", "Belo Horizonte"], k=tam),
    "Bairro": random.choices(["Centro", "Zona Sul", "Zona Norte", "Zona Leste", "Zona Oeste"], k=tam),
    "Área (m²)": [random.randint(50, 300) for _ in range(tam)],
    "Número de quartos": [random.randint(1, 5) for _ in range(tam)],
    "Número de banheiros": [random.randint(1, 3) for _ in range(tam)],
    "Preço": [random.randint(150000, 1200000) for _ in range(tam)],
    "Ano de construção": [random.randint(1950, 2023) for _ in range(tam)],
    "Distância do centro": [round(random.uniform(0.5, 30), 2) for _ in range(tam)]
}
# Converte os dados em DataFrame
df_imoveis = pd.DataFrame(imoveis)
#df_pacientes.to_csv(index=False)
print(df_imoveis)