{- 
	Implemente uma função que faz a multiplicação etíope entre dois números.
	A multiplicação etíope é um método de multiplicação que usa adição e duplicação para obter o resultado.
-}
multiplicacaoEtiopica :: Int -> Int -> Int
multiplicacaoEtiopica a b = multiplicar a b 0
  where
    multiplicar 0 _ acc = acc
    multiplicar x y acc
      | odd x     = multiplicar (x `div` 2) (y * 2) (acc + y) -- Adiciona y ao acumulador se x for ímpar
      | otherwise = multiplicar (x `div` 2) (y * 2) acc          -- Apenas divide x por 2 e dobra y

-- Exemplos de uso
main :: IO ()
main = do
    print (multiplicacaoEtiopica 3 4)   -- 12
    print (multiplicacaoEtiopica 5 6)   -- 30
    print (multiplicacaoEtiopica 7 8)   -- 56
    print (multiplicacaoEtiopica 10 20) -- 200
