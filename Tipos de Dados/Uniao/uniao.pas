//Pascal
program Uniao;

//A depender do momento o registro Forma vai ter possuir internamente ou um Circulo, ou um Triangulo, ou um Retangulo, selecionado via case, similar ao switch..case.
type
    TForma = record
        case Tipo: (Circulo, Triangulo, Retangulo) of
            Circulo: (Raio: Real);
            Triangulo: (Base, Altura: Real);
            Retangulo: (Largura, Altura: Real);
    end;

var
    Forma: TForma;

begin
    // Usando como Círculo
    Forma.Tipo := Circulo;
    Forma.Raio := 5.0;
    WriteLn('Círculo com raio: ', Forma.Raio:0:2);

    // Usando como Retângulo
    Forma.Tipo := Retangulo;
    Forma.Largura := 10.0;
    Forma.Altura := 20.0;
    WriteLn('Retângulo com largura: ', Forma.Largura:0:2, ' e altura: ', Forma.Altura:0:2);
end.
