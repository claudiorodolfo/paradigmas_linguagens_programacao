{- 
	Faça um programa que retorne True caso a entrada seja menor que -1 ou (maior que 1 E múltiplo de 2), e False caso contrário.
-}
condicao :: Int -> Bool
condicao x = (x < -1) || (x > 1 && x `mod` 2 == 0)
