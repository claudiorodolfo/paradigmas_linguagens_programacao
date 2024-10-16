# Python
def print_numbers(*numbers, **outros):
    for number in numbers:
        print(number)
    
    print()  
	
	# Acessa a chave e o valor do dicionário 'outros'
    for chave, valor in outros.items():  
        print(f"{chave}: {valor}")

# Chama a função com parâmetros variáveis
print_numbers(1, 2, 3, 4, 5, vermelho=10, verde=20, azul=30) 