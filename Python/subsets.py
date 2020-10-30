# print out all of the subsets in any order you want
# [1,2]->{},{1,2},{1},{2}
# # of susets = 2^n. 2^2 = 4
# Output: >-,>1,>2,>1,2

# You can use a recursive tree to get subsets
#         {}
#    {1}      {}
#{1,2} {1}  {2} {}

#{2}->[null,2]->[1,2] 
#             (i=0,i=1)
def all_subsets(given_array):
  subset = [None]*len(given_array)
  helper(given_array, subset, 0)

def print_set(subset):
  print(subset)
def helper(given_array, subset, i):
  if i == len(given_array):
    print_set(subset)
  else:
    subset[i] = None
    helper(given_array, subset, i+1)
    subset[i] = given_array
    helper(given_array, subset, i+1)
  
# iterative solution