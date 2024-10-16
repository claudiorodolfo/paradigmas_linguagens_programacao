-- Ada
with Ada.Text_IO;
with Ada.Float_Text_IO;

procedure Uniao is
   type Forma_Tipo is (Circulo, Triangulo, Retangulo);
	-- A depender do momento o registro Forma vai ter possuir internamente ou um Circulo, ou um Triangulo, ou um Retangulo, selecionado via case..when, similar ao switch..case.   
   type Forma is record
      case Tipo : Forma_Tipo is
         when Circulo =>
            Raio : Float;
         when Triangulo =>
            Base, Altura : Float;
         when Retangulo =>
            Largura, Altura : Float;
      end case;
   end record;

   Forma : Forma;
   
begin
   -- Usando como Círculo
   Forma.Tipo := Circulo;
   Forma.Raio := 5.0;
   Ada.Float_Text_IO.Put_Line("Círculo com raio: " & Float'Image(Forma.Raio));
   
   -- Usando como Retângulo
   Forma.Tipo := Retangulo;
   Forma.Largura := 10.0;
   Forma.Altura := 20.0;
   Ada.Float_Text_IO.Put_Line("Retângulo com largura: " & Float'Image(Forma.Largura) & " e altura: " & Float'Image(Forma.Altura));
end Uniao;
