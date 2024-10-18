{- 
	Faça uma função que calcule o coeficiente binomial de (m,n).
	C(m,n) é o número de maneiras de escolher nelementos de um conjunto de m elementos.
	C(m,n)= m!/(n!(m−n)!)
-}
-- Função que calcula o fatorial de um número
fatorial :: Int -> Int
fatorial 0 = 1
fatorial n
    | n < 0     = error "Fatorial de número negativo não é definido."
    | otherwise = n * fatorial (n - 1)

-- Função que calcula o coeficiente binomial
coeficienteBinomial :: Int -> Int -> Int
coeficienteBinomial m n
    | n < 0 || n > m = 0  -- C(m, n) é 0 se n é negativo ou maior que m
    | otherwise      = fatorial m `div` (fatorial n * fatorial (m - n))

-- Exemplos de uso
main :: IO ()
main = do
    print (coeficienteBinomial 5 2)  -- 10
    print (coeficienteBinomial 10 3)  -- 120
    print (coeficienteBinomial 6 0)   -- 1
    print (coeficienteBinomial 6 6)   -- 1
    print (coeficienteBinomial 5 7)   -- 0
