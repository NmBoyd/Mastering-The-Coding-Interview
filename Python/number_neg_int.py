# find the number of negative integers in a 
# row wise / column-wise sorted matrix

# [-3 -2 -1 1; -2 2 3 4; 4 5 7 8] --> 4
# the worst case is that you loop through everything
# we can abuse the sorted structure!!
# row 1: position of the last neg number is 2 -> 3
# row 2: lsat negative number is 0 -> 1
# row 4: non neg -> 0
# Complexity O(n+m)
import numpy as np
def function(M,n,m):
  count = 0
  i = 0
  j = m-1

  while j >= 0 and i < n:
    # print("looping ",j, " ", i)
    # if < 0 add the count based on the index and move row and column
    if M[i,j] < 0:
      count+=(j+1)
      i+=1
    # if > 0 move column
    else:
      j -= 1
  return count
arr = np.array([[-3, -2, -1, 1],[ -2, 2, 3, 4],[4, 5, 7, 8]])
print(arr.shape)
n = function(arr,3,4)
print(n)