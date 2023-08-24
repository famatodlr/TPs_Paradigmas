module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City
import Quality
import Link ( Link, newL, connectsL, delayL)

newtype Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

esPrimero :: City -> [Link] -> Bool
esPrimero ciudad lista | length lista > 1 = connectsL ciudad (head (take 2 lista)) && not (connectsL ciudad (last (take 2 lista)))
                       | length lista == 1 = connectsL ciudad (head lista)
                       | otherwise = False

esUltimo :: City -> [Link] -> Bool
esUltimo ciudad lista | length lista > 1 = connectsL ciudad (last (drop (length lista - 2) lista)) && not (connectsL ciudad (head (drop (length lista - 2) lista)))
                      | length lista == 1 = connectsL ciudad (last lista)
                      | otherwise = False

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun lista) = esPrimero city1 lista && esUltimo city2 lista || esPrimero city2 lista && esUltimo city1 lista

usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT link (Tun links) = link `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun lista) = sum (map delayL lista)