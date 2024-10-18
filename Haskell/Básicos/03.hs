{- 
	Faça uma função mult5 x que retorne True caso a entrada seja múltiplo de 5 e False caso contrário.
-}
mult5 :: Int -> Bool
mult5 x = x `mod` 5 == 0

-- Função principal para testar
main :: IO ()
main = do
    print (mult5 9)  -- Deve retornar False
    print (mult5 10) -- Deve retornar True