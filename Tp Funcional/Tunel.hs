module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT link = Tun link

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun lista) = (position_in_Link city1 (head lista) == 1)  && (position_in_Link city2 (last lista) == 2) ||
                                    (position_in_Link city2 (head lista) == 1)  && (position_in_Link city1 (last lista) == 2)

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT (Lin city1 city2 _ ) (Tun lista) = elem True (map (linksL city1 city2) lista)

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun lista) = sum (map delayL lista)