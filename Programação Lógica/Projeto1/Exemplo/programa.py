from pyswip import Prolog

def consultar_cidades_populosas():
    # Inicializa o Prolog
    prolog = Prolog()

    # Carrega o arquivo de fatos e regras
    prolog.consult("dados.pl")

    # Consulta as cidades com população alta
    query = "populacao_alta(Cidade)"
    resultados = list(prolog.query(query))

    # Exibe os resultados
    print("Cidades com população maior que 10 milhões:")
    for resultado in resultados:
        print(f"- {resultado['Cidade']}")

if __name__ == "__main__":
    consultar_cidades_populosas()
