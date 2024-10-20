import java.util.ArrayList;
import java.util.List;

// Enum para representar os tipos de tokens na gramática
enum TipoToken {
    PRE_PROCESSADOR, 
	BIBLIOTECA, 
	ABRE_COL_ANG, 
	FECHA_COL_ANG,  
	TIPO, 
	IDENTIFICADOR, 
	ESPACO, 
	ABRE_PARENT, 
	FECHA_PARENT, 
	ABRE_CHAVE, 
	FECHA_CHAVE, 
	LISTA_PARAMETROS, 
	LISTA_COMANDOS, 
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
                tokens.add(new Token(TipoToken.ABRE_COL_ANG, "$ABR_COL_ANG$"));
                posicao += "$ABR_COL_ANG$".length();
            } else if (entrada.startsWith("$FEC_COL_ANG$", posicao)) {
                tokens.add(new Token(TipoToken.FECHA_COL_ANG, "$FEC_COL_ANG$"));
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
                tokens.add(new Token(TipoToken.ABRE_PARENT, "$ABR_PAR$"));
                posicao += "$ABR_PAR$".length();
            } else if (entrada.startsWith("@PARAMETROS@", posicao)) {
                tokens.add(new Token(TipoToken.LISTA_PARAMETROS, "@PARAMETROS@"));
                posicao += "@PARAMETROS@".length();				
            } else if (entrada.startsWith("$FEC_PAR$", posicao)) {
                tokens.add(new Token(TipoToken.FECHA_PARENT, "$FEC_PAR$"));
                posicao += "$FEC_PAR$".length();
            } else if (entrada.startsWith("$ABR_CHA$", posicao)) {
                tokens.add(new Token(TipoToken.ABRE_CHAVE, "$ABR_CHA$"));
                posicao += "$ABR_CHA$".length();
            } else if (entrada.startsWith("@COMANDOS@", posicao)) {
                tokens.add(new Token(TipoToken.LISTA_COMANDOS, "@COMANDOS@"));
                posicao += "@COMANDOS@".length();					
            } else if (entrada.startsWith("$FEC_CHA$", posicao)) {
                tokens.add(new Token(TipoToken.FECHA_CHAVE, "$FEC_CHA$"));
                posicao += "$FEC_CHA$".length();				
            } else {
                throw new RuntimeException("Token inválido encontrado: " + entrada.charAt(posicao));
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
        consumir(TipoToken.PRE_PROCESSADOR);    // <inclusao>
        consumir(TipoToken.ABRE_COL_ANG);       // <abre_colche_ang>
        consumir(TipoToken.BIBLIOTECA);         // <biblioteca>
        consumir(TipoToken.FECHA_COL_ANG);      // <fecha_colche_ang>
    }

    // <definicao_funcao> ::= <especificador_tipo> <espaco> <identificador> <abre_parentese> <lista_parametros> <fecha_parentese> <abre_chave> <lista_comandos> <fecha_chave>
    public void verificarDefinicaoFuncao() {
        consumir(TipoToken.TIPO);               // <especificador_tipo>
        consumir(TipoToken.ESPACO);             // <espaco>
        consumir(TipoToken.IDENTIFICADOR);      // <identificador>
        consumir(TipoToken.ABRE_PARENT);        // <abre_parentese>
        consumir(TipoToken.LISTA_PARAMETROS);   // <lista_parametros>		
        consumir(TipoToken.FECHA_PARENT);       // <fecha_parentese>
        consumir(TipoToken.ABRE_CHAVE);         // <abre_chave>
        consumir(TipoToken.LISTA_COMANDOS);     // <lista_comandos>			
        consumir(TipoToken.FECHA_CHAVE);        // <fecha_chave>
    }	
}

// Classe principal do compilador
public class Compilador {
    public static void main(String[] args) {
        String entrada = "$PRE_PROC$ $ABR_COL_ANG$ $BIBLIO$ $FEC_COL_ANG$ $PRE_PROC$ $ABR_COL_ANG$ $BIBLIO$ $FEC_COL_ANG$"  +
			"$TIPO$ $ESP$ $IDENT$ $ABR_PAR$ @PARAMETROS@ $FEC_PAR$ $ABR_CHA$ @COMANDOS@ $FEC_CHA$";
        
        AnalisadorLexico analizadorLexico = new AnalisadorLexico(entrada);
        List<Token> tokens = analizadorLexico.tokenizar();

        AnalisadorSintatico analizadorSintatico = new AnalisadorSintatico(tokens);
		try {
			analizadorSintatico.verificarPrograma();
			System.out.println("Programa analisado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }			
    }
}
