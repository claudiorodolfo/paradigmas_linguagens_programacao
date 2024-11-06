import pandas as pd
import random
import datetime

# Função para gerar uma data aleatória
def random_date(start, end):
    return start + (end - start) * random.random()

# Listas de primeiros nomes e sobrenomes para combinação
primeiros_nomes = ["Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Juliana", "Kaik", "Lucas", "Mariana", "Nilma", "Osvaldo"]
sobrenomes = ["Silva", "Santos", "Pereira", "Oliveira", "Costa", "Almeida", "Barbosa", "Souza", "Ferreira", "Gomes", "Maciel", "Sousa", "Silveira", "Aparecido", "Brito"]

tam = 1000
# Análise de Dados de Assistência Médica (ID Atendimento, Paciente, Gênero, Idade, Diagnóstico, Tratamento, Custo do tratamento, Médico responsável, Duração do tratamento, Data de início)
pacientes = {
    "ID Atendimento": list(range(1, tam+1)),
    "Paciente": [f"{random.choice(primeiros_nomes)} {random.choice(sobrenomes)}" for _ in range(tam)],
    "Gênero": random.choices(["Masculino", "Feminino"], k=tam),
    "Idade": [random.randint(1, 100) for _ in range(tam)],
    "Diagnóstico": random.choices(
        ["Diabetes", "Hipertensão", "Asma", "Depressão", "Fratura", "Infecção"], k=tam
    ),
    "Tratamento": random.choices(
        ["Medicação", "Cirurgia", "Terapia", "Fisioterapia", "Observação"], k=tam
    ),
    "Custo do tratamento": [round(random.uniform(500, 20000), 2) for _ in range(tam)],
    "Médico responsável": [f"Dr. {random.choice(sobrenomes)}" for _ in range(tam)],
    "Duração do tratamento (dias)": [random.randint(1, 180) for _ in range(tam)],
    "Data de início": [random_date(datetime.datetime(2020, 1, 1), datetime.datetime(2024, 1, 1)).strftime("%Y-%m-%d") for _ in range(tam)]
}

# Converte os dados em DataFrame
df_pacientes = pd.DataFrame(pacientes)
#df_pacientes.to_csv(index=False)
print(df_pacientes)