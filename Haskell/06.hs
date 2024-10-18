{- 
	Faça uma função que receba um ângulo a e retorne uma tupla contendo o seno da metade desse ângulo utilizando a identidade:
-}
import Prelude
import Data.Tuple

-- Função que calcula o seno da metade do ângulo usando a identidade trigonométrica
senoMetadeAngulo :: Floating a => a -> (a, a)
senoMetadeAngulo a = (a, sqrt ((1 - cos a) / 2))