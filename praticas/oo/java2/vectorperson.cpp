#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <fstream>
#include <iterator>
#include <algorithm>


class Person {
   std::string name;
   int age;
public:
   Person(std::string name, int age) {
      this->name = name;
      this->age = age;
   }
   std::string getName() {
      return name;
   }
   int getAge() {
      return age;
   }
   // operador '<' sobrecarregado (overload)
   // permite comparar Persons pela idade
   bool operator<(Person& p) {
      return this->age < p.age;
   }

};

// comparador de Persons pelo nome
bool cmpPersonName(Person& p1, Person& p2) {
   return p1.getName() < p2.getName();
}

int main() {

   std::ifstream data("data.csv");
   
   std::string line;
   std::string cell[2];
   std::vector<Person> v;
   
   while (std::getline(data, line)) {
      std::stringstream linestream(line);
      std::getline(linestream, cell[0], ',');
      std::getline(linestream, cell[1], ',');
      v.push_back(Person(cell[0], std::stoi(cell[1])));
   }
   
   std::vector<Person>::iterator it;
   for (it = v.begin(); it != v.end(); it++)
      std::cout<< it->getName() << " ";
   std::cout << std::endl;
   
         
   // ordena com operador '<' definido na classe (por idade)
   std::sort(v.begin(), v.end());


   for (it = v.begin(); it != v.end(); it++)
      std::cout<< it->getAge() << " ";
   std::cout << std::endl;


   // ordena com funcao cmpPerson definida fora da classe
   std::sort(v.begin(), v.end(), cmpPersonName);

   
   for (it = v.begin(); it != v.end(); it++)
      std::cout<< it->getName() << " ";
   std::cout << std::endl;
}
