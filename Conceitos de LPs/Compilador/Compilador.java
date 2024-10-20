import java.util.ArrayList;
import java.util.List;

// Enum para representar os tipos de tokens na gramática
enum TipoToken {
    PRE_PROCESSADOR, 
	BIBLIOTECA, 
	ABRE_COLCHETE_ANGULADO, 
	FECHA_COLCHETE_ANGULADO,  
	TIPO, 
	IDENTIFICADOR, 
	ESPACO, 
	ABRE_PARENTESE, 
	FECHA_PARENTESE, 
	ABRE_CHAVE, 
	FECHA_CHAVE, 
	LISTA_PARAMETROS, 
	ATRIBUICAO, 
	EXPRESSAO, 
	FIM_INSTRUCAO, 
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
class AnalisadorLexico {
    private final String entrada;
    private int posicao = 0;

    // Construtor recebe a string de entrada
    public AnalisadorLexico(String entrada) {
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
            } else if (entrada.startsWith("$TIPO$", posicao)) {
                tokens.add(new Token(TipoToken.TIPO, "$TIPO$"));
                posicao += "$TIPO$".length();
            } else if (entrada.startsWith("$IDENT$", posicao)) {
                tokens.add(new Token(TipoToken.IDENTIFICADOR, "$IDENT$"));
                posicao += "$IDENT$".length();
            } else if (entrada.startsWith("$ESP$", posicao)) {
                tokens.add(new Token(TipoToken.ESPACO, "$ESP$"));
                posicao += "$ESP$".length();
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
            } else if (entrada.startsWith("@EXPRESSAO@", posicao)) {
                tokens.add(new Token(TipoToken.EXPRESSAO, "@EXPRESSAO@"));
                posicao += "@EXPRESSAO@".length();	
            } else if (entrada.startsWith("$FIN_INST$", posicao)) {
                tokens.add(new Token(TipoToken.FIM_INSTRUCAO, "$FIN_INST$"));
                posicao += "$FIN_INST$".length();					
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

// Analisador Sintático para verificar a estrutura dos tokens
class AnalisadorSintatico {
    private final List<Token> tokens;
    private int posicaoAtual = 0;
    private Token tokenAtual;

    public AnalisadorSintatico(List<Token> tokens) {
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

    // <programa> ::= <list_preprocessador> <definicao_funcao>
    public void verificarPrograma() {
        verificarListaPreProcessador();
        verificarDefinicaoFuncao();		
    }

    // <list_preprocessador> ::= <preprocessador> | <preprocessador> <list_preprocessador>
    public void verificarListaPreProcessador() {
        verificarPreProcessador();
		
        // Enquanto houver mais pré-processadores, continua processando a lista
        while (tokenAtual.tipo == TipoToken.PRE_PROCESSADOR) {
            verificarPreProcessador();
        }
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
        consumir(TipoToken.TIPO);               // <especificador_tipo>
        consumir(TipoToken.ESPACO);             // <espaco>
        consumir(TipoToken.IDENTIFICADOR);      // <identificador>
        consumir(TipoToken.ABRE_PARENTESE);     // <abre_parentese>
        consumir(TipoToken.LISTA_PARAMETROS);   // <lista_parametros>		
        consumir(TipoToken.FECHA_PARENTESE);    // <fecha_parentese>
        consumir(TipoToken.ABRE_CHAVE);         // <abre_chave>
        verificarListaComandos();				// <lista_comandos>			
        consumir(TipoToken.FECHA_CHAVE);        // <fecha_chave>
    }
	// <lista_comandos> ::= ( <comando> )*
    public void verificarListaComandos() {
		verificarComandoDeclaracaoAtribuicao();

        // Enquanto houver mais comandos, continua processando a lista
        while (tokenAtual.tipo == TipoToken.TIPO) {
            verificarComandoDeclaracaoAtribuicao();
        }		
	}
	
    // <comando_declaracao_atribuicao> ::= ( <especificador_tipo> <espaco> )? <identificador> <atribuicao> "@EXPRESSAO@" <fim_instrucao>
    public void verificarComandoDeclaracaoAtribuicao() {
        consumir(TipoToken.TIPO);               // <especificador_tipo>
        consumir(TipoToken.ESPACO);             // <espaco>
        consumir(TipoToken.IDENTIFICADOR);		// <identificador>
        consumir(TipoToken.ATRIBUICAO); 		// <atribuicao>
        consumir(TipoToken.EXPRESSAO);			// <expressao>
        consumir(TipoToken.FIM_INSTRUCAO);		// <fim_instrucao>
    }	
}

// Classe principal do compilador
public class Compilador {
    public static void main(String[] args) {
        String entrada = "$PRE_PROC$ $ABR_COL_ANG$ $BIBLIO$ $FEC_COL_ANG$ " +
						 "$PRE_PROC$ $ABR_COL_ANG$ $BIBLIO$ $FEC_COL_ANG$ " +
						 "$TIPO$ $ESP$ $IDENT$ $ABR_PAR$ @PARAMETROS@ $FEC_PAR$ $ABR_CHA$ " +
						 "$TIPO$ $ESP$ $IDENT$ $ATRIB$ @EXPRESSAO@ $FIN_INST$ " +
						 "$TIPO$ $ESP$ $IDENT$ $ATRIB$ @EXPRESSAO@ $FIN_INST$ " +
						 "$TIPO$ $ESP$ $IDENT$ $ATRIB$ @EXPRESSAO@ $FIN_INST$ " +						 
						 "$FEC_CHA$";
        
        AnalisadorLexico analizadorLexico = new AnalisadorLexico(entrada);
        List<Token> tokens = analizadorLexico.tokenizar();

		for(Token token: tokens)
			System.out.println(token.tipo);
			
        AnalisadorSintatico analizadorSintatico = new AnalisadorSintatico(tokens);
		try {
			analizadorSintatico.verificarPrograma();
			System.out.println("Programa analisado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }			
    }
}
