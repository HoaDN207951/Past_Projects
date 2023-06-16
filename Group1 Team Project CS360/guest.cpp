#include "guest.h"

int guest::guestCount = 0;

guest::guest()
{
	ID = guestCount++;
	this->setAccessLevel(guestLevel);
	guestCount++;
}

guest::~guest()
{
	guestCount--;
}

guest::guest(int id)
{
	ID = id;
}

void guest::setGuestID(int id)
{
	ID = id;
}

int guest::getGuestID()
{
	return ID;
}

void guest::register_Mem(vector<member*> &memberlist, collection* col)
{
	string user, pass, phone, full;
	int start, end, id = 0;
	member* newMember;
	cout << "New member's username: " << endl;
	cin >> user;
	cout << "New member's password: " << endl;
	cin >> pass;
	cout << "New member's phone number: " << endl;
	cin >> phone;
	cout << "New member's full name: " << endl;
	cin.ignore();
	getline(cin, full);
	cout << "Membership starts in year: " << endl;
	cin >> start;
	cout << "Membership ends in year: " << endl;
	cin >> end;
	newMember = new member(start, end, user, pass, phone, full);
	newMember->subcribe(col);
	memberlist.push_back(newMember);
	cout << "Membership registered successfully.\n";
}

void guest::read(book* b)
{
	cout << "You are reading " << b->getTitle() << "..." << endl << endl;
	cout << "You can read " << b->getNumFree() << " pages for free." << endl << endl;
}
