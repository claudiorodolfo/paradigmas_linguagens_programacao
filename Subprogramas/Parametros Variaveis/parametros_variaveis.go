//Go
package main

import "fmt"

func printNumbers(numbers ...int) {
    for _, number := range numbers {
        fmt.Println(number)
    }
}

func main() {
    // Chama a função com um número variável de parâmetros
    printNumbers(1, 2, 3, 4, 5)
}
