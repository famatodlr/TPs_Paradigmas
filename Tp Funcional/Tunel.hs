module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City
import Quality
import Link ( Link, newL, connectsL, delayL)

newtype Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun lista) = ((connectsL city1 (head (take 2 lista)) && not (connectsL city1 (last (take 2 lista)))) && 
                                    (connectsL city2 (last (drop (length lista - 2) lista)) && not (connectsL city2 (head (drop (length lista - 2) lista))))) ||
                                    ((connectsL city2 (head (take 2 lista)) && not (connectsL city2 (last (take 2 lista)))) &&
                                    (connectsL city1 (last (drop (length lista - 2) lista)) && not (connectsL city1 (head (drop (length lista - 2) lista)))))




equalLink :: Link -> Link
equalLink (Link city1 city2 quality) = Link city2 city1 quality

usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT link (Tun []) = False
usesT link (Tun links) = link `elem` links


delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun lista) = sum (map delayL lista)
