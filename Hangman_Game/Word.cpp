#include "Word.h"

Word::Word()
{
	text = "";
	hint = "";
}

Word::Word(string t, string h, string d)
{
	text = t;
	hint = h;
	des = d;
}

Word::~Word()
{
}

string Word::getText()
{
	return text;
}

void Word::setText(string t)
{
	text = t;
	this->displayText = t;
	for (int i = 0; i < t.size(); i++) {
		displayText[i] = '_';
	}
}

string Word::getHint()
{
	return hint;
}

void Word::setHint(string h)
{
	hint = h;
}

string Word::getDes()
{
	return des;
}

void Word::setDes(string d)
{
	des = d;
}

void Word::displayWord()
{
	cout << "The word has total: " << text.length() << " characters!" << endl;
	cout << displayText << endl;
}

int Word::checkGuess(char n){
	int occurence = 0;
	for (int i = 0; i < text.length(); i++) {
		if (text[i] == n) {
			occurence++;
			displayText[i] = n;
		}
	}
	return occurence;
}

bool Word::updateDisplayText()
{
	bool check = true;
	for (int i = 0; i < text.length(); i++) {
		if (displayText[i] == '_') return false;
	}
	return check;
}

bool Word::checkWord(string w)
{
	if (w == text) {
		for (int i = 0; i < w.size(); i++) {
			displayText[i] = w[i];
		}
		return true;
	}
	else return false;
}



