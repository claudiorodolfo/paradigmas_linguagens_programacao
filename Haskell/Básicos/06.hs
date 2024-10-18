{- 
	Faça uma função que recebe um tipo Integer e retorna ele dividido por 2:
-}
dividePor2 :: Integer -> Integer
dividePor2 x = x `div` 2

-- Função principal para testar
main :: IO ()
main = do
    print (dividePor2 20)  -- Deve retornar 10
    print (dividePor2 21)  -- Deve retornar 10
