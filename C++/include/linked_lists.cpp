#include <iostream>

// linked list

template<class T>
struct Node{
  T data;
  Node* next;
};

template<class T>
class LinkedList
{
  public:
    LinkedList(){
      head = nullptr;
      tail = nullptr;
      size = 0;

    }

    ~LinkedList(){
      Node<T>* tmp = new Node<T>;
      while(head != nullptr){
        tmp = head;
        head = head->next;
        delete tmp;
      }
      tail = nullptr;
      size =0;
    }
    /**
     * Get the size
     * @return the size
     */
    int getSize()
    {
      return size;
    }

    /**
     * Set the object at index to a new value
     * @param index the index in the list
     * @param data the new data for that element
     */
    bool set(int index, T data)
    {
      if(index<0 || index >= size){
        return false;
      }

      getNode(index)->data = data;
      return true;
    }

    /**
     * Remove the last object
     * @return the object popped
     */
    T pop_back()
    {
      if (size <= 0){
        return T();
      }

      // if it doesn't affect the head
      if (size >= 2){
        Node<T>* tmp = getNode(size-2);
        // save the data from element to be removed
        T ret = tmp->next->data;
        delete(tmp->next);
        // set the 
        tmp->next = nullptr;
        tail = tmp;
        size--;
        return ret;
      }
      else
      {
        T ret = head->data;
        delete(head);
        head = nullptr;
        tail = nullptr;
        size = 0;
        return ret;
      }
      
    }

    /**
     * Removes an object from the front of the list
     */
    T pop_front()
    {
      if (size <= 0){
        return T();
      }

      if (size > 1){
        Node<T>* next = head->next;
        T ret = head->data;
        delete(head);
        head = next;
        size--;
        return ret;
      }
      else
      {
        return pop_back();
      }
      
    }

    /**
     * Adds an element after the element at the index
     * @param index the index in the list
     * @param data the data for the new element
     */
    bool insert(int index, T data)
    {
      if (index >= size) 
        return push_back(data);
      if (index == 0) 
        return push_front(data);

      Node<T>* tmp = new Node<T>;
      Node<T>* prev = getNode(index-1);
      tmp->data = data;
      tmp->next = prev->next;
      prev->next = tmp;
      size++;
      return true;
    }

    /**
     * Add an element to the end of the list
     * @param data the data being added
     * @return if the operation completed
     */
    bool push_back(T data)
    {
      Node<T>* tmp = new Node<T>;
      tmp->data = data;
      tmp->next = nullptr;
      if (head){
        tail->next = tmp;
        tail = tmp;
      }
      else{
        head = tmp;
        tail = tmp;
      }
      size++;
      return true;
    }

    /**
     * Adds a T object to the star of the list
     * @param data the data for the new object added
     */
    bool push_front(T data)
    {
      if (size == 0)
        return add(data);
      
      Node<T>* tmp = new Node<T>;
      tmp->next = head;
      tmp->data = data;
      head = tmp;

      size++;
      return true;
    }

    /**
     * Clears the list of objects
     */
    void clear()
    {
      while(getSize()>0)
      {
        pop_front();
      }
    }

    // void sort(int (*cmp)(T&, T&))
    // {

    // }

  private:

    Node<T>* getNode(int index)
    {
      int pos = 0;
      Node<T>* curr = head;
      while(pos < index && curr)
      {
        curr = curr->next;
        pos++;
      }

      if (pos == index){
        prev_index = index;
        return curr;
      }
      return nullptr;
    }

  private:
    Node<T>* head;
    Node<T>* tail;
    int size;
    int prev_index;

};
