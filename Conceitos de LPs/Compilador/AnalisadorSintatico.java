//testar: java AnalisadorLexico saida.plp

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Enum para representar os tipos de tokens na gramática
enum TipoToken {
    PRE_PROCESSADOR, 
	BIBLIOTECA, 
	ABRE_COLCHETE_ANGULADO, 
	FECHA_COLCHETE_ANGULADO,  
	TIPO_INT, 
	TIPO_FLOAT,
	TIPO_VOID,
	IDENTIFICADOR, 
	ESPACO, 
	ABRE_PARENTESE, 
	FECHA_PARENTESE, 
	ABRE_CHAVE, 
	FECHA_CHAVE, 
	LISTA_PARAMETROS, 
	ATRIBUICAO, 
	FIM_INSTRUCAO, 
	INSTRUCAO_RETORNO,
	NUMERO_INTEIRO,
	NUMERO_REAL,	
	SEPARADOR,
	OPERADOR_ARI_SOMA,
	OPERADOR_ARI_SUBTRACAO,
	FATOR,
	OPERADOR_ARI_MULTIPLICACAO,
	OPERADOR_ARI_DIVISAO,
	EOF
}

// Classe Token para representar um token identificado
class Token {
    TipoToken tipo;
    String valor;

    Token(TipoToken tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}

// Classe responsável por tokenizar a entrada
class Tokenizador {
    private final String entrada;
    private int posicao = 0;

    // Construtor recebe a string de entrada
    public Tokenizador(String entrada) {
        this.entrada = entrada;
    }

    // Avança para o próximo token
    private void avancar() {
        posicao++;
    }

    // Pula espaços em branco
    private void pularEspacos() {
        while (posicao < entrada.length() && Character.isWhitespace(entrada.charAt(posicao))) {
            posicao++;
        }
    }

