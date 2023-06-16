#include "collection.h"
#include <cmath>

collection::collection()
{
	ID = "No ID";
	name = "Default name";
	blist.clear();
	sublist.clear();
}

collection::~collection()
{
	blist.clear();
	sublist.clear();
}

collection::collection(string n)
{
	name = n;
	blist.clear();
	sublist.clear();
	string input = n;
	int num;
	char array[6];
	string outNum;
	int count = (6 < input.size()) ? 6 : input.size();
	for (int i = 0; i < count; i++)
		array[i] = input[i];
	for (int i = 0; i < 3; i++)
	{
		num = abs((array[2 * i] + array[2 * i + 1]) % 10);
		outNum.append(to_string(num));
	}
	ID = outNum;
}

void collection::setId(string i)
{
	ID = i;
}

string collection::getId()
{
	return ID;
}

void collection::setName(string n)
{
	name = n;
}

string collection::getName()
{
	return name;
}

void collection::display()
{
	for (int i = 0; i < blist.size(); i++) {
		if(blist[i]->getVisibilityStatus())
		cout << blist[i]->getTitle() << ". Serial: " << blist[i]->getSerialNumber() << endl;
	}
}

vector<book*> collection::getCol()
{
	return blist;
}

void collection::addBook(book* b)
{
	blist.push_back(b);
}

void collection::removeBook(book* b)
{
	for (int i = 0; i < blist.size(); i++) {
		if (blist[i] == b) {
			blist.erase(blist.begin() + i);
		}
	}
}

void collection::addSubcribers(string m)
{
	sublist.push_back(m);
}

void collection::removeSubcribers(string m)
{
	for (int i = 0; i < sublist.size(); i++) {
		if (sublist[i] == m) {
			sublist.erase(sublist.begin() + i);
		}
	}
}

int collection::getSize()
{
	return blist.size();
}
