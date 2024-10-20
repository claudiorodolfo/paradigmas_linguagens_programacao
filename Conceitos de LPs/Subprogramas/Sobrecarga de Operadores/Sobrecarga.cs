//C# (C Sharp_
using System;

class Ponto {
    public int x, y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Sobrecarga do operador +
    public static Ponto operator +(Ponto p1, Ponto p2) {
        return new Ponto(p1.x + p2.x, p1.y + p2.y);
    }
}

class Sobrecarga {
    static void Main(string[] args) {
        Ponto p1 = new Ponto(2, 3);
        Ponto p2 = new Ponto(4, 5);
        // Usando o operador + sobrecarregado
		Ponto p3 = p1 + p2;  

        Console.WriteLine($"p3 = ({p3.x}, {p3.y})");
    }
}
