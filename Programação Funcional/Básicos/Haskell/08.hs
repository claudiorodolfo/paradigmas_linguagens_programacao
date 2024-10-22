{- 
	Crie uma lista de anos bissextos desde o ano 1 até o atual.
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

-- Função principal para exibir a lista
main :: IO ()
	main = print anosBissextos