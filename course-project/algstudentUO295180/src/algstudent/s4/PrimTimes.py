import Prim as pr
import Helper as hp
import time

def primSize():
    n = 256
    while n < 100000000:
        m = hp.triangularMatrixRandomIntegers(n,100,999)
        start = time.time_ns()
        pr.primHeap(m)
        end = time.time_ns()
        print("n = ", n, "\ttime = ", end-start)
        n *= 2
        
primSize()