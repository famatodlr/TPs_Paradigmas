import Point
import City
import Quality
import Link
import Tunel

p1 = newP 1 1
p2 = newP 2 2
p3 = newP 3 3
p4 = newP 4 4

c1 = newC "c1" p1
c2 = newC "c2" p2
c3 = newC "c3" p3
c4 = newC "c4" p4

q1 = newQ "q1" 1 1.0
q2 = newQ "q2" 2 2.0
q3 = newQ "q3" 3 3.0
q4 = newQ "q4" 4 4.0

l1 = newL c1 c2 q1
l2 = newL c2 c3 q2
l3 = newL c3 c4 q3
l4 = newL c4 c1 q4

t1 = newT [l1, l2, l3, l4]