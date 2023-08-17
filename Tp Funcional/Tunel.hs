module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT l = Tun l

sacar_elemento :: [a] -> a
sacar_elemento [x] = x

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun lista) = (connectsL c1 (sacar_elemento (take 1 lista))) && (connectsL c2 (sacar_elemento (drop ((length lista) - 1) lista))) || (connectsL c2 (sacar_elemento (take 1 lista))) && (connectsL c1 (sacar_elemento (drop ((length lista) - 1) lista)))

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun lista) = elem link lista

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun lista) = sum (map delayL lista)