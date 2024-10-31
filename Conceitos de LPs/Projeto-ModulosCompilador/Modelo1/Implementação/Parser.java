//Compilar javac Parser.java
//Executar java Parser programa1.plp
//Executar java Parser programa2.plp
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

enum Estado {
    Q0,  // Estado inicial e de aceitação
    Q1,  // Após ler um identificador
    Q2,  // Após ler '='
    Q3,  // Após ler um número
    Q4,  // Após ler 'print'
    Q5   // Após ler um identificador para 'print'
}

public class Parser {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Parser <nome-do-arquivo>");
            return;
        }

        String nomeArquivo = args[0];
        String entrada = "";
 
        Parser p = new Parser();

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null)
                entrada += linha;
			
        } catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        boolean resultado = p.processar(entrada);
        System.out.println("Entrada " + (resultado ? "valida" : "invalida"));
    }

    private List<String> tokenizar(String entrada) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < entrada.length()) {
            char charAtual = entrada.charAt(i);

            if (Character.isLetter(charAtual)) {  // Identificador
                StringBuilder identificador = new StringBuilder();
                while (i < entrada.length() && Character.isLetter(entrada.charAt(i))) {
                    identificador.append(entrada.charAt(i));
                    i++;
                }
                tokens.add(identificador.toString());
            } else if (Character.isDigit(charAtual)) {  // Número
                StringBuilder numero = new StringBuilder();
                while (i < entrada.length() && Character.isDigit(entrada.charAt(i))) {
                    numero.append(entrada.charAt(i));
                    i++;
                }
                tokens.add(numero.toString());
            } else if (charAtual == '=' || charAtual == ';') {
                tokens.add(String.valueOf(charAtual));
                i++;
            } else if (i + 5 <= entrada.length() && entrada.substring(i, i + 5).equals("print")) {  // Palavra-chave 'print'
                tokens.add("print");
                i += 5;
            } else {
                i++;
            }
        }
        return tokens;
    }

    private Estado transitar(Estado estado, String token) {
        switch (estado) {
            case Q0:
                if (token.equals("print")) { 					//Palavra reservada print 
                    return Estado.Q4;
                } else if (Character.isLetter(token.charAt(0))){// Identificador
                    return Estado.Q1;
                }
                break;
            case Q1:
                if (token.equals("=")) {
                    return Estado.Q2;
                }
                break;
            case Q2:
                if (Character.isDigit(token.charAt(0))) {  // Número
                    return Estado.Q3;
                }
                break;
            case Q3:
                if (token.equals(";")) {  // Final de instrução de atribuição
                    return Estado.Q0;
                }
                break;
            case Q4:
                if (Character.isLetter(token.charAt(0))) {  // Identificador para print
                    return Estado.Q5;
                }
                break;
            case Q5:
                if (token.equals(";")) {  // Final de instrução print
                    return Estado.Q0;
                }
                break;
            default:
                return null;
        }
        return null;
    }

    private boolean processar(String entrada) {
        Estado estadoAtual = Estado.Q0;			//estado inicial
		Estado[] estadosFinais = {Estado.Q0};	//estados finais
		
        List<String> tokens = tokenizar(entrada);
        for (String token : tokens) {
            estadoAtual = transitar(estadoAtual, token);
            if (estadoAtual == null)
                return false;
        }
		
		//se parou num estado final, o código-fonte é bem formado
		for (Estado estadoFinal : estadosFinais) {
            if (estadoAtual == estadoFinal)
				return true;
        }
		return false;
    }
}