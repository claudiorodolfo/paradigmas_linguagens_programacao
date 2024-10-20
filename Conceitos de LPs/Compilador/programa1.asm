; ETAPA 6: Código Assembly correspondente
; Testar em: https://www.ideone.com setando a linguagem: Assembler 64bit

section .data
    result_str db 'Resultado: ', 0    ; String de resultado
    num1 dq 3                         ; Primeira variável (3)
    num2 dq 5                         ; Segunda variável (5)
 
section .bss
    resultado resb 4                  ; Buffer para armazenar o resultado
 
section .text
    global _start
 
_start:
    ; Carregando os valores de num1 e num2 em registradores
    mov rax, [num1]                   ; Carrega o valor de num1 em rax
    add rax, [num2]                   ; Soma o valor de num2 a rax, rax agora contém a soma
 
    ; Convertendo o resultado em string
    mov rbx, resultado                ; Aponta para o buffer
    mov rcx, rax                      ; Copia o resultado para rcx
    call int_to_string                ; Converte o número em string
 
    ; Escrevendo "Resultado: " na tela
    mov rax, 1                        ; Chamada do sistema para write (sys_write)
    mov rdi, 1                        ; File descriptor (1 = stdout)
    mov rsi, result_str               ; String "Resultado: "
    mov rdx, 11                       ; Tamanho da string (11 bytes)
    syscall                           ; Faz a chamada do sistema
 
    ; Escrevendo o resultado da soma na tela
    mov rax, 1                        ; Chamada do sistema para write (sys_write)
    mov rdi, 1                        ; File descriptor (1 = stdout)
    mov rsi, resultado                ; Buffer com o resultado
    mov rdx, 4                        ; Tamanho da string
    syscall                           ; Faz a chamada do sistema
 
    ; Saída do programa
    mov rax, 60                       ; Chamada do sistema para exit (sys_exit)
    xor rdi, rdi                      ; Código de saída 0
    syscall                           ; Faz a chamada do sistema
 
; Subrotina para converter número em string (apenas para números pequenos)
int_to_string:
    add rcx, '0'                      ; Converte o número para o código ASCII
    mov [rbx], cl                     ; Armazena o número convertido no buffer
    mov byte [rbx + 1], 0             ; Termina a string com null
    ret