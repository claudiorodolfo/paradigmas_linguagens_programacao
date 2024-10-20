//Pascal
program Primitivas;
var
    inteiroPequeno: shortint;      // Inteiro pequeno
    inteiro: integer;              // Inteiro
    inteiroGrande: int64;          // Inteiro grande
    pontoFlutuanteSimples: single; // Ponto flutuante simples
    pontoFlutuanteDuplo: double;   // Ponto flutuante de dupla precisão
    booleano: boolean;             // Booleano
    caractere: char;               // Caractere
    inteiroSemSinal: word;         // Inteiro sem sinal
begin
    inteiroPequeno := 100;
    inteiro := 1000;
    inteiroGrande := 1000000;
    pontoFlutuanteSimples := 3.14;
    pontoFlutuanteDuplo := 3.14159265359;
    booleano := true;
    caractere := 'A';
    inteiroSemSinal := 2000;

    writeln('Inteiro pequeno: ', inteiroPequeno);
    writeln('Inteiro: ', inteiro);
    writeln('Inteiro grande: ', inteiroGrande);
    writeln('Ponto flutuante simples: ', pontoFlutuanteSimples:0:2);
    writeln('Ponto flutuante de dupla precisão: ', pontoFlutuanteDuplo:0:10);
    writeln('Booleano: ', booleano);
    writeln('Caractere: ', caractere);
    writeln('Inteiro sem sinal: ', inteiroSemSinal);
end.
