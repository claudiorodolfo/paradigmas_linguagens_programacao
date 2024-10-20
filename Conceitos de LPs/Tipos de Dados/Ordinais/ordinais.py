#Python
#Em Python, podemos usar o módulo Enum para criar enumerações, mas não há suporte nativo para subfaixas.
from enum import Enum

class DiaDaSemana(Enum):
    Segunda = 1
    Terca = 2
    Quarta = 3
    Quinta = 4
    Sexta = 5
    Sabado = 6
    Domingo = 7

hoje = DiaDaSemana.Terca

# Exibindo valor ordinal
print(f"Hoje é: {hoje.name}")

# Usando a posição ordinal
print(f"Posição ordinal: {hoje.value}")

if hoje == DiaDaSemana.Terca:
    print("Hoje é terça-feira.")
