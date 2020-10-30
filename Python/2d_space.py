# you have a list of tuples
# find the K closest points to the origin (0,0)
# e.g k = 2: two closest points

points = [[-2,4], [0,-2], [-1,0], [3,5], [-2,-3], [3,2]]
# find the closest points based on euclidean dist
# d = sqrt(x^2,y^2)

# equivalent to finding k smallest items
# sort: O(nlog(n))
# selection osrt: O(nk)
# Max Heap O(k+(n-k)log(k))

# max heap? It's an efficient way to keep track of the largest val
# in the given collection
# Max heap:
# Create -> O(k)
# Replace -> O(log(k))
# print all -> O(k)
# nums = [4,1,5,2,3,0,10]
from heapq import heappop, heappush, heapify 

class MaxHeap:
  def __init__(self):
    self.name = ""
    self.max = 0

  def getMax(self):
    return self.max
  

def closest(points, k):
  # using points create points_with_d (O(n))
  # using points_with_d, create a max heap with the first k items
  # call this max heap MH
  points_with_d = []
  MH = MaxHeap()
  for p in points_with_d:
    if p.distance < MH.getMax():
      print(1)
      # replace MH current max point with p
  # print all points in MH
