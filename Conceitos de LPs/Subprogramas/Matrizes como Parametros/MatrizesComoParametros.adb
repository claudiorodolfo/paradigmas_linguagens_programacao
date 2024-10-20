-- Ada
-- Parametro Real: M
-- Parametro Formal: Matriz
-- Observe o in out no subprograma Dobrar_Matriz, indicando que a passagem de parametro é por valor-resultado

with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Matriz_Multidimensional is
   type Matriz_Type is array (1 .. 2, 1 .. 4) of Integer;
   M : Matriz_Type := ((1, 2, 3, 4), (5, 6, 7, 8));

   -- Subprograma para imprimir a matriz
   procedure Imprimir_Matriz(Matriz : Matriz_Type) is
   begin
      for I in 1 .. 2 loop
         for J in 1 .. 4 loop
            Put(Matriz(I, J)'Img);
            Put(" ");
         end loop;
         New_Line;
      end loop;
   end Imprimir_Matriz;

   -- Subprograma para dobrar os elementos da matriz
   procedure Dobrar_Matriz(Matriz : in out Matriz_Type) is
   begin
      for I in 1 .. 2 loop
         for J in 1 .. 4 loop
            Matriz(I, J) := Matriz(I, J) * 2;
         end loop;
      end loop;
   end Dobrar_Matriz;

begin
   -- Imprimir matriz antes de dobrar
   Put_Line("Antes de dobrar:");
   Imprimir_Matriz(M);

   -- Dobrar os valores da matriz
   Dobrar_Matriz(M);

   -- Imprimir matriz depois de dobrar
   Put_Line("Depois de dobrar:");
   Imprimir_Matriz(M);
end Matriz_Multidimensional;
