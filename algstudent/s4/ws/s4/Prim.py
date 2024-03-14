import Helper as hp
import heapq

filename = "graph8.txt"

visitedNodes = []

def searchForLowerValue(m):
    minValue = 3000000
    minIndex = -1
    for node in visitedNodes:
        for i in range(len(m[node])):
            evalVal = m[node][i]
            if(i not in visitedNodes and evalVal < minValue and evalVal != 0):
                minValue = evalVal
                minIndex = i
            evalVal = m[i][node]
            if(i not in visitedNodes and evalVal < minValue and evalVal != 0):
                minValue = evalVal
                minIndex = i

    visitedNodes.append(minIndex)
    return minValue
    
    
def prim(m):
    minCost = 0
    visitedNodes.append(0)
    while(len(visitedNodes) < len(m[0])):
        minValue = searchForLowerValue(m)
        minCost += minValue
        
    return minCost


def primHeap(m):
    minCost = 0
    visitedNodes = set()
    edges = [(0,0)]
    while edges:
        weight, node = heapq.heappop(edges)
        
        if node not in visitedNodes:
            minCost += weight
            visitedNodes.add(node)
            for index in range(len(m[node])):
                if m[node][index] > 0:
                    heapq.heappush(edges, (m[node][index], index))
                if m[index][node] > 0:
                    heapq.heappush(edges, (m[index][node], index))
        
    return minCost
    
probeMatrix = hp.triangularMatrixFromFile("graph256.txt")

result = primHeap(probeMatrix)
print(result)