    // Realiza a tokenização da entrada
    public List<Token> tokenizar() {
        List<Token> tokens = new ArrayList<>();

        while (posicao < entrada.length()) {
            pularEspacos();

            if (entrada.startsWith("$PRE_PROC$", posicao)) {
                tokens.add(new Token(TipoToken.PRE_PROCESSADOR, "$PRE_PROC$"));
                posicao += "$PRE_PROC$".length();
            } else if (entrada.startsWith("$BIBLIO$", posicao)) {
                tokens.add(new Token(TipoToken.BIBLIOTECA, "$BIBLIO$"));
                posicao += "$BIBLIO$".length();
            } else if (entrada.startsWith("$ABR_COL_ANG$", posicao)) {
                tokens.add(new Token(TipoToken.ABRE_COLCHETE_ANGULADO, "$ABR_COL_ANG$"));
                posicao += "$ABR_COL_ANG$".length();
            } else if (entrada.startsWith("$FEC_COL_ANG$", posicao)) {
                tokens.add(new Token(TipoToken.FECHA_COLCHETE_ANGULADO, "$FEC_COL_ANG$"));
                posicao += "$FEC_COL_ANG$".length();
            } else if (entrada.startsWith("$TIPO_INT$", posicao)) {
                tokens.add(new Token(TipoToken.TIPO_INT, "$TIPO_INT$"));
                posicao += "$TIPO_INT$".length();
            } else if (entrada.startsWith("$TIPO_FLOAT$", posicao)) {
                tokens.add(new Token(TipoToken.TIPO_FLOAT, "$TIPO_FLOAT$"));
                posicao += "$TIPO_FLOAT$".length();
            } else if (entrada.startsWith("$TIPO_VOID$", posicao)) {
                tokens.add(new Token(TipoToken.TIPO_VOID, "$TIPO_VOID$"));
                posicao += "$TIPO_VOID$".length();				
            } else if (entrada.startsWith("$IDENT$", posicao)) {
                tokens.add(new Token(TipoToken.IDENTIFICADOR, "$IDENT$"));
                posicao += "$IDENT$".length();			
            } else if (entrada.startsWith("$OPE_ARI_SOM$", posicao)) {
                tokens.add(new Token(TipoToken.OPERADOR_ARI_SOMA, "$OPE_ARI_SOM$"));
                posicao += "$OPE_ARI_SOM$".length();
            } else if (entrada.startsWith("$OPE_ARI_SUB$", posicao)) {
                tokens.add(new Token(TipoToken.OPERADOR_ARI_SUBTRACAO, "$OPE_ARI_SUB$"));
                posicao += "$OPE_ARI_SUB$".length();			
            } else if (entrada.startsWith("$OPE_ARI_MUL$", posicao)) {
                tokens.add(new Token(TipoToken.OPERADOR_ARI_MULTIPLICACAO, "$OPE_ARI_MUL$"));
                posicao += "$OPE_ARI_MUL$".length();
            } else if (entrada.startsWith("$OPE_ARI_DIV$", posicao)) {
                tokens.add(new Token(TipoToken.OPERADOR_ARI_DIVISAO, "$OPE_ARI_DIV$"));
                posicao += "$OPE_ARI_DIV$".length();				
            } else if (entrada.startsWith("$ESP$", posicao)) {
                tokens.add(new Token(TipoToken.ESPACO, "$ESP$"));
                posicao += "$ESP$".length();
			} else if (entrada.startsWith("$SEP_VIR$", posicao)) {
                tokens.add(new Token(TipoToken.SEPARADOR, "$SEP_VIR$"));
                posicao += "$SEP_VIR$".length();
            } else if (entrada.startsWith("$ABR_PAR$", posicao)) {
                tokens.add(new Token(TipoToken.ABRE_PARENTESE, "$ABR_PAR$"));
                posicao += "$ABR_PAR$".length();
            } else if (entrada.startsWith("@PARAMETROS@", posicao)) {
                tokens.add(new Token(TipoToken.LISTA_PARAMETROS, "@PARAMETROS@"));
                posicao += "@PARAMETROS@".length();				
            } else if (entrada.startsWith("$FEC_PAR$", posicao)) {
                tokens.add(new Token(TipoToken.FECHA_PARENTESE, "$FEC_PAR$"));
                posicao += "$FEC_PAR$".length();
            } else if (entrada.startsWith("$ABR_CHA$", posicao)) {
                tokens.add(new Token(TipoToken.ABRE_CHAVE, "$ABR_CHA$"));
                posicao += "$ABR_CHA$".length();
            } else if (entrada.startsWith("$ATRIB$", posicao)) {
                tokens.add(new Token(TipoToken.ATRIBUICAO, "$ATRIB$"));
                posicao += "$ATRIB$".length();			
            } else if (entrada.startsWith("$FIN_INST$", posicao)) {
                tokens.add(new Token(TipoToken.FIM_INSTRUCAO, "$FIN_INST$"));
                posicao += "$FIN_INST$".length();
            } else if (entrada.startsWith("$RET_FUNC$", posicao)) {
                tokens.add(new Token(TipoToken.INSTRUCAO_RETORNO, "$RET_FUNC$"));
                posicao += "$RET_FUNC$".length();		
            } else if (entrada.startsWith("$NUM_INT$", posicao)) {
                tokens.add(new Token(TipoToken.NUMERO_INTEIRO, "$NUM_INT$"));
                posicao += "$NUM_INT$".length();					
            } else if (entrada.startsWith("$NUM_REA$", posicao)) {
                tokens.add(new Token(TipoToken.NUMERO_REAL, "$NUM_REA$"));
                posicao += "$NUM_REA$".length();				
            } else if (entrada.startsWith("$FEC_CHA$", posicao)) {
                tokens.add(new Token(TipoToken.FECHA_CHAVE, "$FEC_CHA$"));
                posicao += "$FEC_CHA$".length();				
            } else {
                throw new RuntimeException("Token inválido encontrado: " + entrada.charAt(posicao) + "Posicao:" + posicao);
            }
        }

        // Adiciona o EOF ao final
        tokens.add(new Token(TipoToken.EOF, ""));
        return tokens;
    }
}

// Regras Sintáticas para verificar a estrutura dos tokens
class RegrasSintaticas {
    private final List<Token> tokens;
    private int posicaoAtual = 0;
    private Token tokenAtual;

    public RegrasSintaticas(List<Token> tokens) {
        this.tokens = tokens;
        this.tokenAtual = tokens.get(posicaoAtual);
    }

    // Avança para o próximo token
    private void consumir(TipoToken tipoEsperado) {
        if (tokenAtual.tipo == tipoEsperado) {
            tokenAtual = tokens.get(++posicaoAtual);
        } else {
            throw new RuntimeException("Erro de sintaxe: Esperado " + tipoEsperado + ", mas encontrado " + tokenAtual.tipo);
        }
    }

    // <programa> ::= ( <list_preprocessador> )* <definicao_funcao>
    public void verificarPrograma() {
        // Enquanto houver pré-processadores, continua processando a lista
        while (tokenAtual.tipo == TipoToken.PRE_PROCESSADOR) {
            verificarPreProcessador();
        }
        verificarDefinicaoFuncao();		
    }

