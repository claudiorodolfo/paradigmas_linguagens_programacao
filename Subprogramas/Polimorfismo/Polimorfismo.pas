//Pascal

program Polimorfismo;

procedure Imprimir(X: Integer);
begin
    writeln(X);
end;

procedure Imprimir(X: String);
begin
    writeln(X);
end;

begin
    Imprimir(10);       { chama o Imprimir que aceita Integer }
    Imprimir('Hello');  { chama o Imprimir que aceita String }
end.
