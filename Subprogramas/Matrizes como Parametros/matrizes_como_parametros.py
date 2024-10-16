#Python
#Parametro Real: m
#Parametro Formal: matriz
#Passagem de Parâmetro do tipo Matriz é, por padrão, por Referência

# Função para imprimir a matriz
def imprimir_matriz(matriz):
    for linha in matriz:
        print(" ".join(map(str, linha)))

# Função para dobrar os elementos da matriz
def dobrar_matriz(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            matriz[i][j] *= 2

m = [[1, 2, 3, 4], [5, 6, 7, 8]]

print("Antes de dobrar:")
imprimir_matriz(m)

dobrar_matriz(m)

print("Depois de dobrar:")
imprimir_matriz(m)
