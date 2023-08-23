module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import City
import Quality
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) city = Reg (cities ++ [city]) links tunnels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) city1 city2 quality = Reg cities (links ++ [newL city1 city2 quality]) tunnels

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunnels) duplaCiudades = if connectedR (Reg cities links tunnels) city1 city2 ||linkedR (Reg cities links tunnels) city1 city2 
                                                | Reg cities links (tunnels ++ [newT duplaCiudades])
                                                |  else Reg cities links tunnels
                                                  where city1 = head duplaCiudades
                                                        city2 = last duplaCiudades




connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunnels) city1 city2 = all (connectsT city1 city2) tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunnels) city1 city2 = all (linksL city1 city2) links

buscarTunel :: [Tunel] -> City -> City -> Tunel
buscarTunel (tunel:tuneles) city1 city2 = if connectsT city1 city2 tunel then tunel else buscarTunel tuneles city1 city2

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunnels) city1 city2 = delayT (buscarTunel tunnels city1 city2)

buscarLink :: [Link] -> City -> City -> Link
buscarLink (link:links) city1 city2 = if linksL city1 city2 link then link else buscarLink links city1 city2

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunnels) city1 city2 = capacityL (buscarLink links city1 city2)

--diferencia entre lo que ocupe y lo que tenga disponible
-- capacidad ocupada = cantidad de tuneles
