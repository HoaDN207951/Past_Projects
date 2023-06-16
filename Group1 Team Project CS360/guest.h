#pragma once
#include "user.h"
#include "book.h"
#include "member.h"
#include "collection.h"
class guest : public user
{
private:
	int ID;
	static int guestCount;
public:
	guest();
	~guest();
	guest(int);

	void setGuestID(int);
	int getGuestID();

	void register_Mem(vector<member*> &memberlist, collection* );

	void read(book* b);
};

