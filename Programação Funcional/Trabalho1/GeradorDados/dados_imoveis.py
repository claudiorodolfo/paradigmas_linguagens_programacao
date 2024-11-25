import pandas as pd 
import random

tam = 1000

# Função para calcular o preço com base em várias variáveis
def calcular_preco(cidade, bairro, area, quartos, banheiros, ano_construcao, distancia_centro):
    # Definir a base do preço com base na cidade
    cidade_preco = {
        "São Paulo": 1500000,
        "Rio de Janeiro": 1200000,
        "Curitiba": 800000,
        "Porto Alegre": 700000,
        "Belo Horizonte": 600000
    }
    
    preco_base = cidade_preco.get(cidade, 600000)
    
    # Ajuste baseado na área (quanto maior, mais caro)
    preco_base += area * 100
    
    # Ajuste baseado no número de quartos e banheiros (quanto mais quartos e banheiros, mais caro)
    preco_base += quartos * 50000
    preco_base += banheiros * 30000
    
    # Imóveis mais distantes do centro tendem a ser mais baratos
    preco_base -= distancia_centro * 10000
    
    # Imóveis mais antigos tendem a ser maiores
    if ano_construcao < 2000:
        preco_base += area * 50
    
    # Preço final ajustado
    return round(preco_base, 2)

# Gerar os dados de imóveis
imoveis = {
    "ID": list(range(1, tam+1)),
    "Cidade": random.choices(["São Paulo", "Rio de Janeiro", "Curitiba", "Porto Alegre", "Belo Horizonte"], k=tam),
    "Bairro": random.choices(["Centro", "Zona Sul", "Zona Norte", "Zona Leste", "Zona Oeste"], k=tam),
    "Área (m²)": [random.randint(50, 300) for _ in range(tam)],
    "Número de quartos": [random.randint(1, 5) for _ in range(tam)],
    "Número de banheiros": [random.randint(1, 3) for _ in range(tam)],
    "Ano de construção": [random.randint(1950, 2023) for _ in range(tam)],
    "Distância do centro": [round(random.uniform(0.5, 30), 2) for _ in range(tam)]
}

# Ajustar a quantidade de banheiros para sempre ser menor ou igual ao número de quartos
for i in range(tam):
    imoveis["Número de banheiros"][i] = min(imoveis["Número de banheiros"][i], imoveis["Número de quartos"][i])

# Calcular os preços baseados nas regras
imoveis["Preço"] = [
    calcular_preco(imoveis["Cidade"][i], imoveis["Bairro"][i], imoveis["Área (m²)"][i], 
                   imoveis["Número de quartos"][i], imoveis["Número de banheiros"][i], 
                   imoveis["Ano de construção"][i], imoveis["Distância do centro"][i])
    for i in range(tam)
]

# Converte os dados em DataFrame
df_imoveis = pd.DataFrame(imoveis)
#df_imoveis.to_csv(index=False)
print(df_imoveis)
