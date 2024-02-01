from time import time
from sys import argv

def primoA1(m):
    """ returns whether m is prime or not """
    p = True
    for i in range (2,m):
        if m%i == 0:
            p = False
    return p

if __name__ == '__main__':
    n = int(argv[1]) #parameter introduced by user
    t1 = time()  #gives the time in seconds and with decimals (real)
    primoA1(n)
    t2 = time()
    print("n =", n, "***", "time =", int(1000*(t2-t1)), "milliseconds")

