#include "admin.h"

admin::admin()
{
	setUsername("root");
	setPassword("root");
}

admin::~admin()
{
}

admin::admin(admin* a)
{
	setAccessLevel(adminLevel);
	setUsername(a->getUsername());
	setPassword(a->getPassword());
	setFullname(a->getFullname());
	setPhone(a->getPhone());
	setID(a->getID());
}

admin::admin(string uName, string pw, string phone, string full) : registerUser(uName, pw, phone, full)
{

	this->setCount(this->getCount() + 1);
}

void admin::addBook(vector<book*> &list)
{
	book* b;
	string input;
	int val;
	cout << "Input book's title: " << endl;
	cin.sync();
	cin.ignore();
	getline(cin, input);
	b = new book(input, "", 0, 0, "", true, true);
	cout << "Input book's author: " << endl;
	getline(cin, input);
	b->setAuthor(input);
	cout << "Input book's category: " << endl;
	getline(cin, input);
	b->setCategory(input);
	cout << "How many pages are there? " << endl;
	cin.sync();
	cin >> val;
	b->setNumPages(val);
	cout << "How many pages can be read for free? " << endl;
	cin >> val;
	b->setNumFree(val);
	list.push_back(b);
	cout << "Book is added successfully." << endl;
}

void admin::createAdmin(vector<admin*> &adminlist)
{
	string user, pass, phone, full;
	int id;
	admin* newAdmin;
	cout << "New admin's username: " << endl;
	cin >> user;
	cout << "New admin's password: " << endl;
	cin >> pass;
	cout << "New admin's phone number: " << endl;
	cin >> phone;
	cout << "New admin's full name: " << endl;
	cin.ignore();
	getline(cin, full);
	newAdmin = new admin(user, pass, phone, full);
	adminlist.push_back(newAdmin);
	cout << "Admin registered successfully." << endl;
}

void admin::show(book* b)
{
	b->setVisibilityStatus(true);
	cout << "Book is shown publicly.\n";
}

void admin::hide(book* b)
{
	b->setVisibilityStatus(false);
	cout << "Book is hidden.\n";
}

void admin::remove(book* b, vector<book*> &book_list, vector<collection*> &col_list)
{
	for (int i = 0; i < book_list.size(); i++)
	{
		if (book_list[i] == b) 
			book_list.erase(book_list.begin() + i);
	}

	for (int i = 0; i < col_list.size(); i++)
	{
		col_list[i]->removeBook(b);
	}
	delete b;
	cout << "Remove book successfully.\n";
}

void admin::edit(book*b)
{
	string edit_str;
	int edit_num;
	char in;

	cout << "The book's info: \n";
	cout << "Book's name: " << b->getTitle() << endl;
	cout << "Book's serial number: " << b->getSerialNumber() << endl;
	cout << "Book's author: " << b->getAuthor() << endl;
	cout << "Book's category: " << b->getCategory() << endl;
	cout << "Book's number of pages: " << b->getNumPages() << endl;
	cout << "Book's number of free pages: " << b->getNumFree() << endl;
	cout << endl;

	cout << "Do you want to change the title? Y/N: ";
	cin >> in;
	if (in == 'Y'|| in == 'y') {
		cout << "Enter new title: ";
		cin.ignore();
		getline(cin, edit_str);
		b->setTitle(edit_str);
	}

	cout << "Do you want to change the author? Y/N: ";
	cin >> in;
	if (in == 'Y' || in == 'y') {
		cout << "Enter new author: ";
		cin.ignore();
		getline(cin, edit_str);
		b->setAuthor(edit_str);
	}

	cout << "Do you want to change the category? Y/N: ";
	cin >> in;
	if (in == 'Y' || in == 'y') {
		cout << "Enter new category: ";
		cin.ignore();
		getline(cin, edit_str);
		b->setCategory(edit_str);
	}

	cout << "Do you want to change the serial number? Y/N: ";
	cin >> in;
	if (in == 'Y' || in == 'y') {
		cout << "Enter new serial number: ";
		cin.ignore();
		getline(cin, edit_str);
		b->setSerialNumber(edit_str);
	}

	cout << "Do you want to change the number of pages? Y/N: ";
	cin >> in;
	if (in == 'Y' || in == 'y') {
		cout << "Enter new number of pages: ";
		cin >> edit_num;
		b->setNumPages(edit_num);
	}

	cout << "Do you want to change the number of free pages? Y/N: ";
	cin >> in;
	if (in == 'Y' || in == 'y') {
		cout << "Enter new number of pages: ";
		cin >> edit_num;
		b->setNumFree(edit_num);
	}
	cout << "Book editing successfully.\n";
	cout << "After edit: \n";
	cout << "The book's info: \n";
	cout << "Book's name: " << b->getTitle() << endl;
	cout << "Book's serial number: " << b->getSerialNumber() << endl;
	cout << "Book's author: " << b->getAuthor() << endl;
	cout << "Book's category: " << b->getCategory() << endl;
	cout << "Book's number of pages: " << b->getNumPages() << endl;
	cout << "Book's number of free pages: " << b->getNumFree() << endl;
	cout << endl;
}

