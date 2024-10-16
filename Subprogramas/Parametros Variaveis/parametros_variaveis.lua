-- Lua
function printNumbers(...)
	-- Coloca todos os parâmetros em uma tabela
    local args = {...}  
    for i, number in ipairs(args) do
        print(number)
    end
end
-- Chama a função com parâmetros variáveis
printNumbers(1, 2, 3, 4, 5)  