{- 
	Crie uma função ehTriangulo que determina se três lados x, y, z podem formar um triângulo.
-}
-- Função que verifica se três lados podem formar um triângulo
ehTriangulo :: Float -> Float -> Float -> Bool
ehTriangulo x y z = (x + y > z) && (x + z > y) && (y + z > x)

-- Função principal para testar ehTriangulo
main :: IO ()
main = do
    print (ehTriangulo 3 4 5)    -- Deve retornar True
    print (ehTriangulo 1 2 3)    -- Deve retornar False
