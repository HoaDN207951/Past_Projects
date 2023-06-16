#include "Game.h"

Game::Game()
{
	
	wordLimit = hintLimit = failLimit = 0;

}

Game::~Game()
{
}

int Game::getFailLimit()
{
	return failLimit;
}

void Game::setFailLimit()
{
	cout << "Input the limit of failure: ";
	cin >> this->failLimit;
}

int Game::getHintLimit()
{
	return hintLimit;
}

void Game::setHintLimit(int hl)
{
	if (hl > 0 && hl <= wordLimit)
		hintLimit = hl;
	else cout << "Incorrect hint limit." << endl;
}

int Game::getWordLimit()
{
	return wordLimit;
}

void Game::setWordLimit(int wl)
{
	if (wl > 1 && wl < wordBank.size())
		wordLimit = wl;
	else cout << "Incorrect word limit or empty word bank." << endl;
}

void Game::addWord(string t, string h, string d)
{
	Word* w;
	w = new Word(t, h, d);
	wordBank.push_back(w);
}

void Game::resetWordBank()
{
	wordBank.clear();
}

void Game::shuffleWordBank()
{
	srand(unsigned int(time(NULL)));
	int count = 0;
	while (true) {
		int index1 = rand() % wordBank.size();
		int index2 = rand() % wordBank.size();
		if (index1 == index2) continue;
		Word* temp = wordBank[index1];
		wordBank[index1] = wordBank[index2];
		wordBank[index2] = temp;

		count++;
		if (count > 10) break;
	}
}

Word* Game::getOneWord(int index)
{
	return wordBank[index];
}

int Game::getSize()
{
	return wordBank.size();
}
