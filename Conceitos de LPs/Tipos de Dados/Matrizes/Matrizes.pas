//Pascal
//Não tem suporte a slicing (fatias)
program Matrizes;

var
    matriz: array[1..2, 1..4] of integer;
    i, j: integer;
begin
    // Definição e inicialização
    matriz[1,1] := 1; matriz[1,2] := 2; matriz[1,3] := 3; matriz[1,4] := 4;
    matriz[2,1] := 5; matriz[2,2] := 6; matriz[2,3] := 7; matriz[2,4] := 8;

    // Exibir os elementos da matriz
    for i := 1 to 2 do
    begin
        for j := 1 to 4 do
        begin
            Write(matriz[i, j]:10);
        end;
        Writeln;
    end;
end.
