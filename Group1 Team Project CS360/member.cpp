#include "member.h"

member::member()
{
	this->start = -1;
	this->end = -1;
}

member::~member()
{
}

member::member(int s, int e, string uName, string pw, string phone, string full) : registerUser(uName, pw, phone, full)
{
	this->start = s;
	this->end = e;
	this->setCount(this->getCount() + 1);
}

void member::setStart(int s)
{
	start = s;
}

int member::getStart()
{
	return start;
}

void member::setEnd(int e)
{
	end = e;
}

int member::setEnd()
{
	return end;
}

void member::borrow(book* b)
{
	bool check = true;
	for (int i = 0; i < listBook.size(); i++) {
		if (listBook[i] == b) {
			cout << "You have already borrowed this book." << endl;
			check = false;
		}
	}
	if (check) {
		listBook.push_back(b);
		cout << "Borrowed book successfully.\n";
	}
}

void member::returnBook(book* b)
{
	bool check = true;
	string in;
	if (listBook.size() > 0) {
		for (int i = 0; i < listBook.size(); i++) {
			if (listBook[i] == b) {
				listBook.erase(listBook.begin() + i);
				check = false;
				cout << "Returned book successfully.\n";
			}
		}
		if (check) cout << "You did not borrow this book." << endl;
	}
	else cout << "You haven't borrowed any books." << endl;
}

void member::subcribe(collection* col)
{
	bool check = true;
	for (int i = 0; i < listSub.size(); i++) {
		if (listSub[i] == col) {
			cout << "You have already subscribed to this collection." << endl;
			check = false;
		}
	}
	if (check) {
		listSub.push_back(col);
		col->addSubcribers(this->getUsername());
		cout << "Subcribed collection successfully.\n";
	}
}

void member::unsubcribed(collection* col)
{
	bool check = true;
	for (int i = 0; i < listSub.size(); i++) {
		if (listSub[i] == col) {
			listSub.erase(listSub.begin() + i);
			check = false;
			cout << "Unsubcribed collection successfully.\n";
		}
	}
	if (!check) col->removeSubcribers(this->getUsername());
	else cout << "You did not subscribe to this collection." << endl;
}

void member::displayCollection()
{
	for (int i = 0; i < listSub.size(); i++) {
		if ((listSub[i]->getName().size()) > 1) {
			cout << listSub[i]->getName() << ": " << endl;
			listSub[i]->display();
		}
	}
	cout << endl;
}

void member::displayBorrowed()
{
	if (listBook.size() > 0) {
		for (int i = 0; i < listBook.size(); i++) {
			cout << i + 1 << ". " << listBook[i]->getTitle() << " " << endl;
		}
	}
	else cout << "You borrow no book." << endl;
}

int member::getlistBooksize()
{
	return (listBook.size());
}

int member::getlistSubsize()
{
	return (listSub.size());
}

member* member::Login(vector<member*>& listAcc)
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

