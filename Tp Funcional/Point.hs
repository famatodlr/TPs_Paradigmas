module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP x y =  Poi x y

resta :: Point -> Point -> Point
resta (Poi x1 y1) (Poi x2 y2)=  Poi (x1 - x2) (y1 - y2)

modulo :: Point -> Float
modulo (Poi x y) = sqrt (fromIntegral (x^2 + y^2))

difP :: Point -> Point -> Float  -- distancia absoluta
difP p1 p2 = modulo (resta p1 p2)