void admin::display(vector<book*> &b)
{
	cout << endl;
	for (int i = 0; i < b.size(); i++)
	{
		cout << b[i]->getTitle() << " by " << b[i]->getAuthor() << ". Serial: " << b[i]->getSerialNumber() << endl;
	}
}

void admin::createCollection(vector<collection*>& c)
{
	collection* obj;
	string name;
	cout << "Enter the name of the collection: ";
	cin.ignore();
	getline(cin, name);
	obj = new collection(name);
	c.push_back(obj);
	cout << "Collection created successfully.\n";
	cout << "To add books to newly created collection, please go to edit collection.\n";
	cout << "This collection's ID is: " << obj->getId() << endl;
}

void admin::editCollection(vector<book*> &allBooks, vector<collection*>& col_list)
{
	string input;
	char choice;
	bool check = true;
	cout << "What are the ID of the collection to be edited? ";
	cin >> input;
	for (int i = 0; i < col_list.size(); i++)
	{
		if (col_list[i]->getId() == input)
		{
			cout << "Now editing: " << col_list[i]->getName() << endl;
			cout << "Do you want to change its name? Y/N: ";
			cin >> choice;
			if (choice == 'y' || choice == 'Y')
			{
				cout << "Input new name: "; 
				cin.ignore(); 
				getline(cin, input);
				col_list[i]->setName(input);
			}
			cout << "Do you want to change its ID? Y/N: ";
			cin >> choice;
			if (choice == 'y' || choice == 'Y')
			{
				cout << "Input new ID: "; cin.sync(); getline(cin, input);
				col_list[i]->setId(input);
			}
			cout << endl;
			cout << "Here are the books in this collection: " << endl;
			col_list[i]->display();
			cout << endl;
			cout << "Do you want to add books to this collection? Y/N ";
			cin >> choice;
			while (choice == 'y' || choice == 'Y')
			{
				cout << "Input book ID to add: ";
				cin >> input;
				col_list[i]->addBook(searchbySerial(allBooks, input));
				cout << "Do you want to continue adding books? Y/N ";
				cin >> choice;
			}
			cout << "Do you want to remove books from this collection? Y/N ";
			cin >> choice;
			while (choice == 'y' || choice == 'Y')
			{
				if (col_list[i]->getSize() > 0)
				{
					cout << "Input book ID to remove: ";
					cin >> input;
					col_list[i]->removeBook(searchbySerial(allBooks, input));
					cout << "Do you want to continue removing books? Y/N ";
					cin >> choice;
				}
				else cout << "This collection is empty!" << endl;
			}
			check = false;
			cout << "Collection edited successfully.\n";
		}
	} 
	if (check) 
		cout << "No collection with this ID can be found. " << endl;
}

void admin::displayAllCollection(vector<collection*>& c)
{
	for (int i = 0; i < c.size(); i++)
	{
		cout << c[i]->getName() << "      ID: " << c[i]->getId() << endl;
		c[i]->display();
	}
}

void admin::deleteCollection(vector<collection*>& c)
{
	string input;
	bool check = true;
	cout << "Enter the ID of the collection to be deleted: ";
	cin >> input;
	for (int i = 0; i < c.size(); i++)
	{
		if (c[i]->getId() == input)
		{
			c[i]->~collection();
			c.erase(c.begin() + i); 
			check = false;
			cout << "Collection is deleted successfully.\n";
		}
	} 
	if (check) 
		cout << "No collection with this ID can be found. " << endl;
}

admin* admin::Login(vector<admin*> &listAcc)
{
	string inUser, inPass;
	cout << "Type in username: ";
	cin >> inUser;
	
	cout << "Type in password: ";
	cin >> inPass;
	for (int i = 0; i < listAcc.size(); i++) {
		if (listAcc[i]->getUsername() == inUser) {
			if (listAcc[i]->getPassword() == inPass) {
				return listAcc[i];
			}
		}
	}
	return nullptr;
}


