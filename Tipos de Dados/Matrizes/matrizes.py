# Python
# Tem suporte a slicing (fatias)

# Definição e inicialização
matriz = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]

# Exibir os elementos da matriz
for linha in matriz:
    for elemento in linha:
        print(elemento, end=" ")
    print()

# 1) Fatiar a segunda e terceira linhas
fatia_linhas = matriz[1:3]
# 2) Fatiar a primeira e segunda colunas
fatia_colunas = [linha[:2] for linha in matriz]

# Imprimir os resultados
print("Fatia da segunda e terceira linhas:")
for linha in fatia_linhas:
    print(linha)
print("Fatia da primeira e segunda colunas:")
for linha in fatia_colunas:
    print(linha)
