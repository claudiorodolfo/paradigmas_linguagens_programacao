{- 
	Crie uma lista de anos bissextos desde o ano 1 até o atual.
-}
isBissexto :: Int -> Bool
isBissexto ano
    | ano `mod` 400 == 0 = True
    | ano `mod` 100 == 0 = False
    | ano `mod` 4 == 0 = True
    | otherwise = False
