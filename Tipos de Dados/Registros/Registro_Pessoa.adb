-- Ada
with Ada.Text_IO;       use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded; -- Biblioteca para lidar com strings dinâmicos

procedure Registro_Pessoa is
   -- Definição do registro
   type Pessoa is record
      nome   : Ada.Strings.Unbounded.Unbounded_String;  -- String de tamanho dinâmico
      idade  : Integer;                                -- Idade como inteiro
      altura : Float;                                  -- Altura como ponto flutuante
   end record;

   -- Instância do registro
   p : Pessoa;

begin
   -- Atribuindo valores
   p.nome := Ada.Strings.Unbounded.To_Unbounded_String("Ana"); -- Atribuição de string
   p.idade := 28;
   p.altura := 1.65;

   -- Exibindo valores
   Put_Line("Nome: " & Ada.Strings.Unbounded.To_String(p.nome));
   Put_Line("Idade: " & Integer'Image(p.idade));
   Put("Altura: ");
   Put(p.altura, Fore => 0, Aft => 2);
   Put_Line(" m");
end Registro_Pessoa;
