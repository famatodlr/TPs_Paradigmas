import Point
import City
import Quality
import Link
import Tunel

-- import Region

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
l4 = newL c2 c1 q1

t1 = newT [l1, l2, l3]

-- r1 = newR [c1, c2, c3, c4] [l1, l2, l3, l4] [t1]

prueba = [difP p1 p2 == 1.4142135,
          nameC c1 == "c1",
          distanceC c1 c2 == 1.4142135,
          capacityQ q1 == 1,
          delayQ q1 == 1.0,
          connectsL c1 l1,
          connectsL c2 l1,
          linksL c1 c2 l1,
          capacityL l1 == 1,
          delayL l1 == 1.0,
          connectsT c1 c4 t1,
          connectsT c4 c1 t1,
          usesT l1 t1,
          usesT l4 t1,
          delayT t1 == 6.0]