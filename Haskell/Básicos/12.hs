{- 
	Dada a string “0123456789”, crie uma lista com os dígitos em formato Integer.
-}

-- Função que converte uma string de dígitos em uma lista de inteiros
stringParaListaDeInteiros :: String -> [Integer]
stringParaListaDeInteiros str = map (\c -> read [c] :: Integer) str

-- Função principal para testar a conversão
main :: IO ()
main = do
    let str = "0123456789"
    let listaDeInteiros = stringParaListaDeInteiros str
    print listaDeInteiros
