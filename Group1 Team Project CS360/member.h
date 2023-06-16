#pragma once
#include "collection.h"
#include "book.h"
#include "registerUser.h"
#include <vector>
#include <iostream>
using namespace std;
class member : public registerUser{
private:
	int start, end;
	vector <book*> listBook;
	vector <collection*> listSub;
public:
	member();
	~member();
	member(int, int, string, string, string, string);

	void setStart(int);
	int getStart();
	void setEnd(int);
	int setEnd();

	void borrow(book* b);
	void returnBook(book* b);
	void subcribe(collection*);
	void unsubcribed(collection*);
	void displayCollection();
	void displayBorrowed();

	int getlistBooksize();
	int getlistSubsize();

    member* Login(vector<member*> &listAcc);
};

