#include "book.h"
#include <cmath>

book::book()
{
	title = "No title";
	serialNumber = "Not available";
	author = "No name";
	numPages = 0;
	numFree = 0;
	category = "Unidentified";
	visibilityStatus = 0;
	availabilityStatus = 0;
}

book::~book()
{
	title = "No title";
	serialNumber = "Not available";
	author = "No name";
	numPages = 0;
	numFree = 0;
	category = "Unidentified";
	visibilityStatus = 0;
	availabilityStatus = 0;
}

book::book(string t, string a, int numP, int numF, string c, bool vS, bool aS)
{
	title = t;
	author = a;
	numPages = numP;
	numFree = numF;
	category = c;
	visibilityStatus = vS;
	availabilityStatus = aS;

	string input = t;
	int num;
	char array[18];
		string outNum;
		int count = (18 < input.size()) ? 18 : input.size();
		for (int i = 0; i < count; i++)
			array[i] = input[i];
		for (int i = 0; i < 6; i++)
		{
			num = abs((array[3 * i] + array[3 * i + 1] + array[3 * i + 2]) % 10);
			outNum.append(to_string(num));
		}
		serialNumber = outNum;
}

void book::setTitle(string t)
{
	title = t;
}

string book::getTitle()
{
	return title;
}

void book::setSerialNumber(string s)
{
	serialNumber = s;
}

string book::getSerialNumber()
{
	return serialNumber;
}

void book::setAuthor(string a)
{
	author = a;
}

string book::getAuthor()
{
	return author;
}

void book::setNumPages(int numP)
{
	numPages = numP;
}

int book::getNumPages()
{
	return numPages;
}

void book::setNumFree(int numF)
{
	numFree = numF;
}

int book::getNumFree()
{
	return numFree;
}

void book::setCategory(string c)
{
	category = c;
}

string book::getCategory()
{
	return category;
}

void book::setVisibilityStatus(bool vS)
{
	visibilityStatus = vS;
}

bool book::getVisibilityStatus()
{
	return visibilityStatus;
}

void book::setAvailabilityStatus(bool aS)
{
	availabilityStatus = aS;
}

bool book::getAvailabilityStatus()
{
	return availabilityStatus;
}


