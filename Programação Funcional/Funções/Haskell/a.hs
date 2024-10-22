{- 
    A função média recebe dois parâmetros do tipo Double e retorna um Double que é a média aritmética dos valores de entrada.
-}
media :: Double -> Double -> Double
media x y = (x + y) / 2.0

-- Exemplos de teste
main :: IO ()
main = do
    -- Teste
    print (media 10 15)
    print (media 20 30)