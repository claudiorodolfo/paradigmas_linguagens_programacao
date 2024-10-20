//Pascal
program CadeiaCaracteres;

var
    str1, str2, concatenado, sub: string;
    iguais: boolean;

begin
    str1 := 'Ola';
    str2 := 'Mundo';

    // Concatenar
    concatenado := str1 + ' ' + str2;
    writeln('Concatenado: ', concatenado);

    // Substring
    sub := Copy(concatenado, 1, 3);
    writeln('Substring: ', sub);

    // Comparar strings
    iguais := str1 = str2;
    writeln('As strings são iguais? ', iguais);

    // Tamanho da string
    writeln('Tamanho de str1: ', Length(str1));
end.
