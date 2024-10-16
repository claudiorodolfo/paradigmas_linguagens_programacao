//Pascal

program Generico;

uses
  sysutils;

generic function MaiorValor<T>(a, b: T): T;
begin
  if a > b then
    Result := a
  else
    Result := b;
end;

begin
  Writeln('Maior entre 10 e 20: ', specialize MaiorValor<Integer>(10, 20));
  Writeln('Maior entre 3.14 e 2.71: ', specialize MaiorValor<Double>(3.14, 2.71));
end.
