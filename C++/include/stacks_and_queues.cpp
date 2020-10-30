#include <iostream>
#include <cstdlib>

#define DEFAULT_SIZE 10

template <class X>
class stack
{
  public:
    stack(int size = DEFAULT_SIZE) 
    {
      arr = new X[size];
      capacity = size;
      top = -1;
    }
    
    ~stack(){
      delete[] arr;
    }

    void push(X x)
    {
      if (isFull()) {
        std::cout << "Overflow \nProgram Terminating" << std::endl;
        exit(EXIT_FAILURE);
      }
      std::cout << "Inserting " << x << std::endl;
      arr[++top] = x;
    }

    X pop()
    {
      if(isEmpty()){
        std::cout<<"Underflow \nProgram Terminating" <<std::endl;
        exit(EXIT_FAILURE);
      }
      std::cout<<"Removing" << peek() << std::endl;
      return arr[top--];
    }

    X peek()
    {
      if(!isEmpty()){
        return arr[top];
      }
      else{
        std::cout<<"Empty \nProgram Terminating" <<std::endl;
        exit(EXIT_FAILURE);
      }
    }

    int size()
    {
      return top+1;
    }

    bool isEmpty()
    {
      return top == -1;
    }

    bool isFull()
    {
      return top == capacity-1;
    }

  private:
    X *arr;
    int top;
    int capacity;
};
