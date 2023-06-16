#pragma once
#include "registerUser.h"
#include <vector>
#include "book.h"
#include "collection.h"
class admin : public registerUser
{
private:
	
public:
	admin();
	~admin();
	admin(admin* a);
	admin(string, string, string, string);

	void addBook(vector<book*> &list);
	void show(book* b);
	void hide(book* b);
	void remove(book* b, vector<book*>& book_list, vector<collection*>& col_list);
	void edit(book* b);
	void display(vector<book*>& b);

	void createAdmin(vector<admin*>&);

	void createCollection(vector<collection*>& c);
	void deleteCollection(vector<collection*>& c);
	void editCollection(vector<book*>& , vector<collection*>& c);
	void displayAllCollection(vector<collection*>& c);

	admin* Login(vector<admin*> &listAcc);
};

