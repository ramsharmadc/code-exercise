#include "BasicControls.h"
#include <iostream>
using namespace std;


using namespace std;

void reverseString(char ch[])
{
    std::cout << ch << "\n";
}

int fib_it(int n)
{
    int fibarr[n] = {};
    fibarr[0] = 1;
    fibarr[1] = 1;
    for (int i = 2; i < n; i++)
    {
        fibarr[i] = fibarr[i - 1] + fibarr[i - 2];
    }
    return fibarr[n - 1];
}

double double_it(double t)
{
    return t * 2;
}

// program starts from here
int call_this_class()
{
    cout << "Hello World\n";
    int n = 90;
    double f = fib_it(n);
    std::cout << "fib(" << n << ") => " << f << "\n";
    cout << "double(" << n << ") => " << double_it(n) << "\n";
    char c_arr[] = {"HELLO"};
    reverseString(c_arr);

    char a_char = 'a';

    std::cout << a_char;
    return 0;
}


