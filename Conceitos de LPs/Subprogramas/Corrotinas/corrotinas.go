//GoLang

package main

import (
    "fmt"
    "time"
)

func tarefa1() {
    for i := 1; i <= 3; i++ {
        fmt.Printf("Tarefa 1 - execução %d\n", i)
        time.Sleep(1 * time.Second)
    }
}

func tarefa2() {
    for i := 1; i <= 2; i++ {
        fmt.Printf("Tarefa 2 - execução %d\n", i)
        time.Sleep(2 * time.Second)
    }
}

func main() {
    go tarefa1()
    go tarefa2()

    time.Sleep(5 * time.Second) // Aguarda a conclusão das corrotinas
}
