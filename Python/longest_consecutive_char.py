# return the longest consecutive character
# "AABCDDBBBEA" -> B:3


def longest(seq):
  max_count = 1
  max_char = None
  prev_char = None
  for current in seq:
    if prev_char == current:
      count+=1
    else:
      count=1
    if count > max_count:
      max_count = count
      max_char = current
    prev_char = current
  return {max_char:max_count}

seq = "AABCDDBBBEA"
print(longest(seq))