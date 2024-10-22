{- 
	Faça uma função que determine se um número é primo.
-}
isPrimo :: Int -> Bool
isPrimo n
    | n <= 1    = False -- Números menores ou iguais a 1 não são primos
    | otherwise = all (\x -> n `mod` x /= 0) [2..(floor . sqrt $ fromIntegral n)] -- Verifica se n não é divisível por nenhum número até a raiz quadrada de n

-- Exemplos de uso
main :: IO ()
main = do
    print (isPrimo 2)   -- True
    print (isPrimo 3)   -- True
    print (isPrimo 4)   -- False
    print (isPrimo 17)  -- True
    print (isPrimo 20)  -- False
    print (isPrimo 29)  -- True
