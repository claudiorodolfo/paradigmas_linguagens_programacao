//Pascal
program Aninhados;

    procedure ProcedimentoExterno;
        procedure ProcedimentoInterno;
        begin
            WriteLn('Este é o procedimento interno.');
        end;

    begin
        WriteLn('Este é o procedimento externo.');
        ProcedimentoInterno;  // Chama o procedimento interno
    end;

begin
    ProcedimentoExterno;  // Chama o procedimento externo
end.
