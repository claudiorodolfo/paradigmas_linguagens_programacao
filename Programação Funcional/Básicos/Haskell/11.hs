{- 
	Crie um concatenador de strings que concatena duas strings separadas por espaço.
-}

-- Função que concatena duas strings com um espaço entre elas
concatenarStrings :: String -> String -> String
concatenarStrings str1 str2 = str1 ++ " " ++ str2

-- Função principal para testar o concatenador de strings
main :: IO ()
main = do
    let string1 = "Olá"
    let string2 = "Mundo"
    putStrLn (concatenarStrings string1 string2)
