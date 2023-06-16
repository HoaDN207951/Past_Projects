#include "registerUser.h"

registerUser::registerUser()
{
	username = "Default username";
	password = "Default password";
	phonenumber = "Default phone number";
	fullname = "Default fullname";
	ID = 0;
	setCount(getCount() + 1);
}

registerUser::~registerUser()
{
	setCount(getCount() - 1);
}

registerUser::registerUser(string uName, string pw, string phone, string full)
{
	username = uName;
	password = pw;
	phonenumber = phone;
	fullname = full;
	ID = (getCount() + 1);
}

void registerUser::setUsername(string uName)
{
	username = uName;
}

string registerUser::getUsername()
{
	return username;
}

void registerUser::setPassword(string pw)
{
	password = pw;
}

string registerUser::getPassword()
{
	return password;
}

void registerUser::setPhone(string phone)
{
	phonenumber = phone;
}

string registerUser::getPhone()
{
	return phonenumber;
}

void registerUser::setFullname(string full)
{
	fullname = full;
}

string registerUser::getFullname()
{
	return fullname;
}

void registerUser::setID(int id)
{
	ID = id;
}

int registerUser::getID()
{
	return ID;
}

void registerUser::read(book* b)
{
	cout << "You are reading " << b->getTitle() << "..." << endl;
	cout << "The amount of pages you can read: " << b->getNumPages() << " pages." << endl;

}



