//C Sharp (C#)

using System;

class Generico {
    public static T MaiorValor<T>(T a, T b) where T : IComparable<T> {
        return a.CompareTo(b) > 0 ? a : b;
    }

    static void Main() {
        Console.WriteLine("Maior entre 10 e 20: " + MaiorValor(10, 20));
        Console.WriteLine("Maior entre 3.14 e 2.71: " + MaiorValor(3.14, 2.71));
    }
}
