-- Ada
procedure Imprimir(X : Integer) is
begin
   Ada.Text_IO.Put_Line(Integer'Image(X));
end Imprimir;

procedure Imprimir(X : String) is
begin
   Ada.Text_IO.Put_Line(X);
end Imprimir;

begin
   Imprimir(10);       -- chama o Imprimir que aceita Integer
   Imprimir("Hello");  -- chama o Imprimir que aceita String
end;
