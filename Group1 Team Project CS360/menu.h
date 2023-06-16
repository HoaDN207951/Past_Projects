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
	string optionName;
	vector<Menu*> subMenu;
	int action;
public:
	Menu();
	~Menu();
	Menu(string, string, string, int = -1);

	void setName(string);
	string getName();
	void setDes(string);
	string getDes();
	void setAct(int);
	int getAct();
	void setOpName(string);
	string getOpName();


	void displayMenu();
	void addSubMenu(Menu*);
	void addSubMenuLog(Menu*);
	void removeSubMenu();
	void removeAllSubMenu();
	Menu* getSubMenu(int index);

	int promptOption();
};

