#pragma once
#include "Word.h"
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Challenger
{
private:
	string username;
	string password;
public:
	Challenger();
	~Challenger();
	Challenger(string, string);

	void setUsername(string);
	string getUsername();
	void setPass(string);
	string getPass();

	Challenger* Login(vector<Challenger*>);

};

