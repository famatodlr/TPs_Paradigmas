module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import City
import Quality
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) city = Reg (city:cities) links tunnels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) city1 city2 quality = Reg cities (newL city1 city2 quality : links) tunnels

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunnels) connectar = Reg cities links (newT

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunnels) city1 city2 = all (connectsT city1 city2) tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
connectedR (Reg cities links tunnels) city1 city2 = all (linksL city1 city2) links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunnels) city1 city2 = 

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades