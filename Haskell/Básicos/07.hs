{- 
	Faça uma função que receba um ângulo a e retorne uma tupla contendo o seno da metade desse ângulo utilizando a identidade +- sqrt((1 - cos x)/2):
-}
import Prelude
import Data.Tuple

-- Função que calcula o seno da metade do ângulo usando a identidade trigonométrica
senoMetadeAngulo :: Floating a => a -> (a, a)
senoMetadeAngulo a = (a, sqrt ((1 - cos a) / 2))


-- Função principal para testar
main :: IO ()
main = do
    print (senoMetadeAngulo 60) -- (60.0,0.9880316240928618)
    print (senoMetadeAngulo 90) -- (90.0,0.8509035245341184)
