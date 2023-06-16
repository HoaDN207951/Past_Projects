#include "menu.h"

Menu::Menu()
{
	name = "Default name";
	description = "Default description";
	action = -1;
	subMenu.clear();
}

Menu::~Menu()
{
	if (!subMenu.empty()) {
		for (int i = 0; i < subMenu.size(); i++) {
			if (subMenu[i])
				delete subMenu[i];
		}
		subMenu.clear();
	}
}

Menu::Menu(string n, string d, string op, int a)
{
	this->name = n;
	this->description = d;
	this->optionName = op;
	this->action = a;
	subMenu.clear();
}

void Menu::setName(string n)
{
	this->name = n;
}

string Menu::getName()
{
	return name;
}

void Menu::setDes(string d)
{
	this->description = d;
}

string Menu::getDes()
{
	return description;
}

void Menu::setAct(int a)
{
	this->action = a;
}

int Menu::getAct()
{
	return action;
}

void Menu::setOpName(string op)
{
	this->optionName = op;
}

string Menu::getOpName()
{
	return optionName;
}

void Menu::displayMenu()
{
	cout << "=====" << this->name << "=====" << endl;
	cout << this->description << endl;
	for (int i = 0; i < subMenu.size(); i++) {
		cout << i + 1 << "." << subMenu[i]->getOpName() << endl;
	}
}

void Menu::addSubMenu(Menu* m)
{
	this->subMenu.push_back(m);
	m->subMenu.push_back(this);
}

void Menu::addSubMenuLog(Menu* m)
{
	this->subMenu.push_back(m);
}

void Menu::removeSubMenu()
{
	this->subMenu.pop_back();
}

void Menu::removeAllSubMenu()
{
	this->subMenu.clear();
}

Menu* Menu::getSubMenu(int index)
{
	if (index > 0 && index <= subMenu.size()) {
		index--;
		return subMenu[index];
	}
	else return nullptr;
}

int Menu::promptOption()
{
	while (true) {
		cout << "Pick an option: ";
		int option;
		cin >> option;
		try {
			if (cin.fail()) {
				throw "Invalid Input";
			}
			else if (option < 1 || option > subMenu.size()) {
				throw "Menu out of range";
			}
			else {
				return option;
			}
		}
		catch (const char* error) {
			cin.ignore();
			cin.clear();
			cout << "Error: " << error << endl;
		}
	}
}
