//Pascal
program ExemploPonteiro;

var
  ponteiro: ^Integer;  // Ponteiro para um inteiro
  valor: Integer;

begin
  New(ponteiro);          // Inicializa o ponteiro

  Write('Informe um valor inteiro: ');
  ReadLn(valor);
  
  ponteiro^ := valor;     // Atribui o valor ao ponteiro
  // Atribuição do endereço da variável 'valor' ao ponteiro
  ponteiro := @valor;    // O ponteiro agora aponta para o endereço de 'valor'

  // Exibindo o valor através do ponteiro
  WriteLn('O valor armazenado no ponteiro é: ', ponteiro^);
  // Exibindo o endereço da variável apontada pelo ponteiro
  WriteLn('O endereço da variável valor é: ', ponteiro);
  
  // Alterando o valor através do ponteiro
  ponteiro^ := ponteiro^ + 10;
  WriteLn('O novo valor armazenado no ponteiro é: ', ponteiro^);

  Dispose(ponteiro);      // Liberando a memória
end.
