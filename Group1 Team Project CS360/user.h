#pragma once
#include "book.h"
#include <iostream>
#include <string>
#include <vector>

using namespace std;

enum accessibilityType : int {guestLevel = 1, memberLevel = 2, adminLevel = 3};

class user
{
private:
	accessibilityType accessibilityLevel;
	static int userCount;
public:
	user();
	user(accessibilityType);
	~user();

	void setAccessLevel(accessibilityType);
	accessibilityType getAccessLevel();

	void setCount(int);
	int getCount();

	virtual void read(book* b) = 0;
	book* searchbyTitle(vector<book*> listBook, string input);
	book* searchbySerial(vector<book*> listBook, string input);
};

