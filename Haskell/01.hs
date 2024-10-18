{- 
	Faça uma função mult3 x que retorne True caso a entrada seja múltiplo de 3 e False caso contrário.
-}
mult3 :: Int -> Bool
mult3 x = x `mod` 3 == 0