    // <preprocessador> ::= <inclusao> <abre_colche_ang> <biblioteca> <fecha_colche_ang>
    private void verificarPreProcessador() {
        consumir(TipoToken.PRE_PROCESSADOR);         // <inclusao>
        consumir(TipoToken.ABRE_COLCHETE_ANGULADO);  // <abre_colche_ang>
        consumir(TipoToken.BIBLIOTECA);              // <biblioteca>
        consumir(TipoToken.FECHA_COLCHETE_ANGULADO); // <fecha_colche_ang>
    }

    // <definicao_funcao> ::= <especificador_tipo> <espaco> <identificador> <abre_parentese> <lista_parametros> <fecha_parentese> <abre_chave> <lista_comandos> <fecha_chave>
    public void verificarDefinicaoFuncao() {
        verificarEspecificadorTipo();           // <especificador_tipo>
        consumir(TipoToken.ESPACO);             // <espaco>
        consumir(TipoToken.IDENTIFICADOR);      // <identificador>
        consumir(TipoToken.ABRE_PARENTESE);     // <abre_parentese>
        verificarListaParametros();				// <lista_parametros>		
        consumir(TipoToken.FECHA_PARENTESE);    // <fecha_parentese>
        consumir(TipoToken.ABRE_CHAVE);         // <abre_chave>
        verificarListaComandos();				// <lista_comandos>			
        consumir(TipoToken.FECHA_CHAVE);        // <fecha_chave>
    }

	// <lista_parametros> ::=  E | <parametro> ( <separador> <parametro> )*
    public void verificarListaParametros() {
		if (tokenAtual.tipo == TipoToken.TIPO_INT || 
				tokenAtual.tipo == TipoToken.TIPO_FLOAT || 
				tokenAtual.tipo == TipoToken.TIPO_VOID) {	//se tiver tipo verifica o conjunto
			verificarParametro();           // <especificador_tipo>
			
			// Verifica parâmetros adicionais, se houver
			while (tokenAtual.tipo == TipoToken.SEPARADOR) {  // se tiver separador, considera-se que há mais parametros
				consumir(TipoToken.SEPARADOR);       // <separador>
				verificarParametro();                // <parametro>
			}
			//else
				//E
		}
    }

	// <parametro> ::= <especificador_tipo> <espaco> <identificador> 	
	public void verificarParametro() {
		verificarEspecificadorTipo();           // <especificador_tipo>
		consumir(TipoToken.ESPACO);             // <espaco> 
		consumir(TipoToken.IDENTIFICADOR);		// <identificador>
	}
	
	// <especificador_tipo> ::= <tipo_int> | <tipo_float> | <tipo_void>
	public void verificarEspecificadorTipo() {
		switch (tokenAtual.tipo) {
			case TIPO_INT:
				consumir(TipoToken.TIPO_INT);  // Verifica tipo int
				break;
			case TIPO_FLOAT:
				consumir(TipoToken.TIPO_FLOAT);  // Verifica tipo float
				break;
			case TIPO_VOID:
				consumir(TipoToken.TIPO_VOID);  // Verifica tipo void
				break;
			default:
				throw new RuntimeException("Erro de sintaxe: Esperado um especificador de tipo válido, mas encontrado " + tokenAtual.tipo);
		}
	}
	
	// <lista_comandos> ::= ( <comando> )*
    public void verificarListaComandos() {
		verificarComandoDeclaracaoAtribuicao();

        // Enquanto houver mais comandos, continua processando a lista
        //while (tokenAtual.tipo == TipoToken.TIPO) {
        //    verificarComandoDeclaracaoAtribuicao();
        //}
		
		verificarComandoRetorno();		
	}
	
    // <comando_declaracao_atribuicao> ::= ( <especificador_tipo> <espaco> )? <identificador> <atribuicao> <expressao> <fim_instrucao>
    public void verificarComandoDeclaracaoAtribuicao() {
		if (tokenAtual.tipo == TipoToken.TIPO_INT || 
			tokenAtual.tipo == TipoToken.TIPO_FLOAT || 
			tokenAtual.tipo == TipoToken.TIPO_VOID) {	//se tiver tipo verifica o ( <especificador_tipo> <espaco> )?
			verificarEspecificadorTipo();           // <especificador_tipo> 
			consumir(TipoToken.ESPACO);             // <espaco>
		}
        consumir(TipoToken.IDENTIFICADOR);		// <identificador>
        consumir(TipoToken.ATRIBUICAO); 		// <atribuicao>
        verificarExpressao();					// <expressao>
        consumir(TipoToken.FIM_INSTRUCAO);		// <fim_instrucao>
    }

