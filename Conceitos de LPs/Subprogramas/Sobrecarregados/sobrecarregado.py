#Python
# Não suporta sobrecarga de subprogramas diretamente (o último método definido sobrescreve o anterior).
# Uma forma de simular subprogramas sobrecarregados é um único subprograma que filtra o dado.

def imprimir(value):
    if isinstance(value, str):
        print(value)
    elif isinstance(value, int):
        print(value)


imprimir("Hello")  # imprime a string
imprimir(10)       # imprime o inteiro
