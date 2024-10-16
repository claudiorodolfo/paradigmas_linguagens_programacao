#Python
#Suporte Nativo

# Definição e inicialização
matriz = {
    "um": 1,
    "dois": 2,
    "tres": 3
}

# Acessar elementos
print("Valor para 'dois':", matriz["dois"])

# Remover um elemento
del matriz["tres"]

# Iterar pela matriz
for chave, valor in matriz.items():
    print(f"{chave}: {valor}")
