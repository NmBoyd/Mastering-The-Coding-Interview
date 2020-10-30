from __future__ import print_function
import argparse
import math
import time
import numpy as np

# Tell me the number of ways a given data string could be printed
# 'a' -> 1, 'b'->2,... 'z'->26
# 'ab'->"12"
# data = "12" <- could be "ab" or "l"
# assume only digits between 0 and 9

# examples:
# "3"->'c' num_ways("3")=1
# ""->"" num_ways("")=1 
# "12345" -> "a"+decode("2345") or "l"+decode("345")
# numways("12345")=numways("2345")+numways("345")
# starting to look like recursion

# helper("12345",k)=helper("12345",k-1)+helper("12345",k-2)
# No number larger than 26, so 27+ is less recursive
# helper("27345",k)=helper("27345",k-1)
def helper(data, k):
  # numways("")=1
  if k == 0:
    return 1
  s = len(data) - k
  # numways("011")=0
  if data[s] == '0':
    return 0
  result = helper(data, k-1)
  if k >= 2 and int(data[s:s+2])<=26:
    result += helper(data,k-2)
  return result
  
def num_ways(data):
  return helper(data,len(data))

# note...
# helper recursion can be inefficient...
# ex: numways("111111")=helper("111111",6)
#                     =helper("111111",5)
# we can improve the efficiency with dynamic programming!!!
# ex: numways("111")
# memo = [null, null, null, null]
# helper("111",k)
# helper("111",n)
def helper_dynamic_prog(data, k, memo):
  if k == 0:
    return 1
  s = len(data) - k
  if data[s] == '0':
    return 0
  if memo[k] != None:
    return memo[k]
  result = helper_dynamic_prog(data, k-1, memo)
  if k >= 2 and int(data[s:s+2]) <= 26:
    result += helper_dynamic_prog(data, k-2, memo)
  memo[k] = result
  return result

# O(n)
def num_ways_dp(data):
  memo = [None]*(len(data)+1) # init null vector
  return helper_dynamic_prog(data, len(data), memo)

data = "111111111"
print(num_ways(data))
print(num_ways_dp(data))