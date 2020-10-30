#include <iostream>


#include <unordered_map>
#include <vector>
#include <assert.h>
#include <memory>

// Making a custom templated hash class

class Student{
  public:
    Student(std::string name, int id) : _id(id),_name(name){

    }
    std::string getName(){
      return _name;
    }
    int getId(){
      return _id;
    }

  private:
    int _id;
    std::string _name;
};

std::unordered_map<std::string, int> build_map(std::vector<std::string> &students, std::vector<int> &student_ids){
  assert(students.size() == student_ids.size());
  std::unordered_map<std::string, int> map;
  for (size_t i=0;i<students.size();i++) {
    map[students[i]] = student_ids[i];
  }
  return map;
}

// namespace std {
//   template <> struct hash<Student> 
//   {
//     size_t operator()(const Student& x) const {
//       // std::hash<std::string> h;
//       return (x.getName());
//     }
//   };
// }

// struct typeHasher{
//   size_t operator()(const Student& x) const {
//     return (x.getId());
//   }
// };

// template<class K, class N>
// std::unordered_map<K, N> build_map_templated(const std::vector<K>& students){
//   std::unordered_map<K, N> map;
//   // for (const K s : students) {
//   //   map.insert(std::make_pair(s, s.getId()));
//   // }
//   return map;
// }


template<size_t N>
std::unordered_map<std::string, int> build_map(std::array<std::string,N> const &students, std::array<int,N> const &student_ids){
  std::unordered_map<std::string, int> map;
  for (size_t i=0;i<N;i++) {
    map[students.at(i)] = student_ids.at(i);
  }
  return map;
}


// std::unordered_map<Student, int> build_map(std::vector<Student> &students){
  // std::unordered_map<Student, int> map;
//   return map;
// }