	// <expressao> ::= <termo> ( ( <soma> | <subtracao> ) <termo> )*
	public void verificarExpressao() {
		verificarTermo();// <termo>		
		
		// Verifica se há uma sequência de ( + <termo> | - <termo> )
		while (tokenAtual.tipo == TipoToken.OPERADOR_ARI_SOMA || tokenAtual.tipo == TipoToken.OPERADOR_ARI_SUBTRACAO) { 
			if (tokenAtual.tipo == TipoToken.OPERADOR_ARI_SOMA) {
				consumir(TipoToken.OPERADOR_ARI_SOMA);  // Consome o operador soma (+)
			} else if (tokenAtual.tipo == TipoToken.OPERADOR_ARI_SUBTRACAO) {
				consumir(TipoToken.OPERADOR_ARI_SUBTRACAO);  // Consome o operador subtração (-)
			}

			verificarTermo();  // Verifica o próximo termo
		}		
	}

	// <termo> ::= <fator> ( ( <multiplicacao> | <divisao> ) <fator> )*	
	public void verificarTermo() {
		verificarFator();// <fator>	
		
		// Verifica se há uma sequência de ( * <fator> | / <fator> )
		while (tokenAtual.tipo == TipoToken.OPERADOR_ARI_MULTIPLICACAO || tokenAtual.tipo == TipoToken.OPERADOR_ARI_DIVISAO) { 
			if (tokenAtual.tipo == TipoToken.OPERADOR_ARI_MULTIPLICACAO) {
				consumir(TipoToken.OPERADOR_ARI_MULTIPLICACAO);  // Consome o operador multiplicação (*)
			} else if (tokenAtual.tipo == TipoToken.OPERADOR_ARI_DIVISAO) {
				consumir(TipoToken.OPERADOR_ARI_DIVISAO);  // Consome o operador divisão (/)
			}
			
			verificarFator();  // Verifica o próximo fator
		}
	}

	// <fator> ::= <numero> | <identificador>	
	public void verificarFator() {
		if (tokenAtual.tipo == TipoToken.NUMERO_INTEIRO || tokenAtual.tipo == TipoToken.NUMERO_REAL) {
			verificarNumero();  				// <numero>
		} else if (tokenAtual.tipo == TipoToken.IDENTIFICADOR) {
			consumir(TipoToken.IDENTIFICADOR);  // <identificador>	
		}
	}

	// <numero> ::=  <numero_inteiro> | <numero_real>
	public void verificarNumero() {
		if (tokenAtual.tipo == TipoToken.NUMERO_INTEIRO) {
			consumir(TipoToken.NUMERO_INTEIRO);  // <numero_inteiro>
		} else if (tokenAtual.tipo == TipoToken.NUMERO_REAL) {
			consumir(TipoToken.NUMERO_REAL);  // <numero_real>	
		}
	}
	
	// <comando_retorno> ::= <instrucao_retorno> <espaco> ( <numero_inteiro> | <identificador> ) <fim_instrucao>
    public void verificarComandoRetorno() {
        consumir(TipoToken.INSTRUCAO_RETORNO);  // <especificador_tipo>
        consumir(TipoToken.ESPACO);             // <espaco>
		
		if (tokenAtual.tipo == TipoToken.NUMERO_INTEIRO) {
			consumir(TipoToken.NUMERO_INTEIRO); // <numero_inteiro>
		} else if (tokenAtual.tipo == TipoToken.IDENTIFICADOR) {
			consumir(TipoToken.IDENTIFICADOR);	// <identificador> 
		} else {
			throw new RuntimeException("Erro de sintaxe: Esperado um valor ou identificador " + tokenAtual.tipo);
		}	
		
        consumir(TipoToken.FIM_INSTRUCAO);		// <fim_instrucao>
    }	
}

// Classe principal do Analisador Sintático
public class AnalisadorSintatico {
    public static void main(String[] args) {
		if (args.length != 1) {
            System.out.println("Uso: java AnalisadorSintatico <nome-do-arquivo>");
            return;
        }

        String nomeArquivo = args[0];
        String entrada = "";
		
		try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null)
                entrada += linha;
			
        } catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }
		        
        Tokenizador tokenizador = new Tokenizador(entrada);
        List<Token> tokens = tokenizador.tokenizar();

		for(Token token: tokens)
			System.out.println(token.tipo);
			
        RegrasSintaticas parser = new RegrasSintaticas(tokens);
		try {
			parser.verificarPrograma();
			System.out.println("Programa analisado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }			
    }
}
//ESTa FALTANDO LISTA DE COMANDOS
//E PARAMETROS PASSADOS PARA FUNÇÕES