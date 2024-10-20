-- Ada
-- Ada não tem co-rotinas nativas, mas tasks fornecem comportamento de concorrência.

with Ada.Text_IO; use Ada.Text_IO;
with Ada.Real_Time; use Ada.Real_Time;

procedure Corrotinas is

   task Tarefa1 is
      entry Start;
   end Tarefa1;

   task body Tarefa1 is
   begin
      for I in 1 .. 3 loop
         Put_Line("Tarefa 1 - execução " & Integer'Image(I));
         delay 1.0;
      end loop;
   end Tarefa1;

   task Tarefa2 is
      entry Start;
   end Tarefa2;

   task body Tarefa2 is
   begin
      for I in 1 .. 2 loop
         Put_Line("Tarefa 2 - execução " & Integer'Image(I));
         delay 2.0;
      end loop;
   end Tarefa2;

begin
   null;
end Corrotinas;
