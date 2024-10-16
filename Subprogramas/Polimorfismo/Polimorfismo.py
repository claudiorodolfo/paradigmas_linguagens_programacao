#Python
# Não suporta sobrecarga de subprogramas diretamente (o último método definido sobrescreve o anterior).
# Uma forma de simular subprogramas polimorficos é um único subprograma que filtra o dado.

class Polimorfismo:
    def imprimir(self, value):
        if isinstance(value, str):
            print(value)
        elif isinstance(value, int):
            print(value)

p = Polimorfismo()
p.imprimir("Hello")  # imprime a string
p.imprimir(10)       # imprime o inteiro
