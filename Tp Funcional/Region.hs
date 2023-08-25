module Region ( Region(Reg), newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import City
import Quality
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel] deriving (Eq, Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) city | not (elem city cities) =  Reg (cities ++ [city]) links tunnels
                                       | otherwise = Reg cities links tunnels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) city1 city2 quality | elem city1 cities && elem city2 cities = if not (elem (newL city1 city2 quality) links) 
                                                                                                then Reg cities (links ++ [newL city1 city2 quality]) tunnels
                                                                                                else Reg cities links tunnels
                                                     | otherwise = Reg cities links tunnels

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
connectedR (Reg cities links tunnels) city1 city2 = any (connectsT city1 city2) tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunnels) city1 city2 = any (linksL city1 city2) links

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
availableCapacityForR (Reg cities links tunnels) city1 city2 = capacityL link - contarTrues (buscarLinkEnTuneles link tunnels)
   where link = buscarLink links city1 city2