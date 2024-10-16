-- Lua
function funcao_externa()
    print("Esta é a função externa.")

    local function funcao_interna()
        print("Esta é a função interna.")
    end

    funcao_interna()  -- Chama a função interna
end

funcao_externa()  -- Chama a função externa
