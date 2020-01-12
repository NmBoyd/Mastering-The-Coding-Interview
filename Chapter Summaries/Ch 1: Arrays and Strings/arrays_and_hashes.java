/**
    HASH TABLES

    Hash table is a data structure that maps keys to values for highly efficient lookup.
    In a very simple implementation of a hash table, the hash table has an underlying array
    and hash function. When you want to insert and objct and its key, the hash function maps
    the key to an integer, which indicates the index of the array. The object is then stored
    at that index. (This requires all possible keys to be unique, or data will be overwritten)

    Instead of making a large array and storing objcts at index [hash(key)], we can make the
    array smaller and store objects in a linked list at index [hash(key) % array_length].
    To get the object with a particular key, we must search the linked list for this key. Or,
    we can implement the hash table with a binar search tree. We can then guarantee an O(log n)
    lookup time, since we can keep the tree balanced.
 */

public HashMap<Integer, Student> buildMap(Student[] students) {
    HashMap<Integer, Student> map = new HashMap<Integer,Student>();
    for (Student s : students) map.put(s.getId(),s);
    return map;
}

/**
    ArrayList (Dynamically Resizing Array)

    ArrayList is an array the resizes itself as needed while still providing O(1) access.
    A typical implementation is that when the array is full, the array doubles in size 
    (but the doubling is rare, so that O(n) process doesn't take that long)
 */

 public ArrayList<String> merge(String[] words, String[] more) {
    ArrayList<String> sentence = new ArrayList<String>();
    for (String w : words) sentence.add(w);
    for (String w : more) sentence.add(w);
    return sentence;
 }

 /**
    StringBuffer
    
 */

// Assume that all words are of length x
// This is O(xn^2) because 1+2+...n = n(n+1)/2
public Strng joinWords(String[] words) {
    String senctence  = "";
    for (String w : words) {
        sentence = sentence + w;
    }
    return sentence;
}

// StringBuffer simply creates an array of all the strings, copying them back to a string when necessary
// TODO: Implement your own StringBuffer
public String joinWords(String[] words) {
    StringBuffer sentence = new StringBuffer();
    for (String w : words) {
        sentence.append(w);
    }
    return sentence.toString();
}