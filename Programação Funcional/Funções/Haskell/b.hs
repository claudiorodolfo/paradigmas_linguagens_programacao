{- 
    Cálculo das raízes de uma equação do segundo grau, definida pelos valores de a, b, c
-}
raizSegGrau :: Double -> Double -> Double -> (Double, Double)
raizSegGrau a b c
  | delta < 0 = error "Raízes negativas!"
  | otherwise = (x1, x2)
  where
    x1 = (-b - sqrt delta) / (2*a)
    x2 = (-b + sqrt delta) / (2*a)
    delta = b**2 - 4*a*c

-- Exemplos de teste
main :: IO ()
main = do
    -- Teste com raízes reais
    print (raizSegGrau 1 (-3) 2)   -- Deverá retornar (1.0, 2.0)

    -- Teste com raízes iguais
    print (raizSegGrau 1 (-2) 1)   -- Deverá retornar (1.0, 1.0)

    -- Teste com erro de raízes negativas
    print (raizSegGrau 1 1 1)      -- Deverá lançar um erro "Raízes negativas!"
