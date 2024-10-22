{- 
	Faça uma função que calcule a persistência aditiva de um número. 
	A persistência aditiva de um número é o número de iterações necessárias para reduzir o número a um único dígito, somando seus dígitos em cada iteração. 
-}

-- Função que calcula a soma dos dígitos
somaDigitos :: Int -> Int
somaDigitos n
    | n < 0     = somaDigitos (-n) -- Se o número for negativo, converte para positivo
    | n == 0    = 0                 -- A soma dos dígitos de 0 é 0
    | otherwise = n `mod` 10 + somaDigitos (n `div` 10) -- Adiciona o último dígito e chama a função recursivamente

-- Função que calcula a persistência aditiva
persistenciaAditiva :: Int -> Int
persistenciaAditiva n = persistir n 0
  where
    persistir n cont
      | n < 10   = cont          -- Se n já é um dígito único, retorna o contador
      | otherwise = persistir (somaDigitos n) (cont + 1) -- Soma os dígitos e incrementa o contador

-- Exemplos de uso
main :: IO ()
main = do
    print (persistenciaAditiva 39)  -- 3
    print (persistenciaAditiva 999)  -- 4
    print (persistenciaAditiva 4)    -- 0
    print (persistenciaAditiva 123456) -- 2
