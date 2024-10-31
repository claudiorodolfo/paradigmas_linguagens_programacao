{- 
	Escreva uma função que aplique um filtro a uma lista de números, retornando apenas aqueles que são pares.
-}
filtrarPares :: [Int] -> [Int]
filtrarPares = filter (\x -> x `mod` 2 == 0)
--filtrarPares = filter even


-- Função principal para testar
main :: IO ()
main = do
    let resultado = filtrarPares [1,2,3,4,5,6,7,8,9]
    putStrLn ("Resultado: " ++ show resultado)
--    print (filtrarPares [1,2,3,4,5,6,7,8,9])
