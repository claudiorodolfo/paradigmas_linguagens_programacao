import java.util.ArrayList;
import java.util.List;

// Enum para representar os tipos de tokens na gramática
enum TipoToken {
    PRE_PROCESSADOR, BIBLIOTECA, ABRE_COL_ANG, FECHA_COL_ANG, EOF
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

    // <programa> ::= <list_preprocessador>
    public void verificarPrograma() {
        verificarListaPreProcessador();
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
}

// Classe principal do compilador
public class Compilador {
    public static void main(String[] args) {
        String entrada = "$PRE_PROC$ $ABR_COL_ANG$ $BIBLIO$ $FEC_COL_ANG$ $PRE_PROC$ $ABR_COL_ANG$ $BIBLIO$ $FEC_COL_ANG$";
        
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
