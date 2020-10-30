# reorder the array randomly
# given rand() and floor(num)
# rand() provides a rand number between 0 and 1
# floor(2.88) -> 2
from random import *
import math
# don't brute force O(nlog(n) and go for O(n) instead

# brute force
size = 5
array = [None]*size
for i in range(5):
  array[i] = random()
print("initial ", array)

# randomize the randoms
for i in reversed(range(5)):
  i_rand = math.floor(random()*i+1)
  temp = array[i]
  array[i] = array[i_rand]
  array[i_rand] = temp

print("randomized", array)

