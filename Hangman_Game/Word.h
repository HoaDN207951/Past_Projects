#pragma once
#include <iostream>
#include <string>
using namespace std;
class Word
{
private:
	string text;
	string hint;
	string displayText;
	string des;

public:
	Word();
	Word(string t, string h, string d);
	~Word();

	string getText();
	void setText(string t);

	string getHint();
	void setHint(string h);

	string getDes();
	void setDes(string);

	void displayWord();

	int checkGuess(char n);
	bool updateDisplayText();
	bool checkWord(string w);
};

