# given an array, add 1 to the number
# [1 3 2 4] -> 1324 -> [1 3 2 5]
# Are they always a number between 0-9? Y
# tricky case: [9 9 9] -> [1 0 0 0] is of different length

# iterative or recursive
# ask if you are ok to start coding

# O(n)
def add_one(given_array):
  """
  [1 3 4] -> [1 3 5]
  [9 9 9] -> [1 0 0 0]
  """
  result = [None]*(len(given_array))
  carry = 1
  for i in reversed(range(len(given_array))):
    # print(i)
    sum = given_array[i]+carry
    if sum == 10:
      carry = 1
    else:
      carry = 0
    result[i] = sum%10 # this will take care of most carry cases to 0.
  if carry == 1:
    # all the values are 9. case 1000
    result = [0]*(len(given_array)+1)
    result[0] = 1
  return result

# discuss performance 

# given_array = [1, 2, 3, 4]
given_array = [9,9,9]
print(add_one(given_array))