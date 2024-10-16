# Python

from typing import TypeVar

T = TypeVar('T')

def maior_valor(a: T, b: T) -> T:
    return a if a > b else b

print(f'Maior entre 10 e 20: {maior_valor(10, 20)}')
print(f'Maior entre 3.14 e 2.71: {maior_valor(3.14, 2.71)}')
