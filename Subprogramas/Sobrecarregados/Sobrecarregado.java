//Java

class Sobrecarregado {
    void imprimir(String s) {
        System.out.println(s);
    }

    void imprimir(int i) {
        System.out.println(i);
    }
}

public class Main {
    public static void main(String[] args) {
        Sobrecarregado p = new Sobrecarregado();
        p.imprimir("Hello");  // chama o método que aceita String
        p.imprimir(10);       // chama o método que aceita int
    }
}