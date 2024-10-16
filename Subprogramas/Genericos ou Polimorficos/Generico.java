//Java

public class Generico {
    public static <T extends Comparable<T>> T maiorValor(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static void main(String[] args) {
        System.out.println("Maior entre 10 e 20: " + maiorValor(10, 20));
        System.out.println("Maior entre 3.14 e 2.71: " + maiorValor(3.14, 2.71));
    }
}
