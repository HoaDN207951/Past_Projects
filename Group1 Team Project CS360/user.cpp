#include "user.h"

int user::userCount = 0;

user::user()
{
	accessibilityLevel = guestLevel;
}

user::user(accessibilityType aLevel)
{
	accessibilityLevel = aLevel;
}

user::~user()
{
	cout << "Destructor for user is called." << endl;
}

void user::setAccessLevel(accessibilityType aLevel)
{
	accessibilityLevel = aLevel;
}

accessibilityType user::getAccessLevel()
{
	return accessibilityLevel;
}

void user::read(book* b)
{
	cout << "virtual void read function is called." << endl;
}

book* user::searchbyTitle(vector<book*> listBook, string title)
{
	for (int i = 0; i < listBook.size(); i++)
	{
		if (listBook[i]->getTitle() == title)
		{
			return listBook[i];

		}
	}
	return nullptr;
}

book* user::searchbySerial(vector<book*> listBook, string serial)
{
	for (int i = 0; i < listBook.size(); i++)
	{
		if (listBook[i]->getSerialNumber() == serial)
		{
			return listBook[i];
		}
	}
	return nullptr;
}

void user::setCount(int i)
{
	userCount = i;
}

int user::getCount()
{
	return userCount;
}


