// C Sharp

using System;
using System.Threading.Tasks;

class Corrotinas
{
    static async Task Tarefa1()
    {
        for (int i = 0; i < 3; i++)
        {
            Console.WriteLine($"Tarefa 1 - execução {i + 1}");
            await Task.Delay(1000);
        }
    }

    static async Task Tarefa2()
    {
        for (int i = 0; i < 2; i++)
        {
            Console.WriteLine($"Tarefa 2 - execução {i + 1}");
            await Task.Delay(2000);
        }
    }

    static async Task Main(string[] args)
    {
        await Task.WhenAll(Tarefa1(), Tarefa2());
    }
}
