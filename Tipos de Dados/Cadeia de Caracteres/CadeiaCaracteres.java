//Java
public class CadeiaCaracteres {
    public static void main(String[] args) {
        String str1 = "Olá";
        String str2 = "Mundo";

        // Concatenar
        String concatenado = str1 + " " + str2;
        System.out.println("Concatenado: " + concatenado);

        // Substring
        String sub = concatenado.substring(0, 3);
        System.out.println("Substring: " + sub);

        // Comparar strings
        boolean iguais = str1.equals(str2);
        System.out.println("As strings são iguais? " + iguais);

        // Tamanho da string
        System.out.println("Tamanho de str1: " + str1.length());
    }
}
