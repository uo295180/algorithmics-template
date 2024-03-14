import random

def createMatrix(n,value):
    """Create an matrix in main memory
     (of order n), with equal elements
     to value. 
     In the end, the matrix is returned  """
    m=[]
    for i in range(n):
        m.append(n*[value])
    return m

def printMatrix(m):
    """Receives a matrix and prints it"""
    for i in range(len(m)):
        for j in range(len(m)):
            print(m[i][j],end="\t")
        print()
    print()

#m=createMatrix(4,0)
#printMatrix(m)

def triangularMatrixRandomIntegers(n,lower,higher):
    """Generates and returns a triangular matrix (i<j) of
     order n, with random integers between [lower..higher]"""
    m=createMatrix(n,0)
    for i in range(n):
        for j in range(i+1,n):
            m[i][j]=random.randint(lower,higher)
    return m

#m=triangularMatrixRandomIntegers(16,100,999)
#printMatrix(m)

def triangularMatrixFromFile(file):
    """Generates and returns a triangular matrix (i<j) that 
    is read from an input file, with the explained format"""
    fi=open(file,"r")
    n=int(fi.readline())
    m=createMatrix(n,0)
    i=0
    for line in fi:
        list=line.strip().split(",")
        k=0
        for j in range(i+1,n):
            m[i][j]=int(list[k])
            k=k+1
        i=i+1
    fi.close()
    return m

#m=triangularMatrixFromFile("graph8.txt")
#printMatrix(m)













