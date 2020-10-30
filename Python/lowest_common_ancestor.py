# find the lowest common ancestor in the tree
#       root
#     3       2
# 4     6
#     5
# LCA(root,4,5)->(from 4,3,5) -> 3
# LCA(root,3,5)->3
# LCA(root,4,2)->1
# LCA(root,6,6)->6

# LCA(root,4,5)
# paths: 1,3,4 and 1,3,6,5
# return the last common element (3)

# returns the path as an array
def path_to_x(root,x):
  if root == None:
    return None

  if root.value == x:
    stack = [x]
    return stack
  left_path = path_to_x(root.left,x)

  if left_path != None:
    left_path.append(root.value)
    return left_path
  right_path = path_to_x(root.right,x)

  if right_path != None:
    right_path.add(root.value)
    return right_path
  return None

def LCA(root, j, k):
  path_to_j = path_to_x(root,j)
  path_to_k = path_to_x(root,k)

  lca_to_return = None 
  while (path_to_j.notEmpty() and path_to_k.notEmpty()):
    j_pop = path_to_j.pop()
    k_pop = path_to_k.pop()
    if j_pop == k_pop :
      lca_to_return = j_pop
    else:
      break
  return lca_to_return