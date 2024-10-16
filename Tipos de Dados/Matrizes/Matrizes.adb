-- Ada
-- Não tem suporte a slicing (fatias)

with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Matrizes is
   -- Definição da matriz com 2 linhas e 4 colunas
   type Type_Matriz is array (1 .. 2, 1 .. 4) of Integer;
   matriz : Type_Matriz;

begin
   -- Inicialização da matriz
   matriz(1, 1) := 1; matriz(1, 2) := 2; matriz(1, 3) := 3; matriz(1, 4) := 4;
   matriz(2, 1) := 5; matriz(2, 2) := 6; matriz(2, 3) := 7; matriz(2, 4) := 8;

   -- Exibir os elementos da matriz
   for i in 1 .. 2 loop
      for j in 1 .. 4 loop
         Put(Item => matriz(i, j), Width => 10); -- Exibir o valor com espaçamento de 10
      end loop;
      New_Line; -- Pular linha após exibir uma linha da matriz
   end loop;
end Matrizes;
