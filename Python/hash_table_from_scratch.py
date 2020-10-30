
class HashTable(object):
  def __init__(self, length=4):
    # initiate our array with empty values
    self.array = [None]*length
  
  def hash(self, key):
    """Get the index of our array for a specific string key"""
    return hash(key) % len(self.array)

  def add(self, key, value):
    """Add a value to our array by its key"""
    index = self.hash(key)
    if self.array[index] is not None:
      # This index already contains some values.
      # This means that this add might be an update 
      # to a key that already exists. Instead of just storing
      # the value we have to first look if the key exists
      for kvp in self.array[index]:
        # if key is found, then update
        # its current value to the new value
        if kvp[0] == key:
          kvp[1] = value
          break

      # if no breaks was hit in th for loop, it
      # means that no existing key was found,
      # so we can simply just add it to the end
      self.array[index].append([key, value])
    else:
      # the index is empty. We should init a list
      # and append our key-value-pair to it
      self.array[index] = []
      self.array[index].append([key, value])
  
  def get(self, key):
    """Get a value by key"""
    index = self.hash(key)
    if self.array[index] is None:
      raise KeyError()
    else:
      # Loop through all the key-value pairs and find
      # if our key exists. If it does, then return its val
      for kvp in self.array[index]:
        if kvp[0] == key:
          return kvp[1]

      # if no return was done during the loop
      # the key doesn't exist
      raise KeyError()

  def is_full(self):
    """Determines if the HashTable is too populated"""
    items = 0
    # Count how many indexes in our array
    # that is populated with values
    for item in self.array:
      if item is not None:
        items+=1
    # return a bool vlaue based on if the amount of populated items 
    # are more than half the length of the list
    return items > len(self.array)/2

  def double(self):
    """Double the list length and re-add values"""
    ht2 = HashTable(length=len(self.array)*2)

    for i in range(len(self.array)):
      if self.array[i] is None:
        continue

      # List is now a different length, we need
      # to re-add all of our values to the new list
      # for its hash to return correct index
      for kvp in self.array[i]:
        ht2.add(kvp[0], kvp[1])
    
    # Finally we replace our current list with the new 
    # list of values that we created in ht2
    self.array = ht2.array

  def __setitem__(self, key, value):
    self.add(key, value)

  def __getitem__(self, key):
    return self.get(key)

  def __contains__(self, key):
    index = self.hash(key)
    for kvp in self.array[index]:
        if kvp[0] == key:
          return True
    return False



def main():
  print("Example Hash table")
  hash_table = HashTable()
  # using __setitem__
  hash_table["foo"] = "bar"

  # using __getitem__
  val = hash_table["foo"]
  print(val)
  # using __contains__
  if "foo" in hash_table:
    print("Exists!")

  # using __iter__
  # for kvp in hash_table:
  #   print(kvp)
  
if __name__ == "__main__":
  main()