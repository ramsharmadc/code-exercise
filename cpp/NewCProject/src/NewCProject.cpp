#include <cstdint>
#include <iostream>
#include <string>
#include <vector>

using namespace std;
using std::cout;
using std::vector;

/**
 * @brief
 *
 * @param charName
 * @param age
 *
 * Run Instructions - From teminal run g++ .\NewCProject.cpp
 * and then run the exe generated - ./a
 */


void passParameter(string charName, int age)
	{
		std::cout << "There was a man named " << charName << endl;
		std::cout << charName << " was " << age << " years old" << endl;
		std::cout << charName << " liked his name" << endl;
		std::cout << "But " << charName << " did not want to be " << age
				  << " years old" << endl;
	}

	void differentTypesOfDataTypes()
	{
		char aCharater = 'A';
		string aStringText = "A phrase of text";
		int anInt = 90;
		double aDouble = 83.29;
		bool aBoolean = true;

		std::cout << "aCharater: " << aCharater << endl;
		std::cout << "aStringText: " << aStringText << endl;
		std::cout << "anInt: " << anInt << endl;
		std::cout << "aDouble: " << aDouble << endl;
		std::cout << "aBoolean: " << aBoolean << endl;
	}

	void workingWithStrings()
	{
		cout << "Strings in C++" << endl;
		string text = "CPP Tutorial";
		cout << text[0];
		cout << text[1] << endl;

		cout << text.find('C') << endl;
		cout << text.substr(6, 4) << endl;
	}

	int factorial_rec(int k)
	{
		if (k == 0)
			return 0;
		if (k == 1)
			return 1;
		return factorial_rec(k - 1) + factorial_rec(k - 2);
	}

	void checkVectors()
	{
		vector<int64_t> numbers{0, 1, 2};
		numbers.push_back(-2);
		numbers[0] = 3;

		for (int i : numbers)
		{
			cout << i << "\n";
		}
	}

	int main()
	{
		cout << "Hello World of C++" << endl; // prints !!!Hello World!!!

		int a = 56;
		int twice = 2 * a;

		std::cout << "twice: " << twice << endl;

		passParameter("Ram", 31);

		differentTypesOfDataTypes();

		workingWithStrings();

		int f = factorial_rec(18);
		std::cout << "factorial: " + to_string(f) << endl;

		int const zero = 0;
		const int one = 1;
		//  zero = 1;   // can not change constant

		std::cout << "const zero: " << zero << endl;
		std::cout << "const one: " << one << endl;

		checkVectors();

		std::cout << "Main Exit" << one << std::endl;

		return 0;
	}
