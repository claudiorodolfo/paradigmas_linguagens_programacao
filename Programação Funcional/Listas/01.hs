{- 
	Crie uma função divisivel20 x que retorna verdadeiro se x for divisível por todos os números de 1 a 20.
-}
-- Função que verifica se um número é divisível por todos os números de 1 a 20
divisivel20 :: Int -> Bool
divisivel20 x = all (\n -> x `mod` n == 0) [1..20]

-- Exemplos de uso
main :: IO ()
main = do
    print (divisivel20 232792560)  -- True (é divisível por todos os números de 1 a 20)
    print (divisivel20 20)         -- False (não é divisível por 3, 6, 7, 8, etc.)
    print (divisivel20 15)         -- False (não é divisível por 16, 17, 18, 19, 20)
    print (divisivel20 100)        -- False (não é divisível por 3, 7, 11, 13, etc.)
