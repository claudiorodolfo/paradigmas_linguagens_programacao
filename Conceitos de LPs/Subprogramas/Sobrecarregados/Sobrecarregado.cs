//C Sharp

using System;

class Sobrecarregado {
    public void Imprimir(string s) {
        Console.WriteLine(s);
    }

    public void Imprimir(int i) {
        Console.WriteLine(i);
    }
}

class Program {
    static void Main() {
        Sobrecarregado p = new Sobrecarregado();
        p.Imprimir("Hello");  // chama o método que aceita string
        p.Imprimir(10);       // chama o método que aceita int
    }
}
