#include <iostream>
#include <string>

int main()
{
	std::string name, username;
	int age;
	
	std::cout << "What is your name: ";
	std::cin >> name;
	
	std::cout << "What is your age: ";
	std::cin >> age;
	
	std::cout << "What is your reddit username: ";
	std::cin >> username;
	
	std::cout << "Your name is " << name << ", you are " << age << 
		" years old, and your username is " << username << std::endl;
	
	return 0;
}