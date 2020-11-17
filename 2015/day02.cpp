#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>
#include <sstream>

using namespace std;

int big(int x, int y) {
    if (x > y) return x;
    else return y;
}

int calculate(int a, int b, int c)
{
    int w = 2 * a * b + 2 * b * c + 2 * a * c;

    w = w + (a * b * c) / (big(big(a, b), c));

    return w;
}
int calculateribbon(int a, int b, int c)
{
  
    int wr = a*b*c + 2*a + 2*b + 2*c - 2*(big(big(a, b), c));
    return wr;
}
void ReadFile(std::string Filename)
{
    ifstream file;
    file.open(Filename.c_str());
    if (!file.good())
        return;
    int a, b, c;
    int i = 0;
    int r1 = 0;
    int r2 = 0;
    string l;
    while (getline(file, l))
    {
        istringstream  iss(l);
        string s;
    



    while (getline(iss, s, 'x'))
    {

        if (i % 3 == 0) a = atoi(s.c_str());
        if (i % 3 == 1) b = atoi(s.c_str());
        if (i % 3 == 2){
            c = atoi(s.c_str());
            r1 += calculate(a, b, c);
            r2 += calculateribbon(a, b, c);
        }
        i++;
    }
    }
    cout << "m2: "<< r1 << " ribbon: "<< r2;

}


int main()
{
    ReadFile("data.txt");


    return 0;
}


