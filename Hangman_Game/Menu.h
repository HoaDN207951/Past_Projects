#pragma once
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Menu
{
private:
	string name;
	string description;
	vector<Menu*> subMenu;
	int action;
public:
	Menu();
	~Menu();
	Menu(string, string, int = -1);

	void setName(string);
	string getName();
	void setDes(string);
	string getDes();
	void setAction(int);
	int getAction();

	void displayMenu();
	void addSubmenu(Menu*);
	void addSubmenuLog(Menu*);
	Menu* getSubMenu(int index);
	void removeSubMenu();
	void removeAllSubMenu();

	int promptOption(); 
};

