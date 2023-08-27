module Region ( Region(Reg), newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import City
import Quality
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel] deriving (Eq, Show)

newR :: Region
newR = Reg [] [] []

existeCiudad :: [City] -> City -> Bool
existeCiudad [] city = False
existeCiudad (city1:ciudades) city2 | distanceC city1 city2 == 0 = True
                                    | otherwise = existeCiudad ciudades city2

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) city | not (elem city cities) && not (existeCiudad cities city) =  Reg (cities ++ [city]) links tunnels
                                       | otherwise = Reg cities links tunnels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) city1 city2 quality | ciudadesEnRegion && noExisteLink && capacidadDisponible = Reg cities (links ++ [newL city1 city2 quality]) tunnels
                                                     | otherwise = Reg cities links tunnels
                                                     
   where ciudadesEnRegion =  elem city1 cities && elem city2 cities
         noExisteLink = not (elem (newL city1 city2 quality) links)
         capacidadDisponible = availableCapacityForR (Reg cities links tunnels) city1 city2 > 0

chequeoConectividad :: [Link] -> [City] -> [Link]
chequeoConectividad links [] = []
chequeoConectividad links (city:ciudades) | ciudades /= [] = [y | y <- links, connectsL city1 y && connectsL city2 y] ++ chequeoConectividad links ciudades
                                          | otherwise = []
   where city1 = city
         city2 = head ciudades

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunnels) ciudades | not (any (connectsT city1 city2) tunnels) = Reg cities links (tunnels ++ [nuevoTunel])
                                           | otherwise = Reg cities links tunnels
                                           
   where nuevoTunel = newT (chequeoConectividad links ciudades) 
         city1 = head ciudades
         city2 = last ciudades

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunnels) city1 city2 | elem city1 cities && elem city2 cities = any (connectsT city1 city2) tunnels
                                                  | otherwise = False

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunnels) city1 city2 | elem city1 cities && elem city2 cities = any (linksL city1 city2) links
                                               | otherwise = False

buscarTunel :: [Tunel] -> City -> City -> Tunel
buscarTunel (tunel:tuneles) city1 city2 | connectsT city1 city2 tunel = tunel 
                                        | otherwise =  buscarTunel tuneles city1 city2

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunnels) city1 city2 = delayT (buscarTunel tunnels city1 city2)

buscarLink :: [Link] -> City -> City -> Link
buscarLink (link:links) city1 city2 | linksL city1 city2 link = link 
                                    | otherwise = buscarLink links city1 city2
                                    
buscarLinkEnTuneles :: Link -> [Tunel] -> [Bool]
buscarLinkEnTuneles link [] = []
buscarLinkEnTuneles link (tunel:tuneles) = [usesT link tunel] ++ buscarLinkEnTuneles link tuneles

contarTrues :: [Bool] -> Int
contarTrues lista = sum [1 | y <- lista]

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunnels) city1 city2 | links /= [] = capacityL link - contarTrues (buscarLinkEnTuneles link tunnels)
                                                             | otherwise = 1
   where link = buscarLink links city1 city2