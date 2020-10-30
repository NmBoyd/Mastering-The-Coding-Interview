# climb the staircase.
# But you can only go 1-2 steps at a time
# N total stair steps
# return the number of ways to get to the top
# so if N = 2. You could go up with n=1*2 or n=2*1 steps. num_ways=2
# x represents the steps you could take. e.g x = {1,3,5} are the different
# step options

# N =1 : 1 <- {[0 1]}
# N =2 : 2 <- {[0 1 2], [0,2]}
# N =3: 3 <- {[0 1 2 3], [0 1 3], [0,2,3]}
# .... relabel starting with N = ground
# N =1 : 1 <- {[1 0]}
# N =2 : 2 <- {[2 1 0], [2 0]}
# N =3: 3 <- {[3 2 1 0], [3 2 0], [3 1 0]}
# N =3: 3 <- { [3, [path from N=2]], [3 path from N=2], [3 path from N=1]}

# num_ways(3) = num_ways(2)+num_ways(1)
# similar to fibonacci sequence. 
def num_ways(n):
  """
  n: The total number of steps
  return the total number of ways you could step up the staircase. Where 
  the number of steps you can take is x ={1 3 5}
  """
  if n == 0 or n ==1:
    return 1
  else :
    return num_ways(n-1)+num_ways(n-2)

# dynamic programming is more efficient
# O(n)
def num_ways_dp(n):
  if n == 0 or n ==1: 
    return 1
  nums = [None]*(n+1)
  nums[0]=1
  nums[1]=1
  for i in range(2,n+1):
    nums[i] = nums[i-1]+nums[i-2]
  return nums[n]

# incorrect. Missing a recusion. But close
def num_ways_x(n,x):
  if n==0: return 1
  total = 0
  for i in x:
    if n-i >= 0: total += num_ways_x(n-i,x)
  return total

# incorrect. Missing a recusion. But close
def num_ways_dp_x(n,x):
  if n == 0: return 1
  nums = [None]*(n+1)
  nums[0] = 1
  for i in range(1, n+1):
    total=0
    for j in x:
      if i-j >= 0:
        total += num_ways_dp_x(i-j,x)
    nums[i] = total
  return nums[n]

n = 5
print(num_ways(n))
print(num_ways_dp(n))
x = {1,3,5,9}
print(num_ways_x(n,x))
print(num_ways_dp_x(n,x))