-- Ada
with Ada.Text_IO;         -- Biblioteca padrão para entrada/saída
with Ada.Integer_Text_IO; -- Para lidar com Inteiros
use Ada.Text_IO;

procedure Sobrecarregado is

    procedure Imprimir(X: Integer) is
    begin
        Ada.Integer_Text_IO.Put(X);
        New_Line;
    end Imprimir;

    procedure Imprimir(X: String) is
    begin
        Put(X);
        New_Line;
    end Imprimir;

begin
    Imprimir(10);         -- Chama o Imprimir que aceita Integer
    Imprimir("Hello");    -- Chama o Imprimir que aceita String
end Sobrecarregado;