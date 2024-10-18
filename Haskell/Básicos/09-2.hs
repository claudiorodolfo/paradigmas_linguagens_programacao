{- 
	Encontre os 10 últimos anos bissextos (dica: use a função length para determinar o tamanho da lista).
-}
-- Função que verifica se um ano é bissexto
isBissexto :: Int -> Bool
isBissexto ano
    | ano `mod` 400 == 0 = True
    | ano `mod` 100 == 0 = False
    | ano `mod` 4 == 0 = True
    | otherwise = False

-- Função que gera a lista de anos bissextos desde o ano 1 até o ano atual
anosBissextos :: [Int]
anosBissextos = filter isBissexto [1..anoAtual]
  where anoAtual = 2024  -- Substituir por uma função para obter o ano atual, se disponível

-- Função que encontra os 10 últimos anos bissextos
ultimos10AnosBissextos :: [Int]
ultimos10AnosBissextos = reverse (take 10 (reverse anosBissextos))

-- Função principal para exibir os 10 últimos anos bissextos
main :: IO ()
	main = print ultimos10AnosBissextos