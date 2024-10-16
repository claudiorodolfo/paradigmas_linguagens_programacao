-- Ada

with Ada.Text_IO; use Ada.Text_IO;

generic
   type T is private;
   with function ">" (Left, Right : T) return Boolean;
function Maior_Valor (A, B : T) return T;

function Maior_Valor (A, B : T) return T is
begin
   if A > B then
      return A;
   else
      return B;
   end if;
end Maior_Valor;

procedure Main is
   function Maior_Int is new Maior_Valor(Integer);
   function Maior_Float is new Maior_Valor(Float);
begin
   Put_Line("Maior entre 10 e 20: " & Integer'Image(Maior_Int(10, 20)));
   Put_Line("Maior entre 3.14 e 2.71: " & Float'Image(Maior_Float(3.14, 2.71)));
end Main;
