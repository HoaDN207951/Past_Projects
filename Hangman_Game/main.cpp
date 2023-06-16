#include <iostream>
#include "Menu.h"
#include "Game.h"
#include "Challenger.h"

using namespace std;

enum ACTIONTYPE {
	PLAY_GAME,
	LETTER_GUESS,
	WORD_GUESS,
	WORD_HINT,
	EXIT_GAME,
	HINT_SETTING,
	FAIL_SETTING,
	WORD_SETTING,
	ADD_WORD,
	RESET_BANK,
	CHALL_LOG,
	LOGOUT,
};

void main() {

	Challenger* chall;
	chall = new Challenger("root", "root");

	vector<Challenger*> listChall;
	listChall.push_back(chall);

	Challenger* currentChall = nullptr;

	Menu* mainMenu = new Menu("Main Menu", "The game main menu");
	Menu* challengerMenu = new Menu("Challenger Menu", "Menu for Challengers", CHALL_LOG);
	Menu* playMenu = new Menu("Play Game", "Playing the game", PLAY_GAME);
	Menu* exitMenu = new Menu("Exit Game", "Bye", EXIT_GAME);
	mainMenu->addSubmenu(challengerMenu);
	mainMenu->addSubmenuLog(playMenu);
	mainMenu->addSubmenu(exitMenu);

	Menu* Logout = new Menu("Logout", "Logout page", LOGOUT);
	Logout->addSubmenuLog(mainMenu);

	Menu* guessLetter = new Menu("Guess a Letter", "Guess a Letter", LETTER_GUESS);
	Menu* guessWord = new Menu("Guess the Word", "Guess the Word", WORD_GUESS);
	Menu* getHint = new Menu("Get a hint", "Get a hint", WORD_HINT);

	Menu* winMenu = new Menu("Winner", "Winner");
	Menu* loseMenu = new Menu("Loser", "Loser");
	winMenu->addSubmenuLog(playMenu);
	loseMenu->addSubmenuLog(playMenu);

	Menu* settingMenu = new Menu("Game Settings Menu", "The game settings menu");
	Menu* wordBankMenu = new Menu("Word Bank Menu", "The word bank menu");

	Menu* setHint = new Menu("Hint Settings", "Set the maximum hints can be used", HINT_SETTING);
	Menu* setFail = new Menu("Fail Settings", "Set the maximum failures in the game", FAIL_SETTING);
	Menu* setWord = new Menu("Word Settings", "Set the number of words in a game", WORD_SETTING);
	settingMenu->addSubmenu(setHint);
	settingMenu->addSubmenu(setFail);
	settingMenu->addSubmenu(setWord);

	Menu* addWord = new Menu("Add Word", "Add words to the word bank", ADD_WORD);
	Menu* resetBank = new Menu("Reset Word Bank", "Remove all words in the word bank", RESET_BANK);
	wordBankMenu->addSubmenu(addWord);
	wordBankMenu->addSubmenu(resetBank);

here:
	Menu* currentMenu = mainMenu;
	Game* currentGame = new Game;
	Word* currentWord = new Word;

	currentGame->addWord("cat", "chase mouse", "an indoor animal");
	currentGame->addWord("dog", "chase cat", "an land animal");
	currentGame->addWord("dragon", "famous fantasy animal", "not real animal");
	currentGame->addWord("whale", "biggest animal in ocean", "an big animal");
	currentGame->addWord("football", "king of sport", "a sport");
	currentGame->addWord("friction", "the force created when scrupt two things together", "a physic force");
	currentGame->addWord("property", "valuable personal that one owns", "a thing");
	currentGame->addWord("dimension", "1d, 2d, 3d, 4d, ....", "a noun to define sides or size");
	currentGame->addWord("steel", "weaker than iron", "a metal");
	currentGame->addWord("programmer", "saddest job", "an occupation");
	currentGame->addWord("oop", "saddest subject", "a subject");
	currentGame->addWord("persona", "same as personality", "a feature of a person");
	currentGame->addWord("tottenham", "lmao no trophy club", "a football club");
	currentGame->addWord("cinema", "place to see movies", "a place");

	currentGame->setWordLimit(10);
	currentGame->setFailLimit();
	currentGame->setHintLimit(3);
	bool check = true;
	while (true) {
		int hintC = 0, failC = 0;
		int num;
		char choice = '\0', k;
		bool test = true;
		//bool check = true;
		int wordC = currentGame->getWordLimit();
		string word, hint, guess;
		currentMenu->displayMenu();
		int opt = currentMenu->promptOption();
		currentMenu = currentMenu->getSubMenu(opt);
		system("cls");
		switch (currentMenu->getAction()) {
		case -1:
			///
			break;
		case PLAY_GAME:
			playMenu->addSubmenu(guessLetter);
			playMenu->addSubmenu(guessWord);
			playMenu->addSubmenu(getHint);
			playMenu->addSubmenuLog(Logout);
			system("cls");
			currentGame->shuffleWordBank();
			do {
				system("cls");
				cout << "Playing the game" << endl;
				cout << "The amount of words you can play: " << wordC << endl;
				cout << "The amount of fail you have reached: " << failC << endl;
				cout << "The amount of hints you have used: " << hintC << endl;
				if (check) cout << "true";
				else cout << "false";
				if (check) {
					num = rand() % currentGame->getSize();
					currentWord = currentGame->getOneWord(num);
					//cout << " " << currentWord->getText() << endl;
					currentWord->setText(currentWord->getText());
				}
				//currentWord->setText(currentWord->getText());
				currentWord->displayWord();
				cout << "Description: " << currentWord->getDes() << endl;
				currentMenu->displayMenu();
				opt = currentMenu->promptOption();
				currentMenu = currentMenu->getSubMenu(opt);
				system("cls");
				switch (currentMenu->getAction()) {
				case -1:
					///
					break;
				case LETTER_GUESS:
					if (wordC != 0) {
						do {
							cout << "Enter a character of your guess: ";
							cin >> choice;

							num = currentWord->checkGuess(choice);
							if (num > 0) {
								cout << "There are " << num << " character " << choice << " in the word.\n";
								currentWord->displayWord();
							}
							else {
								cout << "There is no such letter in the word.\n";
								failC++;
							}

							if (currentWord->updateDisplayText() == true) {
								cout << "You guess the correct word. You win.\n";
								currentWord->displayWord();
								wordC--;
								check = true;
								currentMenu = winMenu;
								currentMenu->displayMenu();
								opt = currentMenu->promptOption();
								currentMenu = currentMenu->getSubMenu(opt);
								check = true;
								break;
							}
							else {
								cout << "Do you want to continue? Y/N: ";
								cin >> choice;
								if (choice == 'n' || choice == 'N') check = false;
							}
						} while ((choice == 'y' || choice == 'Y') && failC <= (currentGame->getFailLimit()) && !(currentWord->updateDisplayText()));

						if (failC > (currentGame->getFailLimit())) {
							cout << "You reached fail limit. You lose.\n";
							wordC--;
							check = true;
							currentMenu = loseMenu;
							currentMenu->displayMenu();
							opt = currentMenu->promptOption();
							currentMenu = currentMenu->getSubMenu(opt);
						}
					}
					else cout << "You have reached word limit per game.\n";
					break;

				case WORD_GUESS:
					if (wordC != 0) {
						do {
							cout << "Enter your word guess: ";
							cin >> guess;
							if (currentWord->checkWord(guess)) {
								cout << "You guess the correct word. You win.\n";
								currentWord->displayWord();
								wordC--;
								check = true;
								currentMenu = winMenu;
								currentMenu->displayMenu();
								opt = currentMenu->promptOption();
								currentMenu = currentMenu->getSubMenu(opt);
								break;
							}
							else {
								cout << "Your word guess is wrong.\n";
								failC++;
								cout << "Do you want to continue? Y/N: ";
								cin >> choice;
								if (choice == 'n' || choice == 'N') check = false;
							}
						} while ((choice == 'y' || choice == 'Y') && failC <= (currentGame->getFailLimit()) && !(currentWord->checkWord(guess)));

						if (failC > (currentGame->getFailLimit())) {
							cout << "You reached fail limit. You lose.\n";
							wordC--;
							check = true;
							currentMenu = loseMenu;
							currentMenu->displayMenu();
							opt = currentMenu->promptOption();
							currentMenu = currentMenu->getSubMenu(opt);
						}
					}
					else cout << "You have reached word limit per game.\n";
					break;

				case WORD_HINT:
					if (wordC != 0 && hintC < currentGame->getHintLimit()) {
						cout << "Hint: " << currentWord->getHint() << endl;
						hintC++;
						if (hintC == currentGame->getHintLimit()) cout << "You reach the limit of hints for the game.\n";
					}
					if(wordC == 0) cout << "You have reached word limit per game.\n";
					check = false;
					cout << "Enter any key to go back: ";
					cin >> k;
					break;

				case LOGOUT:
					playMenu->removeAllSubMenu();
					guessLetter->removeSubMenu();
					guessWord->removeSubMenu();
					getHint->removeSubMenu();
					test = false;
					break;
				}
			} while (test);
			break;

		case EXIT_GAME:
			cout << "Exiting the game" << endl;
			exit(0);
		case CHALL_LOG:
			currentChall = currentChall->Login(listChall);
			while (!(currentChall)) {
				cout << "Wrong username or password.\n";
				cout << "Type Y to return to main menu, N to try again: ";
				cin >> choice;
				if (choice == 'y' || choice == 'Y') {
					system("cls");
					goto here;
				}
				currentChall = currentChall->Login(listChall);
			}
			challengerMenu->addSubmenu(settingMenu);
			challengerMenu->addSubmenu(wordBankMenu);
			challengerMenu->addSubmenuLog(Logout);
			system("cls");
			do {
				currentMenu->displayMenu();
				opt = currentMenu->promptOption();
				currentMenu = currentMenu->getSubMenu(opt);
				system("cls");
				switch (currentMenu->getAction()) {

				case -1:
					///
					break;
				case FAIL_SETTING:
					do {
						currentGame->setFailLimit();
						cout << "Do you want to continue? Y/N: ";
						cin >> choice;
					} while (choice == 'y' || choice == 'Y');
					break;
				case HINT_SETTING:
					do {
						cout << "Enter the limit for hints per game: ";
						cin >> num;
						currentGame->setHintLimit(num);
						cout << "Do you want to continue? Y/N: ";
						cin >> choice;
					} while (choice == 'y' || choice == 'Y');
					break;
				case WORD_SETTING:
					do {
						cout << "Enter the limit for words to be guessed per game: ";
						cin >> num;
						currentGame->setWordLimit(num);
						cout << "Do you want to continue? Y/N: ";
						cin >> choice;
					} while (choice == 'y' || choice == 'Y');
					break;
				case ADD_WORD:
					do {
						cout << "Enter a word: ";
						cin >> word;
						cout << "Enter the word's hint: ";
						cin.ignore();
						getline(cin, hint);
						currentGame->addWord(word, hint, word);
						cout << "Add word is called.\n";
						cout << "Do you want to continue? Y/N: ";
						cin >> choice;
					} while (choice == 'y' || choice == 'Y');
					break;
				case RESET_BANK:
					cout << "Resetting word bank...";
					currentGame->resetWordBank();
					cout << "Reset is called.\n";
					break;
				case LOGOUT:
					challengerMenu->removeAllSubMenu();
					settingMenu->removeSubMenu();
					wordBankMenu->removeSubMenu();

					test = false;
					break;
				default:
					break;
				};
			} while (test);
			break;
		default:
			cout << "Default action" << endl;
		}
	};
	system("pause");
}