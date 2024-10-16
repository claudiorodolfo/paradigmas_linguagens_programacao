-- Ada
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Ordinais is

   -- Definindo uma enumeração para os dias da semana
   type Dia_Da_Semana is (Segunda, Terca, Quarta, Quinta, Sexta, Sabado, Domingo);

   -- Definindo uma subfaixa de inteiros de 1 a 10
   subtype Nota is Integer range 1 .. 10;

   -- Variáveis
   Hoje : Dia_Da_Semana := Terca;
   Minha_Nota : Nota := 8;

begin
   -- Exibir o dia da semana atual
   Put_Line("Hoje é: " & Dia_Da_Semana'Image(Hoje));

   -- Obter a posição ordinal do valor (baseado no índice)
   Put("Posição ordinal de hoje: ");
   Put_Line(Integer'Image(Dia_Da_Semana'Pos(Hoje)));

   -- Exibir a nota
   Put("Minha nota: ");
   Put_Line(Integer'Image(Minha_Nota));

   -- Comparar o dia
   if Hoje = Terca then
      Put_Line("Hoje é terça-feira.");
   end if;

   -- Verificar se a nota está dentro dos limites
   if Minha_Nota in 1 .. 10 then
      Put_Line("A nota está dentro da subfaixa permitida.");
   else
      Put_Line("A nota está fora da subfaixa permitida.");
   end if;
end Ordinais;
