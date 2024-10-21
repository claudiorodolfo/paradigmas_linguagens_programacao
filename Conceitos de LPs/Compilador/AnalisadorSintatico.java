//testar: java AnalisadorLexico saida1.lex
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
	TEXTO,
	SEPARADOR,
	OPERADOR_ARI_SOMA,
	OPERADOR_ARI_SUBTRACAO,
	OPERADOR_ARI_MULTIPLICACAO,
	OPERADOR_ARI_DIVISAO,
	LISTA_ARGUMENTOS,
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

// Classe responsável por separar os tokens da entrada
class SeparadorTokens {
	private final String entrada;
	
	// Construtor recebe a string de entrada
	public SeparadorTokens(String entrada) {
		this.entrada = entrada;
	}

	// Realiza a separação dos tokens da entrada
	public List<Token> separador() {
		List<Token> tokens = new ArrayList<>();
		
		//	(?<=\\$) faz o "lookbehind" para garantir que o delimitador é precedido por $
		//	\\s* captura possíveis espaços entre os tokens
		//	(?=\\$) faz o "lookahead" para garantir que o próximo token começa com $
		String[] partes = entrada.split("(?<=\\$)\\s*(?=\\$)");
		for(String parte: partes)
			switch(parte) {
				case "$PRE_PROC$":
					tokens.add(new Token(TipoToken.PRE_PROCESSADOR, parte));
				break;
				case "$BIBLIO$":
					tokens.add(new Token(TipoToken.BIBLIOTECA, parte));
				break;
				case "$ABR_COL_ANG$":
					tokens.add(new Token(TipoToken.ABRE_COLCHETE_ANGULADO, parte));
				break;
				case "$FEC_COL_ANG$":
					tokens.add(new Token(TipoToken.FECHA_COLCHETE_ANGULADO, parte));
				break;
				case "$TIPO_INT$":
					tokens.add(new Token(TipoToken.TIPO_INT, parte));
				break;
				case "$TIPO_FLOAT$":
					tokens.add(new Token(TipoToken.TIPO_FLOAT, parte));
				break;
				case "$TIPO_VOID$":
					tokens.add(new Token(TipoToken.TIPO_VOID, parte));
				break;
				case "$IDENT$":
					tokens.add(new Token(TipoToken.IDENTIFICADOR, parte));
				break;
				case "$OPE_ARI_SOM$":
					tokens.add(new Token(TipoToken.OPERADOR_ARI_SOMA, parte));
				break;
				case "$OPE_ARI_SUB$":
					tokens.add(new Token(TipoToken.OPERADOR_ARI_SUBTRACAO, parte));
				break;
				case "$OPE_ARI_MUL$":
					tokens.add(new Token(TipoToken.OPERADOR_ARI_MULTIPLICACAO, parte));
				break;
				case "$OPE_ARI_DIV$":
					tokens.add(new Token(TipoToken.OPERADOR_ARI_DIVISAO, parte));
				break;
				case "$ESP$":
					tokens.add(new Token(TipoToken.ESPACO, parte));
				break;
				case "$SEP_VIR$":
					tokens.add(new Token(TipoToken.SEPARADOR, parte));
				break;
				case "$ABR_PAR$":
					tokens.add(new Token(TipoToken.ABRE_PARENTESE, parte));
				break;
				case "$FEC_PAR$":
					tokens.add(new Token(TipoToken.FECHA_PARENTESE, parte));
				break;
				case "$PARAMETROS$":
					tokens.add(new Token(TipoToken.LISTA_PARAMETROS, parte));
				break;
				case "$ABR_CHA$":
					tokens.add(new Token(TipoToken.ABRE_CHAVE, parte));
				break;
				case "$FEC_CHA$":
					tokens.add(new Token(TipoToken.FECHA_CHAVE, parte));
				break;
				case "$ATRIB$":
					tokens.add(new Token(TipoToken.ATRIBUICAO, parte));
				break;
				case "$FIN_INST$":
					tokens.add(new Token(TipoToken.FIM_INSTRUCAO, parte));
				break;
				case "$RET_FUNC$":
					tokens.add(new Token(TipoToken.INSTRUCAO_RETORNO, parte));
				break;
				case "$NUM_INT$":
					tokens.add(new Token(TipoToken.NUMERO_INTEIRO, parte));
				break;
				case "$NUM_REA$":
					tokens.add(new Token(TipoToken.NUMERO_REAL, parte));
				break;
				default:
					throw new RuntimeException("Token inválido encontrado: " + parte);
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

	// <programa> ::= ( <list_preprocessador> )* ( <definicao_funcao> )+
	public void verificarPrograma() {
		// Enquanto houver pré-processadores, continua processando a lista
		while (tokenAtual.tipo == TipoToken.PRE_PROCESSADOR) {
			verificarPreProcessador();
		}
		
		verificarDefinicaoFuncao();	
		// Enquanto houver mais funções, continua processando a lista
		while (tokenAtual.tipo == TipoToken.TIPO_INT ||
				tokenAtual.tipo == TipoToken.TIPO_FLOAT ||
				tokenAtual.tipo == TipoToken.TIPO_VOID) {
			verificarDefinicaoFuncao();
		}		
	}

	// <preprocessador> ::= <inclusao> <abre_colche_ang> <biblioteca> <fecha_colche_ang>
	private void verificarPreProcessador() {
		consumir(TipoToken.PRE_PROCESSADOR);		 // <inclusao>
		consumir(TipoToken.ABRE_COLCHETE_ANGULADO);  // <abre_colche_ang>
		consumir(TipoToken.BIBLIOTECA);			  // <biblioteca>
		consumir(TipoToken.FECHA_COLCHETE_ANGULADO); // <fecha_colche_ang>
	}

	// <definicao_funcao> ::= <especificador_tipo> <espaco> <identificador> <abre_parentese> <lista_parametros> <fecha_parentese> <abre_chave> <lista_comandos> <fecha_chave>
	public void verificarDefinicaoFuncao() {
		verificarEspecificadorTipo();		// <especificador_tipo>
		consumir(TipoToken.ESPACO);			// <espaco>
		consumir(TipoToken.IDENTIFICADOR);	// <identificador>
		consumir(TipoToken.ABRE_PARENTESE);	// <abre_parentese>
		verificarListaParametros();			// <lista_parametros>		
		consumir(TipoToken.FECHA_PARENTESE);// <fecha_parentese>
		consumir(TipoToken.ABRE_CHAVE);		// <abre_chave>
		verificarListaComandos();			// <lista_comandos>			
		consumir(TipoToken.FECHA_CHAVE);	// <fecha_chave>
	}

	// <especificador_tipo> ::= <tipo_int> | <tipo_float> | <tipo_void>
	public void verificarEspecificadorTipo() {
		switch (tokenAtual.tipo) {
			case TIPO_INT:
				consumir(TipoToken.TIPO_INT);	// Verifica tipo int
				break;
			case TIPO_FLOAT:
				consumir(TipoToken.TIPO_FLOAT);	// Verifica tipo float
				break;
			case TIPO_VOID:
				consumir(TipoToken.TIPO_VOID);	// Verifica tipo void
				break;
			default:
				throw new RuntimeException("Erro de sintaxe: Esperado um especificador de tipo válido, mas encontrado " + tokenAtual.tipo);
		}
	}
	
	// <lista_parametros> ::=  E | <parametro> ( <separador> <parametro> )*
	public void verificarListaParametros() {
		if (tokenAtual.tipo == TipoToken.TIPO_INT || 
				tokenAtual.tipo == TipoToken.TIPO_FLOAT || 
				tokenAtual.tipo == TipoToken.TIPO_VOID) {	//se tiver tipo verifica o conjunto
			verificarParametro();				// <parametro>
			
			// Verifica parâmetros adicionais, se houver
			while (tokenAtual.tipo == TipoToken.SEPARADOR) {  // se tiver separador, considera-se que há mais parametros
				consumir(TipoToken.SEPARADOR);	// <separador>
				verificarParametro();			// <parametro>
			}
		} else {
				//E
		}
	}

	// <parametro> ::= <especificador_tipo> <espaco> <identificador> 	
	public void verificarParametro() {
		verificarEspecificadorTipo();			// <especificador_tipo>
		consumir(TipoToken.ESPACO);				// <espaco> 
		consumir(TipoToken.IDENTIFICADOR);		// <identificador>
	}
	
	// <lista_comandos> ::= ( <comando> )*
	public void verificarListaComandos() {
		while (tokenAtual.tipo == TipoToken.INSTRUCAO_RETORNO ||
				tokenAtual.tipo == TipoToken.TIPO_INT ||
				tokenAtual.tipo == TipoToken.TIPO_FLOAT ||
				tokenAtual.tipo == TipoToken.TIPO_VOID ||
				tokenAtual.tipo == TipoToken.IDENTIFICADOR) {
			verificarComando();
		}
	}

	//	<comando>  ::= <comando_declaracao_atribuicao> | <comando_chamada_funcao> | <comando_retorno>
	public void verificarComando() {
		if (tokenAtual.tipo == TipoToken.INSTRUCAO_RETORNO) {
			verificarComandoRetorno();								// <comando_retorno>
		} else if (tokenAtual.tipo == TipoToken.TIPO_INT || 
				tokenAtual.tipo == TipoToken.TIPO_FLOAT || 
				tokenAtual.tipo == TipoToken.TIPO_VOID) {
			verificarComandoDeclaracaoAtribuicao();					// <comando_declaracao_atribuicao>
		} else if (tokenAtual.tipo == TipoToken.IDENTIFICADOR) {	//como ambas instruções começam com IDENTIFICADOR, tive que usar o próximo token para saber qual regra sintática correta chamar
			Token proximoToken = tokens.get(posicaoAtual+1);
			if (proximoToken.tipo == TipoToken.ATRIBUICAO) {
				verificarComandoDeclaracaoAtribuicao();				// <comando_declaracao_atribuicao>
			} else if (proximoToken.tipo == TipoToken.ABRE_PARENTESE) {
				verificarComandoChamadaFuncao();					//<comando_chamada_funcao>
			}
		} else {
			throw new RuntimeException("Erro de sintaxe: Esperado um comando de retorno, chamada de função ou de declaração atribuição " + tokenAtual.tipo);
		}
	}
	
	// <comando_declaracao_atribuicao> ::= ( <especificador_tipo> <espaco> )? <identificador> <atribuicao> <expressao> <fim_instrucao>
	public void verificarComandoDeclaracaoAtribuicao() {
		if (tokenAtual.tipo == TipoToken.TIPO_INT || 
			tokenAtual.tipo == TipoToken.TIPO_FLOAT || 
			tokenAtual.tipo == TipoToken.TIPO_VOID) {	//se tiver tipo verifica o ( <especificador_tipo> <espaco> )?
			verificarEspecificadorTipo();		// <especificador_tipo> 
			consumir(TipoToken.ESPACO);			// <espaco>
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
			} else {
				throw new RuntimeException("Erro de sintaxe: Esperado um operador aritmético de soma ou subtração " + tokenAtual.tipo);
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
			} else {
				throw new RuntimeException("Erro de sintaxe: Esperado um operador aritmético de multiplicação ou divisão " + tokenAtual.tipo);
			}
			
			verificarFator();  // Verifica o próximo fator
		}
	}

	// <fator> ::= <numero> | <identificador>
	public void verificarFator() {
		if (tokenAtual.tipo == TipoToken.NUMERO_INTEIRO || tokenAtual.tipo == TipoToken.NUMERO_REAL) {
			verificarNumero();				// <numero>
		} else if (tokenAtual.tipo == TipoToken.IDENTIFICADOR) {
			consumir(TipoToken.IDENTIFICADOR);  // <identificador>	
		} else {
			throw new RuntimeException("Erro de sintaxe: Esperado um valor ou identificador " + tokenAtual.tipo);
		}
	}
	
	//<chamada_funcao> ::= <identificador> <abre_parentese> ( <lista_argumentos> )? <fecha_parentese> <fim_instrucao>
	public void verificarComandoChamadaFuncao() {
		consumir(TipoToken.IDENTIFICADOR);	// <identificador>
		consumir(TipoToken.ABRE_PARENTESE);	// <abre_parentese>
		if (tokenAtual.tipo == TipoToken.NUMERO_INTEIRO || tokenAtual.tipo == TipoToken.NUMERO_REAL || 
				tokenAtual.tipo == TipoToken.IDENTIFICADOR) {	// se tiver expressao
			verificarListaArgumentos();		// <lista_argumentos>	
		}
		consumir(TipoToken.FECHA_PARENTESE);// <fecha_parentese>
		consumir(TipoToken.FIM_INSTRUCAO);	// <fim_instrucao>		
	}
	
	//<lista_argumentos> ::= <expressao> ( <separador> <expressao> )*
	public void verificarListaArgumentos() {
		verificarExpressao();
		
		// Verifica argumentos adicionais, se houver
		while (tokenAtual.tipo == TipoToken.SEPARADOR) {  // se tiver separador, considera-se que há mais argumentos		
			consumir(TipoToken.SEPARADOR);		// <separador>	
			verificarExpressao();				// <expressao>
		}
	}
	
	// <comando_retorno> ::= <instrucao_retorno> <espaco> ( <numero_inteiro> | <identificador> ) <fim_instrucao>
	public void verificarComandoRetorno() {
		consumir(TipoToken.INSTRUCAO_RETORNO);	// <instrucao_retorno>
		consumir(TipoToken.ESPACO);				// <espaco>
		
		if (tokenAtual.tipo == TipoToken.NUMERO_INTEIRO) {
			consumir(TipoToken.NUMERO_INTEIRO); // <numero_inteiro>
		} else if (tokenAtual.tipo == TipoToken.IDENTIFICADOR) {
			consumir(TipoToken.IDENTIFICADOR);	// <identificador> 
		} else {
			throw new RuntimeException("Erro de sintaxe: Esperado um valor ou identificador " + tokenAtual.tipo);
		}	
		
		consumir(TipoToken.FIM_INSTRUCAO);		// <fim_instrucao>
	}
	
	// <numero> ::=  <numero_inteiro> | <numero_real>
	public void verificarNumero() {
		if (tokenAtual.tipo == TipoToken.NUMERO_INTEIRO) {
			consumir(TipoToken.NUMERO_INTEIRO);	// <numero_inteiro>
		} else if (tokenAtual.tipo == TipoToken.NUMERO_REAL) {
			consumir(TipoToken.NUMERO_REAL);	// <numero_real>	
		} else {
			throw new RuntimeException("Erro de sintaxe: Esperado um numero inteiro ou real " + tokenAtual.tipo);
		}
	}	
}

// Classe principal do Analisador Sintático
public class AnalisadorSintatico {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Uso: java AnalisadorSintatico <nome-do-arquivo-gerado-pelo-lexico>");
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
				
		SeparadorTokens sep = new SeparadorTokens(entrada);
		List<Token> tokens = sep.separador();

		//for(Token token: tokens)
		//	System.out.println(token.tipo + " " + token.valor);
			
		RegrasSintaticas parser = new RegrasSintaticas(tokens);
		try {
			parser.verificarPrograma();
			System.out.println("Programa analisado com sucesso!");
		} catch (RuntimeException e) {
			System.out.println("Erro: " + e.getMessage());
		}			
	}
}