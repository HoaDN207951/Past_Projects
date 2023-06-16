#pragma once
#include "book.h"
#include <vector>
#include <iostream>
using namespace std;
class collection
{
private:
	string name, ID;
	vector<book*> blist;
	vector<string> sublist;
public:
	collection();
	~collection();
	collection(string);

	void setId(string);
	string getId();
	void setName(string);
	string getName();

	void display();

	void addBook(book* b);
	void removeBook(book* b);

	void addSubcribers(string);
	void removeSubcribers(string);

	int getSize();

	vector<book*> getCol();
};

