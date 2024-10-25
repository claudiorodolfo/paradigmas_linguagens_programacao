# Gabaritos para diferentes tipos de prova
gabaritos = {
    1: "AEACEDDEEBCABBDDECADBCAB",
    2: "BAEDECBECEBDDBDCCDAABAAE",
    3: "ECCEDCBBEAEACEABBAABDDDD",
    4: "ADEBEDCCADAEABECADBBBCED"
}

# Mapeamento das questões entre os diferentes tipos de prova
posicao = [
    [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24],  #tipo1
    [22,3,2,9,8,13,4,10,5,7,16,19,11,21,15,12,24,17,23,18,1,6,20,14],  #tipo2
    [10,4,15,3,11,21,5,9,14,8,13,12,17,16,22,24,1,2,18,23,20,6,19,7],  #tipo3
    [9,15,11,22,5,18,2,23,12,14,16,1,20,4,24,6,3,8,17,10,21,7,13,19]   #tipo4
]

# Respostas dos alunos (cada resposta está associada a um tipo de prova)
respostas_alunos = [
    {"tipo_prova": 1, "resposta": "DCBCEDAEDECBBBDCBCABECAB", "matricula": "202311190005"},
    {"tipo_prova": 1, "resposta": "CAACCDEDDBAABADDADADABEC", "matricula": "202221190030"},
    {"tipo_prova": 1, "resposta": "AEAEEDDEEAAABADDECADECAB", "matricula": "202311190036"},
    {"tipo_prova": 1, "resposta": "DBAEECCADABABBDDBDACBCBB", "matricula": "202211190009"},
    {"tipo_prova": 1, "resposta": "AEACEDDCEBCABBDDECADBCAB", "matricula": "202311190010"},
    {"tipo_prova": 1, "resposta": "AEACEDEEEBAABBDDECADBCAB", "matricula": "202311190028"},
    {"tipo_prova": 1, "resposta": "AEACEDDEEBCABBCDEAADBCAB", "matricula": "202321190039"},
    {"tipo_prova": 1, "resposta": "EBABABXXDDBAXBEXAXXXXXXX", "matricula": "202221190020"},
    {"tipo_prova": 2, "resposta": "BAACBCBCBDBEECEDBBABEAED", "matricula": "202221190011"},
    {"tipo_prova": 2, "resposta": "AAEBCCBECEBBDEACCBAABCAB", "matricula": "202311190022"},
    {"tipo_prova": 2, "resposta": "BDEABCEACCECEBCBBDECBBCB", "matricula": "2019219061"},
    {"tipo_prova": 2, "resposta": "BBACXCAACEBDDBACCCBBBAAC", "matricula": "202121190021"},
    {"tipo_prova": 2, "resposta": "EDCACCBBCBAACEAEABBCBDAB", "matricula": "202211190016"},
    {"tipo_prova": 2, "resposta": "BAEDCCBECEBDDBDCCDAADAAE", "matricula": "202311190007"},
    {"tipo_prova": 2, "resposta": "BBDCCCDACCADDDDACCBBCCAB", "matricula": "202311190011"},
    {"tipo_prova": 3, "resposta": "ECCEECBBEAEACEABBAABDDDD", "matricula": "202311190009"},
    {"tipo_prova": 3, "resposta": "EBCEDCBBAAEACEABBAABDDDC", "matricula": "202311190042"},
    {"tipo_prova": 3, "resposta": "DBBEECACAADACAEBAACBBDAB", "matricula": "202311190021"},
    {"tipo_prova": 3, "resposta": "EACADCBDEACAAEABBAABDDDB", "matricula": "202311190040"},
    {"tipo_prova": 3, "resposta": "BBEDAEACACDAEDBAEAACEDBC", "matricula": "2016119036"},
    {"tipo_prova": 3, "resposta": "ECBEACBCEAEACEABBAAEDDDC", "matricula": "202221190007"},
    {"tipo_prova": 3, "resposta": "EBAEECBBEAEACEABBAABDDDD", "matricula": "202311190020"},
    {"tipo_prova": 3, "resposta": "CCBEDACACCAACEABDCBBEDED", "matricula": "202311190013"},
    {"tipo_prova": 4, "resposta": "AAEBEDCCBDAAABEEADBBBCED", "matricula": "202311190008"},
    {"tipo_prova": 4, "resposta": "AEABEECCADBCAEECACDBBCBD", "matricula": "202311190023"},
    {"tipo_prova": 4, "resposta": "DCEDCBCCAABECCDEADDCADED", "matricula": "202221190028"},
    {"tipo_prova": 4, "resposta": "ACABEBCCAEDCABEACBADACED", "matricula": "202311190045"},
    {"tipo_prova": 4, "resposta": "ADEBEDCCADADABBCADBBBCED", "matricula": "202311190015"},
    {"tipo_prova": 4, "resposta": "ADEBADCCABAAABEAADBBBCEC", "matricula": "2019219062"},
    {"tipo_prova": 4, "resposta": "CDBECDCAEBBDADDDABBDBBED", "matricula": "2018119025"}
]

# Função que compara a resposta do aluno com o gabarito
def calcular_acertos(resposta_aluno, gabarito):
    acertos = 0
    for i in range(len(gabarito)):
        if resposta_aluno[i] == gabarito[i]:
            acertos += 1
    return acertos
	
# Verificar acertos para cada aluno
for aluno in respostas_alunos:
    matricula = aluno["matricula"]
    tipo_prova = aluno["tipo_prova"]
    resposta = aluno["resposta"]
    gabarito = gabaritos[tipo_prova]
    acertos = calcular_acertos(resposta, gabarito)
    print(f"Aluno: {matricula}\tacertou: {acertos} questões.\tProva tipo: {tipo_prova}.")
	
"""
# Relatorio de acertos de questões

for i in range(len(posicao[0])):

    somaA = 0 
    somaB = 0
    somaC = 0
    somaD = 0
    somaE = 0

    # Verificar acertos para cada aluno
    for aluno in respostas_alunos:
    
        tipo_prova = aluno["tipo_prova"]
        resposta = aluno["resposta"]
        indice = posicao[tipo_prova-1][i]
        elemento = resposta[indice-1]

        #print(elemento)
        match elemento:
            case "A":
                somaA+=1
            case "B":
                somaB+=1
            case "C":
                somaC+=1
            case "D":
                somaD+=1
            case "E":
                somaE+=1

    print(f"\nQuestao {i+1}\nA: {somaA}\nB: {somaB}\nC: {somaC}\nD: {somaD}\nE:{somaE}\n")
"""