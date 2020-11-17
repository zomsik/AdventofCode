#include <iostream>
#include <fstream>
using namespace std;
int main()
{
	ifstream read("data.txt");
	int w = 0;
	int position = 0;
	int count = 0;
	if (read.is_open())
	{
		char character;
		while (read >> character)
		{
			count++;
			if (character == '(')
			{
				w++;
			}
			else if (character == ')')
			{
				w--;
			}
			if (position == 0 && w == -1)
			{
				position = count;
			}

		}
	}
	else
		cout << "Couldn't open the file";

	cout << "final floor: " << w << "\nposition when entering basement= " << position;




	return 0;
}


