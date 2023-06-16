#pragma once
#include <iostream>
#include <string>

using namespace std;

class book
{
private:
	string title;
	string serialNumber;
	string author;
	int numPages;
	int numFree;
	string category;
	bool visibilityStatus;
	bool availabilityStatus;
public:
	book();
	~book();
	book(string, string, int, int, string, bool, bool);

	void setTitle(string);
	string getTitle();
	
	void setSerialNumber(string);
	string getSerialNumber();
	
	void setAuthor(string);
	string getAuthor();
	
	void setNumPages(int);
	int getNumPages();
	
	void setNumFree(int);
	int getNumFree();
	
	void setCategory(string);
	string getCategory();
	
	void setVisibilityStatus(bool);
	bool getVisibilityStatus();
	
	void setAvailabilityStatus(bool);
	bool getAvailabilityStatus();

};

