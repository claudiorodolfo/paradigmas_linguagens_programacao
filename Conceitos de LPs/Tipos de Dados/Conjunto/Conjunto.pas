//Pascal
program Conjunto;
uses SysUtils;

type
  TConjunto = set of 1..10;

var
  conjuntoA, conjuntoB, uniao, intersecao, diferenca: TConjunto;
  i: Integer;

begin
  // Definindo e inicializando conjuntos
  conjuntoA := [1, 2, 3, 4, 5];
  conjuntoB := [4, 5, 6, 7, 8];

  // União
  uniao := conjuntoA + conjuntoB;

  // Intersecção
  intersecao := conjuntoA * conjuntoB;

  // Diferença
  diferenca := conjuntoA - conjuntoB;

  // Exibindo resultados
  Write('União: ');
  for i := 1 to 10 do
    if i in uniao then Write(i, ' ');
  Writeln;

  Write('Intersecção: ');
  for i := 1 to 10 do
    if i in intersecao then Write(i, ' ');
  Writeln;

  Write('Diferença: ');
  for i := 1 to 10 do
    if i in diferenca then Write(i, ' ');
  Writeln;
end.
