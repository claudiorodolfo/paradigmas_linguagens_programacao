-- Ada
with Ada.Text_IO; use Ada.Text_IO;

procedure Exemplo_Ponteiro is
   Ponteiro : access Integer;  -- Ponteiro para um inteiro
   Valor : Integer;

begin
   New(Ponteiro);            -- Aloca memória para o inteiro

   Put("Informe um valor inteiro: ");
   Get(Valor);
   Ponteiro^ := Valor;       -- Atribui o valor ao ponteiro
   -- Atribuição do endereço da variável 'Valor' ao ponteiro
   Ponteiro := new Integer'(Valor); -- O ponteiro agora aponta para o endereço de 'Valor'

   -- Exibindo o valor através do ponteiro
   Put_Line("O valor armazenado no ponteiro é: " & Integer'Image(Ponteiro^));
   -- Exibindo o endereço da variável apontada pelo ponteiro
   Put_Line("O endereço da variável Valor é: " & Integer'Image(Integer'Address(Ponteiro)));
   
   -- Alterando o valor através do ponteiro
   Ponteiro^ := Ponteiro^ + 10;
   Put_Line("O novo valor armazenado no ponteiro é: " & Integer'Image(Ponteiro^));

   Dispose(Ponteiro);        -- Liberando a memória
end Exemplo_Ponteiro;
