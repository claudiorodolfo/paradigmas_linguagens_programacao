//Java
//Java oferece suporte a enumerações, mas não a subfaixas.
public class Ordinais {
    enum DiaDaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }

    public static void main(String[] args) {
        DiaDaSemana hoje = DiaDaSemana.TERCA;

        // Exibindo valor ordinal
        System.out.println("Hoje é: " + hoje);

        // Usando a posição ordinal
        System.out.println("Posição ordinal: " + hoje.ordinal());

        // Comparação
        if (hoje == DiaDaSemana.TERCA) {
            System.out.println("Hoje é terça-feira.");
        }
    }
}
