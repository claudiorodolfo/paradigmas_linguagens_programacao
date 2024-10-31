import java.lang.Exception
import kotlin.system.exitProcess

class AnalisadorLexico {

    // Estados do autômato
    private enum class Estado {
        INICIAL, 
        PRE_PROCESSADOR,
        INCLUSAO_BIBLIOTECA,
        IDENTIFICADOR,
        TIPO_DADO,
        NUMERO,
        OPERADOR,
        SEPARADOR,
        ESPACO,
        TEXTO,
        FIM
    }

    private var token = StringBuilder()
    private var resultado = StringBuilder()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size != 2) {
                println("Uso: java AnalisadorLexico <arquivo-entrada> <arquivo-saida>")
                exitProcess(1)
            }

            val arquivoEntrada = args[0]
            val arquivoSaida = args[1]

            try {
                val linhas = kotlin.io.readText(arquivoEntrada).lines()
                val lexico = AnalisadorLexico()
                val saida = StringBuilder()

                linhas.forEach { linha ->
                    saida.append(lexico.analisarLinha(linha))
                }

                // Escrever no arquivo de saída
                kotlin.io.writeText(arquivoSaida, saida.toString().trim())
                println("Arquivo de saída gerado com sucesso!")
            } catch (e: Exception) {
                println("Erro ao ler ou escrever o arquivo: \${e.message}")
            }
        }
    }

    // Função que analisa uma linha de entrada, chamando a função de transição de estados
    private fun analisarLinha(linha: String): String {
        resultado = StringBuilder()
        token = StringBuilder()
        
        var estadoAtual = Estado.INICIAL
        for (simbolo in linha) {
            estadoAtual = transicaoEstado(simbolo, estadoAtual)
        }

        return resultado.toString().trim()
    }

    // Função de transição de estados
    private fun transicaoEstado(simbolo: Char, estadoAtual: Estado): Estado {
        return when (estadoAtual) {
            Estado.INICIAL -> {
                when {
                    simbolo == '#' -> {
                        resultado.append("\$PRE_PROC\$")
                        Estado.PRE_PROCESSADOR
                    }
                    simbolo.isWhitespace() -> Estado.ESPACO
                    simbolo.isLetter() -> {
                        token.append(simbolo)
                        Estado.IDENTIFICADOR
                    }
                    simbolo.isDigit() -> {
                        token.append(simbolo)
                        Estado.NUMERO
                    }
                    simbolo == '"' -> {
                        token.append(simbolo)
                        Estado.TEXTO
                    }
                    simbolo == '{' -> {
                        resultado.append("\$ABR_CHA\$")
                        Estado.INICIAL
                    }
                    simbolo == '}' -> {
                        resultado.append("\$FEC_CHA\$")
                        Estado.INICIAL
                    }
                    simbolo == '(' -> {
                        resultado.append("\$ABR_PAR\$")
                        Estado.INICIAL
                    }
                    simbolo == ')' -> {
                        resultado.append("\$FEC_PAR\$")
                        Estado.INICIAL
                    }
                    simbolo == ',' -> {
                        resultado.append("\$SEP_VIR\$")
                        Estado.INICIAL
                    }
                    simbolo == ';' -> {
                        resultado.append("\$FIN_INST\$")
                        Estado.INICIAL
                    }
                    simbolo == '=' -> {
                        resultado.append("\$ATRIB\$")
                        Estado.INICIAL
                    }
                    simbolo == '+' -> {
                        resultado.append("\$OPE_ARI_SOM\$")
                        Estado.INICIAL
                    }
                    simbolo == '-' -> {
                        resultado.append("\$OPE_ARI_SUB\$")
                        Estado.INICIAL
                    }
                    simbolo == '*' -> {
                        resultado.append("\$OPE_ARI_MUL\$")
                        Estado.INICIAL
                    }
                    simbolo == '/' -> {
                        resultado.append("\$OPE_ARI_DIV\$")
                        Estado.INICIAL
                    }
                    else -> estadoAtual
                }
            }

            Estado.PRE_PROCESSADOR -> {
                if (simbolo == '<') {
                    resultado.append("\$ABR_COL_ANG\$")
                    Estado.INCLUSAO_BIBLIOTECA
                } else {
                    estadoAtual
                }
            }

            Estado.INCLUSAO_BIBLIOTECA -> {
                if (simbolo == '>') {
                    resultado.append("\$BIBLIO\$\$FEC_COL_ANG\$")
                    Estado.INICIAL
                } else {
                    estadoAtual
                }
            }

            Estado.IDENTIFICADOR -> {
                when {
                    simbolo.isLetterOrDigit() || simbolo == '_' -> token.append(simbolo)
                    else -> {
                        when (token.toString()) {
                            "void" -> resultado.append("\$TIPO_VOID\$")
                            "int" -> resultado.append("\$TIPO_INT\$")
                            "float" -> resultado.append("\$TIPO_FLOAT\$")
                            "return" -> resultado.append("\$RET_FUNC\$")
                            else -> resultado.append("\$IDENT\$")
                        }
                        token.clear()
                        transicaoEstado(simbolo, Estado.INICIAL)
                    }
                }
            }

            Estado.NUMERO -> {
                when {
                    simbolo.isDigit() -> token.append(simbolo)
                    simbolo == '.' -> {
                        token.append(simbolo)
                        Estado.NUMERO
                    }
                    else -> {
                        resultado.append("\$NUM_INT\$")
                        token.clear()
                        transicaoEstado(simbolo, Estado.INICIAL)
                    }
                }
            }

            Estado.TEXTO -> {
                token.append(simbolo)
                if (simbolo == '"') {
                    resultado.append("\$TEXTO\$")
                    token.clear()
                    Estado.INICIAL
                } else {
                    estadoAtual
                }
            }

            Estado.ESPACO -> {
                if (!simbolo.isWhitespace()) {
                    resultado.append("\$ESP\$")
                    transicaoEstado(simbolo, Estado.INICIAL)
                } else {
                    estadoAtual
                }
            }

            else -> Estado.INICIAL
        }
    }
}
