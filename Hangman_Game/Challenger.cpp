#include "Challenger.h"

Challenger::Challenger()
{
	username = "root";
	password = "root";
}

Challenger::~Challenger()
{
}

Challenger::Challenger(string u, string p)
{
	username = u;
	password = p;
}

void Challenger::setUsername(string u)
{
	username = u;
}

string Challenger::getUsername()
{
	return username;
}

void Challenger::setPass(string p)
{
	password = p;
}

string Challenger::getPass()
{
	return password;
}

Challenger* Challenger::Login(vector<Challenger*> listChal)
{
	string inUser, inPass;

	cout << "Type in username: ";
	cin >> inUser;

	cout << "Type in password: ";
	cin >> inPass;
	for (int i = 0; i < listChal.size(); i++) {
		if (listChal[i]->getUsername() == inUser) {
			if (listChal [i] ->getPass() == inPass) {
				return listChal[i];
			}
		}
	}
	return nullptr;
}
