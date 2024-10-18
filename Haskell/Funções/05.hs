{- 
	Faça uma função que calcule a soma dos dígitos de um número.
-}
somaDigitos :: Int -> Int
somaDigitos n
    | n < 0     = somaDigitos (-n) -- Se o número for negativo, converte para positivo
    | n == 0    = 0                -- A soma dos dígitos de 0 é 0
    | otherwise = n `mod` 10 + somaDigitos (n `div` 10) -- Adiciona o último dígito e chama a função recursivamente

-- Exemplos de uso
main :: IO ()
main = do
    print (somaDigitos 12345)  -- 15
    print (somaDigitos 9876)   -- 30
    print (somaDigitos 0)      -- 0
    print (somaDigitos (-456))  -- 15
