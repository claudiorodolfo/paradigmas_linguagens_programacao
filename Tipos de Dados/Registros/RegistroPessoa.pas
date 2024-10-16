//Pascal

program RegistroPessoa;

type
    Pessoa = record
        nome: string;
        idade: integer;
        altura: real;
    end;

var
    p: Pessoa;

begin
    // Atribuindo valores
    p.nome := 'Ana';
    p.idade := 28;
    p.altura := 1.65;

    // Exibindo valores
    writeln('Nome: ', p.nome);
    writeln('Idade: ', p.idade);
    writeln('Altura: ', p.altura:0:2, ' m');
end.
