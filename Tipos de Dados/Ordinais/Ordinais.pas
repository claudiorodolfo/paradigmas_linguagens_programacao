//Pascal
//Em Pascal, tanto enumerações quanto subfaixas são suportadas.
//Pascal
//Em Pascal, tanto enumerações quanto subfaixas são suportadas.
program Ordinais;

type
    DiaDaSemana = (Segunda, Terca, Quarta, Quinta, Sexta, Sabado, Domingo);
    Nota = 1..10;  { Subfaixa de 1 a 10 }

var
    hoje: DiaDaSemana;
    minhaNota: Nota;

begin
    hoje := Terca;
    minhaNota := 8;

    // Exibindo valor ordinal
    writeln('Hoje é: ', Ord(hoje));

    // Usando a posição ordinal
    writeln('Posição ordinal: ', Ord(hoje));

    if hoje = Terca then
        writeln('Hoje é terça-feira.');

	// Verificar se a nota está dentro dos limites
	if (minhaNota >= 1) and (minhaNota <= 10) then
		writeln('A nota está dentro da subfaixa permitida.')
	else
		writeln('A nota está fora da subfaixa permitida.');
	
end.