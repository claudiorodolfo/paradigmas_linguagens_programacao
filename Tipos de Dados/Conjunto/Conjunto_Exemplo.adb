-- Ada 

with Ada.Text_IO; use Ada.Text_IO;
with Ada.Set_IO;

procedure Conjunto_Exemplo is
   -- Definindo o tipo de conjunto
   type Conjunto is set of 1 .. 10;
   conjunto_a, conjunto_b, uniao, intersecao, diferenca: Conjunto;

begin
   -- Inicializando conjuntos
   conjunto_a := [1, 2, 3, 4, 5];
   conjunto_b := [4, 5, 6, 7, 8];

   -- União
   uniao := conjunto_a + conjunto_b;

   -- Intersecção
   intersecao := conjunto_a * conjunto_b;

   -- Diferença
   diferenca := conjunto_a - conjunto_b;

   -- Exibindo resultados
   Put_Line("União: ");
   Set_IO.Put(uniao);
   New_Line;

   Put_Line("Intersecção: ");
   Set_IO.Put(intersecao);
   New_Line;

   Put_Line("Diferença: ");
   Set_IO.Put(diferenca);
   New_Line;
end Conjunto_Exemplo;
