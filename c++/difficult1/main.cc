#include <iostream>
#include <string>

void print_usage()
{
	std::cout << "if the guess is too high, enter \"h\", too low enter \"l\". "
		<< "If it is correct, enter \"c\"" << std::endl;
}

int main()
{
	std::cout << "**** Guessing Game ****" << std::endl;
	std::cout << "Pick a number between 1 and 100." << std::endl;
	print_usage();
	
	std::string user_feedback;
	bool finished = false;
	int min = 1, max = 100;
	
	while (!finished)
	{
		int guess = min + (max - min) / 2;
		std::cout << "My guess is " << guess << ". High (h), low (l) or Correct (c): ";
		std::cin >> user_feedback;
		
		if (user_feedback == "c") 
		{
			finished = true;
		}
		else if (user_feedback == "h") 
		{
			max = guess - 1;
		}
		else if (user_feedback == "l") 
		{
			min = guess + 1;
		}
		else
		{
			print_usage();
		}
		
	}
}