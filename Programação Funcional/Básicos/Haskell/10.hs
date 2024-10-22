{- 
	Crie uma tupla em que o primeiro elemento tem metade dos anos bissextos e o segundo elemento a outra metade.
-}

-- Função que verifica se um ano é bissexto
isBissexto :: Int -> Bool
isBissexto ano
    | ano `mod` 400 == 0 = True
    | ano `mod` 100 == 0 = False
    | ano `mod` 4 == 0   = True
    | otherwise           = False

-- Função que gera a lista de anos bissextos desde o ano 1 até o ano atual
anosBissextos :: [Int]
anosBissextos = filter isBissexto [1..anoAtual]
  where anoAtual = 2024  -- Substituir por uma função para obter o ano atual, se disponível

-- Função que divide a lista de anos bissextos em duas partes
divideAnosBissextos :: ([Int], [Int])
divideAnosBissextos = splitAt half anosBissextos
  where half = length anosBissextos `div` 2

-- Função principal para exibir a tupla com as duas metades
main :: IO ()
main = print divideAnosBissextos