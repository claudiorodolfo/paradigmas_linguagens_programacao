//Pascal
//Parametro Real: M
//Parametro Formal: Matriz

program MatrizesComoParametro;

type
  Matriz_Type = array[1..2, 1..4] of Integer;

var
  M: Matriz_Type;

{ Subprograma para imprimir a matriz }
procedure ImprimirMatriz(Matriz: Matriz_Type);
var
  i, j: Integer;
begin
  for i := 1 to High(Matriz) do
  begin
    for j := 1 to High(Matriz[i]) do
    begin
      Write(Matriz[i, j]:4);  { O :4 alinha os números }
    end;
    Writeln;
  end;
end;

{ Subprograma para dobrar os elementos da matriz }
{ Passagem de Parâmetro por Referência }
procedure DobrarMatriz(var Matriz: Matriz_Type);
var
  i, j: Integer;
begin
  for i := 1 to High(Matriz) do
    for j := 1 to High(Matriz[i]) do
      Matriz[i][j] := Matriz[i][j] * 2;
end;

{ Subprograma para dobrar os elementos da matriz }
{ Passagem de Parâmetro por Valor }
{procedure DobrarMatriz(Matriz: Matriz_Type);
var
  i, j: Integer;
begin
  for i := 1 to High(Matriz) do
    for j := 1 to High(Matriz[i]) do
      Matriz[i][j] := Matriz[i][j] * 2;
end;}

begin
  { Inicializando a matriz com valores }
  M[1, 1] := 1; M[1, 2] := 2; M[1, 3] := 3; M[1, 4] := 4;
  M[2, 1] := 5; M[2, 2] := 6; M[2, 3] := 7; M[2, 4] := 8;

  Writeln('Antes de dobrar:');
  ImprimirMatriz(M);
  
  DobrarMatriz(M);
  
  Writeln('Depois de dobrar:');
  ImprimirMatriz(M);  
end.