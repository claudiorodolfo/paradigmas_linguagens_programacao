# Python
def funcao_externa():
    print("Esta é a função externa.")

    def funcao_interna():
        print("Esta é a função interna.")

    funcao_interna()  # Chama a função interna

funcao_externa()  # Chama a função externa
