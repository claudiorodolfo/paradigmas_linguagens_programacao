-- Ada
with Ada.Text_IO;         use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Ada.Characters.Latin_1; use Ada.Characters.Latin_1;

procedure Primitivas is
   -- Tipos de dados
   type Unsigned_16 is mod 2**16;             -- Define um tipo sem sinal com 16 bits (0 a 65535)
   tipo_inteiro_pequeno : Short_Integer;      -- Inteiro pequeno
   tipo_inteiro         : Integer;            -- Inteiro
   tipo_inteiro_grande  : Long_Long_Integer;  -- Inteiro grande
   ponto_flutuante_simples : Float;           -- Ponto flutuante simples
   ponto_flutuante_duplo : Float;        -- Ponto flutuante de dupla precisão
   tipo_booleano        : Boolean;            -- Booleano
   tipo_caractere       : Character;          -- Caractere
   tipo_inteiro_sem_sinal : Unsigned_16;      -- Inteiro sem sinal
begin
   -- Atribuição de valores
   tipo_inteiro_pequeno := 100;
   tipo_inteiro := 1000;
   tipo_inteiro_grande := 1000000;
   ponto_flutuante_simples := 3.14;
   ponto_flutuante_duplo := 3.14159265359;
   tipo_booleano := True;
   tipo_caractere := 'A';
   tipo_inteiro_sem_sinal := 2000;

   -- Exibindo os valores
   Put_Line("Inteiro pequeno: " & Short_Integer'Image(tipo_inteiro_pequeno));
   Put_Line("Inteiro: " & Integer'Image(tipo_inteiro));
   Put_Line("Inteiro grande: " & Long_Long_Integer'Image(tipo_inteiro_grande));
   
   Put("Ponto flutuante simples: ");
   Put(ponto_flutuante_simples, Fore => 0, Aft => 2, Exp => 0);
   New_Line;

   Put("Ponto flutuante de dupla precisão: ");
   Put(ponto_flutuante_duplo, Fore => 0, Aft => 11, Exp => 0);  -- Exibe até 10 casas decimais
   New_Line;

   -- Imprimindo booleano diretamente
   if tipo_booleano then
      Put_Line("Booleano: True");
   else
      Put_Line("Booleano: False");
   end if;

   Put_Line("Caractere: " & Character'Image(tipo_caractere));
   
   Put_Line("Inteiro sem sinal: " & Unsigned_16'Image(tipo_inteiro_sem_sinal));

end Primitivas;
