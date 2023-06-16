#pragma once
#include <vector>
#include <iostream>
#include "Word.h"
using namespace std;
class Game
{
private:
	
	int hintLimit, failLimit, wordLimit;
	vector<Word*> wordBank;
public:
	Game();
	~Game();

	int getFailLimit();
	void setFailLimit();

	int getHintLimit();
	void setHintLimit(int);

	int getWordLimit();
	void setWordLimit(int);

	void addWord(string, string, string);
	void resetWordBank();
	void shuffleWordBank();
	Word* getOneWord(int index);
	int getSize();
};
