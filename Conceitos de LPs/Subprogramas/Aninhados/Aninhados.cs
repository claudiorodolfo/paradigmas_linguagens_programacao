//C Sharp (C#)
using System;

class Aninhados
{
    static void MetodoExterno()
    {
        Console.WriteLine("Este é o método externo.");

        void MetodoInterno()
        {
            Console.WriteLine("Este é o método interno.");
        }

        MetodoInterno();  // Chama o método interno
    }

    static void Main()
    {
        MetodoExterno();  // Chama o método externo
    }
}
