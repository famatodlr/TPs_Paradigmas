module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city1 city2 quality = Lin city1 city2 quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city1 city2 quality) = city == city1 || city == city2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 (Lin city3 city4 _) = (city1 == city3 && city2 == city4) || (city1 == city4 && city2 == city3)

capacityL :: Link -> Int
capacityL (Lin city1 city2 quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin city1 city2 quality) = delayQ quality

position_in_Link :: City -> Link -> Int
position_in_Link city (Lin city1 city2 quality) = if connectsL city (Lin city1 city2 quality)
                                                  then if city == city1
                                                       then 1
                                                       else 2
                                                  else 0