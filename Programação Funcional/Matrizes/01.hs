{- 
	Faça uma função que gere uma matriz identidade de tamanho n.
	Uma matriz identidade é uma matriz quadrada onde todos os elementos da diagonal principal são iguais a 1 e todos os outros elementos são iguais a 0. 
-}
-- Função que gera uma matriz identidade de tamanho n
matrizIdentidade :: Int -> [[Int]]
matrizIdentidade n = [[if i == j then 1 else 0 | j <- [0..n-1]] | i <- [0..n-1]]

-- Função para exibir a matriz de forma legível
imprimirMatriz :: [[Int]] -> IO ()
imprimirMatriz matriz = mapM_ (putStrLn . unwords . map show) matriz

-- Exemplos de uso
main :: IO ()
main = do
    let n = 4
    putStrLn $ "Matriz Identidade de tamanho " ++ show n ++ ":"
    imprimirMatriz (matrizIdentidade n)
