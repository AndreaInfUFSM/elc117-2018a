#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>


int main() {

   std::vector<int> numbers;
   numbers.push_back(9);
   numbers.push_back(1);
   numbers.push_back(50);

   // percorre com indice
   for (int i = 0; i < numbers.size(); i++) 
      std::cout << numbers[i] << " ";
   std::cout << std::endl;
   

   // percorre com iterador
   std::vector<int>::const_iterator it;
   for (it = numbers.begin(); it != numbers.end(); it++)
      std::cout << *it << " ";
   std::cout << std::endl;


   // percorre com iterador reverso
   std::vector<int>::reverse_iterator rev;
   for (rev = numbers.rbegin(); rev != numbers.rend(); rev++)
      std::cout<< *rev << " ";
   std::cout << std::endl;
   

   // percorre com ostream_iterator usando algoritmo copy
   std::copy(numbers.begin(), numbers.end(),
         std::ostream_iterator<int>(std::cout, " "));
   std::cout << std::endl;


   // ordena
   std::sort(numbers.begin(), numbers.end());


   // percorre com ostream_iterator usando algoritmo copy
   std::copy(numbers.begin(), numbers.end(),
         std::ostream_iterator<int>(std::cout, " "));
   std::cout << std::endl;
}
