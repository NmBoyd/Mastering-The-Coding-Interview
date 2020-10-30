# return the first recurring character
# "ABCA" -> "A"
# "BCABA"-> "B"
# "ABC" -> none

# NAIIVE SOLUTION FIRST

# add them all to a hash table in. First one that already exists returns
# O(n)

def first_recurring(given_string):
  dict =  {}
  # loop through the word
  for char in given_string:
    # if character is already in dictionary return it
    if char in dict:
      return char
    # otherwise add the char to the dict. We use filler val 1
    dict[char] = 1
  return None

word = "BCABA"
print(first_recurring(word))