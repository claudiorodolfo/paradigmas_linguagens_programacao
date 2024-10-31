{- 
	Crie uma função que some todos os elementos de uma lista utilizando recursão.
-}
somaLista :: [Int] -> Int
somaLista [] = 0
somaLista (x:xs) = x + somaLista xs

-- Função principal para testar
main :: IO ()
main = do
    let resultado = somaLista [1,2,3,4,5,6,7,8,9]
    putStrLn ("Resultado: " ++ show resultado)
--    print (somaLista [1,2,3,4,5,6,7,8,9])