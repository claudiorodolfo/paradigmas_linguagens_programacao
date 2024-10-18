{- 
	Encontre os 10 primeiros anos bissextos.
-}
-- Função que verifica se um ano é bissexto
isBissexto :: Int -> Bool
isBissexto ano
    | ano `mod` 400 == 0 = True
    | ano `mod` 100 == 0 = False
    | ano `mod` 4 == 0 = True
    | otherwise = False

-- Função que gera uma lista dos primeiros 10 anos bissextos
primeirosBissextos :: [Int]
primeirosBissextos = take 10 (filter isBissexto [1..])

-- Função principal para exibir os 10 primeiros anos bissextos
main :: IO ()
main = do
    print primeirosBissextos
