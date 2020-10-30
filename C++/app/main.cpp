// Executables must have the following defined if the library contains
// doctest definitions. For builds with this disabled, e.g. code shipped to
// users, this can be left out.
#ifdef ENABLE_DOCTEST_IN_LIBRARY
#define DOCTEST_CONFIG_IMPLEMENT
#include "doctest/doctest.h"
#endif

#include <iostream>
#include <stdlib.h>

#include "exampleConfig.h"
#include "example.h"

#include "arrays_and_hashes.cpp"
#include "stacks_and_queues.cpp"

/*
 * Simple main program that demontrates how access
 * CMake definitions (here the version number) from source code.
 */
int main() {
  // Hash tables
  // std::vector<std::string> students = {"a","b","c","d"};
  // std::vector<int> ids = {9,200,500,-10};
  // std::unordered_map<std::string, int> umap = build_map(students, ids); 
  // for (auto x : umap) 
  //   std::cout << x.first << " " << x.second << std::endl; 

  // std::array<std::string,4> students_array = {"a","b","c","d"};
  // std::array<int,4> ids_array = {9,200,500,-10};
  // umap = build_map(students_array, ids_array); 
  // for (auto x : umap) 
  //   std::cout << x.first << " " << x.second << std::endl;

  // std::vector<Student> students_list;
  // students_list.reserve(4);
  // students_list.push_back(Student("joe",10));
  // students_list.push_back(Student("joe",4));
  // students_list.push_back(Student("joe",12));
  // students_list.push_back(Student("joe",3));
  // std::unordered_map<Student, int> umap_new = build_map_templated<Student,int>(students_list); 
  // for (auto x : umap_new) 
  //   std::cout << x.first.getId() << " " << x.second << std::endl;  
  

  // Stacks and queues
  stack<int> new_stack(3);
  new_stack.push(10);
  new_stack.push(5);
  new_stack.push(5);

  stack<std::string> string_stack(4);
  std::cout<< new_stack.peek() << std::endl;
  string_stack.push("C");
  new_stack.pop();
  std::cout<< new_stack.peek() << std::endl;
  std::cout<< string_stack.peek() << std::endl;

  
  // Bring in the dummy class from the example source,
  // just to show that it is accessible from main.cpp.
  Dummy d = Dummy();
  return d.doSomething() ? 0 : -1;
}
