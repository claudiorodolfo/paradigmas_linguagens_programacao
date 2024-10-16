//Java
public class Primitivas {
    public static void main(String[] args) {
        byte inteiroPequeno = 100;              // Inteiro pequeno (1 byte)
        int inteiro = 1000;                     // Inteiro (4 bytes)
        long inteiroGrande = 1000000L;          // Inteiro grande (8 bytes)
        float pontoFlutuanteSimples = 3.14f;    // Ponto flutuante simples (4 bytes)
        double pontoFlutuanteDuplo = 3.14159265359; // Ponto flutuante de dupla precisão (8 bytes)
        boolean booleano = true;                // Booleano
        char caractere = 'A';                   // Caractere

        System.out.println("Inteiro pequeno: " + inteiroPequeno);
        System.out.println("Inteiro: " + inteiro);
        System.out.println("Inteiro grande: " + inteiroGrande);
        System.out.println("Ponto flutuante simples: " + pontoFlutuanteSimples);
        System.out.println("Ponto flutuante de dupla precisão: " + pontoFlutuanteDuplo);
        System.out.println("Booleano: " + booleano);
        System.out.println("Caractere: " + caractere);
    }
}
