#pragma once
#include "user.h"
#include <iostream>
using namespace std;

class registerUser : public user
{
private:
	string username;
	string password;
	string phonenumber;
	string fullname;
	int ID;
public:
	registerUser();
	~registerUser();
	registerUser(string, string, string, string);

	void setUsername(string);
	string getUsername();
	void setPassword(string);
	string getPassword();
	void setPhone(string);
	string getPhone();
	void setFullname(string);
	string getFullname();
	void setID(int);
	int getID();

	void read(book* b);
};

