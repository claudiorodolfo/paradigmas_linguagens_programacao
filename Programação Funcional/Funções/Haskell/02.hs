{- 
	Crie uma função tipoTriangulo que determina o tipo do triângulo formado pelos três lados x, y, z.
-}
tipoTriangulo :: Double -> Double -> Double -> String
tipoTriangulo x y z
    | x <= 0 || y <= 0 || z <= 0 = "Não é um triangulo"
    | x + y <= z || x + z <= y || y + z <= x = "Nao é um triangulo"
    | x == y && y == z = "Equilatero"
    | x == y || y == z || x == z = "Isosceles"
    | otherwise = "Escaleno"

-- Exemplos de uso
main :: IO ()
main = do
    print (tipoTriangulo 3 3 3)   -- "Equilátero"
    print (tipoTriangulo 3 4 3)   -- "Isósceles"
    print (tipoTriangulo 3 4 5)   -- "Escaleno"
    print (tipoTriangulo 1 2 3)   -- "Não é um triângulo"
