//testar: java AnalisadorLexico programa1.c saida.lex
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalisadorLexico {

    // Estados do autômato
    enum Estado {
        INICIAL, 
		PRE_PROCESSADOR, 
		INCLUSAO_BIBLIOTECA, 
		IDENTIFICADOR, 
		TIPO_DADO, 
		NUMERO, 
		OPERADOR, 
		SEPARADOR, 
		ESPACO, 
		FIM
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java AnalisadorLexico <arquivo-entrada> <arquivo-saida>");
            return;
        }

        String arquivoEntrada = args[0];
		String arquivoSaida = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
            StringBuilder saida = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                saida.append(analisarLinha(linha));
            }

            // Escrever no arquivo de saída
            try (FileWriter writer = new FileWriter(arquivoSaida)) {
                writer.write(saida.toString().trim());
                System.out.println("Arquivo de saída gerado com sucesso!");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // Função que analisa uma linha de entrada, chamando a função de transição de estados
    private static String analisarLinha(String linha) {
        StringBuilder resultado = new StringBuilder();
        Estado estadoAtual = Estado.INICIAL;
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < linha.length(); i++) {
            char simbolo = linha.charAt(i);
            estadoAtual = transicaoEstado(simbolo, estadoAtual, token, resultado);
        }

        return resultado.toString().trim();
    }

    // Função de transição de estados
    private static Estado transicaoEstado(char simbolo, Estado estadoAtual, StringBuilder token, StringBuilder resultado) {
        switch (estadoAtual) {
            case INICIAL:
                if (simbolo == '#') {
                    resultado.append("$PRE_PROC$");
                    return Estado.PRE_PROCESSADOR;
                } else if (Character.isWhitespace(simbolo)) {
                    return Estado.ESPACO;
                } else if (Character.isLetter(simbolo)) {
                    token.append(simbolo);
                    return Estado.IDENTIFICADOR;
                } else if (Character.isDigit(simbolo)) {
                    token.append(simbolo);
                    return Estado.NUMERO;
                } else if (simbolo == '{') {
                    resultado.append("$ABR_CHA$");
                    return Estado.INICIAL;
                } else if (simbolo == '}') {
                    resultado.append("$FEC_CHA$");
                    return Estado.INICIAL;
                } else if (simbolo == '(') {
                    resultado.append("$ABR_PAR$");
                    return Estado.INICIAL;
                } else if (simbolo == ')') {
                    resultado.append("$FEC_PAR$");
                    return Estado.INICIAL;
                } else if (simbolo == ',') {
                    resultado.append("$SEP_VIR$");
                    return Estado.INICIAL;
                } else if (simbolo == ';') {
                    resultado.append("$FIN_INST$");
                    return Estado.INICIAL;
                } else if (simbolo == '=') {
                    resultado.append("$ATRIB$");
                    return Estado.INICIAL;
                } else if (simbolo == '+') {
                    resultado.append("$OPE_ARI_SOM$");
                    return Estado.INICIAL;
                } else if (simbolo == '*') {
                    resultado.append("$OPE_ARI_MUL$");
                    return Estado.INICIAL;
                }
                break;

            case PRE_PROCESSADOR:
                if (simbolo == '<') {
                    return Estado.INCLUSAO_BIBLIOTECA;
                }
                break;

            case INCLUSAO_BIBLIOTECA:
                if (simbolo == '>') {
                    resultado.append("$ABR_COL_ANG$ $BIBLIO$ $FEC_COL_ANG$");
                    return Estado.INICIAL;
                }
                break;

            case IDENTIFICADOR:
                if (Character.isLetterOrDigit(simbolo) || simbolo == '_') {
                    token.append(simbolo);
                } else {
                    String palavra = token.toString();
                    if (palavra.equals("void")) {
                        resultado.append("$TIPO_VOID$");
                    } else if (palavra.equals("int")) {
                        resultado.append("$TIPO_INT$");
                    } else if (palavra.equals("float")) {
                        resultado.append("$TIPO_FLOAT$");
                    } else if (palavra.equals("return")) {
                        resultado.append("$RET_FUNC$");
                    } else {
                        resultado.append("$IDENT$");
                    }
                    token.setLength(0); // Limpar o token
                    return transicaoEstado(simbolo, Estado.INICIAL, token, resultado); // Voltar para o estado inicial e processar o símbolo atual
                }
                break;

            case NUMERO:
                if (Character.isDigit(simbolo)) {
                    token.append(simbolo);
                } else if (simbolo == '.') {
                    token.append(simbolo); // Parte do número decimal
                    return Estado.NUMERO;
                } else {
                    resultado.append("$NUM_INT$");
                    token.setLength(0); // Limpar o token
                    return transicaoEstado(simbolo, Estado.INICIAL, token, resultado); // Voltar para o estado inicial e processar o símbolo atual
                }
                break;

            case ESPACO:
                if (!Character.isWhitespace(simbolo)) {
                    resultado.append("$ESP$");
                    return transicaoEstado(simbolo, Estado.INICIAL, token, resultado);
                }
                break;

            default:
                return Estado.INICIAL;
        }

        return estadoAtual; // Manter o estado atual
    }
}
