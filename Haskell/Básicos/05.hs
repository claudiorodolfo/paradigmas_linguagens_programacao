{- 
	Faça um programa que retorne True caso a entrada seja menor que -1 ou (maior que 1 E múltiplo de 2), e False caso contrário.
-}
condicao :: Int -> Bool
condicao x = (x < -1) || (x > 1 && x `mod` 2 == 0)

-- Função principal para testar
main :: IO ()
main = do
    print (condicao (-3))  -- Deve retornar True
    print (condicao 4)   -- Deve retornar True
    print (condicao 5)   -- Deve retornar False
