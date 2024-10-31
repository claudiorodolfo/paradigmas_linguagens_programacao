// java FormatarCodigo programa1.c
// o comando acima gera um arquivo de saida chamado formatado_programa1.c
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class FormatarCodigo {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Uso: java FormatarCodigo <arquivo-entrada>");
			return;
		}
		String arquivoEntrada = args[0];

		StringBuilder codigoLido = new StringBuilder();

		// Lendo o conteúdo do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				linha = linha.trim(); // Remove espaços em excesso nas extremidades de cada linha
				
				// Eliminar linhas que começam com "//"
				if (!linha.startsWith("//")) {
					codigoLido.append(linha); // Remove espaços em excesso nas extremidades de cada linha
				}								
			}

			// Remover espaços, tabulações e quebras de linha desnecessárias
			String codigoFormatado = codigoLido.toString()
					.replaceAll("\\s+", " ")						// Substitui múltiplos espaços/tabs/enters por um único espaço
					.replaceAll("\\s*([{}();,+*/=<>-])\\s*", "$1")	// Remove espaços antes e depois de símbolos
					.replaceAll("\\)\\s*\\{", "){")					// Remove espaços entre ')' e '{'
					.replaceAll("\\{\\s*", "{")						// Remove espaços após '{'
					.replaceAll("\\}\\s*", "}");					// Remove espaços após '}'

			// Exibir o código formatado
			//System.out.println(codigoFormatado);
			// Escrever no arquivo de saída
			try (FileWriter writer = new FileWriter("formatado_"+arquivoEntrada)) {
				writer.write(codigoFormatado);
				System.out.println("Arquivo de saída gerado com sucesso!");
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}			
	}
}