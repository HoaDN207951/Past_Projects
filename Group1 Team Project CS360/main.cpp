#include <iostream>
#include <cstdlib>
#include <vector>
#include "book.h"
#include "admin.h"
#include "collection.h"
#include "guest.h"
#include "member.h"
#include "menu.h"

using namespace std;

enum ACTIONTYPE {
	READ_G, REG_G, ADMIN_LOGIN, MEM_LOGIN, BOOK_ADD,
	ADMIN_ADD, SHOW_BOOK, HIDE_BOOK, REMOVE_BOOK, DIS_ALL_BK,
	EDIT_BOOK, COLL_ADD, COLL_REMOVE, EDIT_COLL, BORROW_BOOK,
	RETURN_BOOK, SUB_COLLECTION, UNSUB_COLLECTION, DIS_SUB_COLL, DIS_BRW_BOOK,
	READ_M, DIS_ALL_COL, LOGOUT, EXIT, SEARCH_BOOK
};

int main()
{
	char choice;
	string input;
	admin* root;
	root = new admin("root", "root", "root", "root");

	admin* currentAdmin = nullptr;
	member* currentMember = nullptr;
	book* currentBook = nullptr;
	collection* currentCol = nullptr;
	collection* Sample;
	Sample = new collection("Sample");

	vector<book*> listBook;
	vector<member*> listMember;
	vector<admin*> listAdmin;
	vector<collection*> listCollection;

	listAdmin.push_back(root);

	guest* tempGuest;
	tempGuest = new guest();

	book* book1 = new book("Gulliver's Travels", "Jonathan Swift", 240, 20, "Fiction", true, true); listBook.push_back(book1);
	book* book2 = new book("Robinson Crusoe", "Daniel Dafoe", 353, 25, "Fiction", true, true); listBook.push_back(book2);
	book* book3 = new book("Romeo and Juliet", "William Shakespeare", 281, 20, "Romance", true, true); listBook.push_back(book3);
	book* book4 = new book("Kafka on the Shore", "Haruki Murakami", 467, 50, "Fiction", true, true); listBook.push_back(book4);
	book* book5 = new book("Becoming", "Michelle Obama", 426, 50, "Biography", true, true); listBook.push_back(book5);

	Sample->addBook(book1);
	Sample->addBook(book2);
	Sample->addBook(book3);
	listCollection.push_back(Sample);

	Menu* mainMenu = new Menu("Main Menu", "The game main menu", "Back to main menu");
	Menu* accMenu = new Menu("Registered User Login", "Login as a registered user", "Registered User Login");
	Menu* guestMenu = new Menu("Guest Menu", "Menu for guest", "Guest Menu");
	Menu* exit_lib = new Menu("Exit", "Exiting", "Exit", EXIT);
	Menu* search_b = new Menu("Search Book", "Search for a book by title/serial", "Search Book", SEARCH_BOOK);
	mainMenu->addSubMenu(accMenu);
	mainMenu->addSubMenu(guestMenu);
	mainMenu->addSubMenu(search_b);
	mainMenu->addSubMenu(exit_lib);

	Menu* read_g = new Menu("Reading For Guest", "Reading page for guest", "Read a book", READ_G);
	Menu* register_g = new Menu("Register For New Member", "Register page for non registered user", "Membership Register", REG_G);
	guestMenu->addSubMenu(read_g);
	guestMenu->addSubMenu(register_g);

	Menu* adminPage = new Menu("Admin Menu", "Menu for admin", "Admin Menu", ADMIN_LOGIN);
	Menu* memPage = new Menu("Member Menu", "Menu for member", "Member Menu", MEM_LOGIN);
	accMenu->addSubMenuLog(adminPage);
	accMenu->addSubMenuLog(memPage);

	Menu* bookSetting = new Menu("Book Settings", "Book management", "Book Settings");
	Menu* collectionSetting = new Menu("Collection Setting", "Collection management", "Collection Settings");
	Menu* Logout = new Menu("Logout", "Logout page", "Logout", LOGOUT);

	Logout->addSubMenuLog(mainMenu);

	Menu* addBook = new Menu("Adding Book", "Book Addition Settings", "Adding Book", BOOK_ADD);
	Menu* addAdmin = new Menu("Adding Admin", "Admin Adition Settings", "Adding Admin", ADMIN_ADD);
	Menu* showBook = new Menu("Show Book", "Book Visibility to Apparent", "Show Book", SHOW_BOOK);
	Menu* hideBook = new Menu("Hide Book", "Book Visibility to Hidden", "Hide Book", HIDE_BOOK);
	Menu* removeBook = new Menu("Remove Book", "Book Removal", "Remove Book", REMOVE_BOOK);
	Menu* displayBook = new Menu("Display Books", "Display All Books", "Display Books", DIS_ALL_BK);
	Menu* editBook = new Menu("Edit Book", "Edit Book's Info", "Edit Book", EDIT_BOOK);
	Menu* addCollection = new Menu("Adding Collection", "Collection Addition Settings", "Adding Collection", COLL_ADD);
	Menu* removeCollection = new Menu("Remove Collection", "Collection Removal", "Remove Collection", COLL_REMOVE);
	Menu* editCollection = new Menu("Edit Collection", "Edit Collection's Info", "Edit Collection", EDIT_COLL);
	Menu* displayCollection = new Menu("Display Collections", "Display All Collections", "Display Collections", DIS_ALL_COL);

	bookSetting->addSubMenu(addBook);
	bookSetting->addSubMenu(showBook);
	bookSetting->addSubMenu(hideBook);
	bookSetting->addSubMenu(removeBook);
	bookSetting->addSubMenu(displayBook);
	bookSetting->addSubMenu(editBook);
	collectionSetting->addSubMenu(addCollection);
	collectionSetting->addSubMenu(removeCollection);
	collectionSetting->addSubMenu(editCollection);
	collectionSetting->addSubMenu(displayCollection);

	Menu* read_m = new Menu("Reading For Member", "Reading page for member", "Read a book", READ_M);
	Menu* borrow = new Menu("Borrow Book", "Borrow Book Menu", "Borrow Book", BORROW_BOOK);
	Menu* return_B = new Menu("Return Book", "Return Book Menu", "Return Book", RETURN_BOOK);
	Menu* subcribe = new Menu("Subcribe Collection", "Subcribe Collection Menu", "Subcribe Collection", SUB_COLLECTION);
	Menu* unSubcribe = new Menu("Unsubcribe Collection", "Unsubcribe Collection Menu", "Unsubcribe Collection", UNSUB_COLLECTION);
	Menu* displaySubCollection = new Menu("Display Subcribed Collections", "Subcribed Collections Displayment", "Display Subcribed Collections", DIS_SUB_COLL);
	Menu* displayBorrowed = new Menu("Display Borrowed Books", "Borrowed Books Displayment", "Display Borrowed Books", DIS_BRW_BOOK);
here:
	Menu* currentMenu = mainMenu;
	while (true) {
		currentMenu->displayMenu();
		string in;
		bool test = true;
		char type;
		int opt = currentMenu->promptOption();
		currentMenu = currentMenu->getSubMenu(opt);
		cout << endl;
		system("cls");
		switch (currentMenu->getAct()) {
		case -1:
			///
			break;
		case READ_G:
			cout << "Here is the Sample collection: " << endl;
			Sample->display();
			cout << endl;

			do {
				cout << "Which book do you want to read? Type in serial: ";
				cin >> input;
				cout << endl;
				if (tempGuest->searchbySerial(Sample->getCol(), input)) {
					currentBook = tempGuest->searchbySerial(Sample->getCol(), input);
					tempGuest->read(currentBook);
					currentBook = nullptr;
				}
				else cout << "There is no book with this serial number.\n";

				cout << "Do you want to read another book? Y/N: ";
				cin >> type;
			} while (type == 'y' || type == 'Y');
			cout << endl << endl;
			break;
		case REG_G:
			tempGuest->register_Mem(listMember, Sample);
			cout << endl << endl;
			break;
		case EXIT:
			cout << "Exiting the game" << endl;
			system("pause");
			exit(0);
		case SEARCH_BOOK:
			do {
				cout << "Search a book by title or serial number: ";
				cin.ignore();
				getline(cin, in);
				if (tempGuest->searchbySerial(listBook, in)) {
					currentBook = tempGuest->searchbySerial(listBook, in);
					cout << "Title: " << currentBook->getTitle() << endl;
					cout << "Serial: " << currentBook->getSerialNumber() << endl;
					cout << "Author: " << currentBook->getAuthor() << endl;
					cout << "Category: " << currentBook->getCategory() << endl;
				}
				else if ((tempGuest->searchbyTitle(listBook, in))) {
					currentBook = tempGuest->searchbyTitle(listBook, in);
					cout << "Title: " << currentBook->getTitle() << endl;
					cout << "Serial: " << currentBook->getSerialNumber() << endl;
					cout << "Author: " << currentBook->getAuthor() << endl;
					cout << "Category: " << currentBook->getCategory() << endl;
				}

				else cout << "There is no book with this title or serial number.\n\n";
				cout << "Do you want to continue searching books to library? Y/N: ";
				cin >> type;
			} while (type == 'y' || type == 'Y');
			break;
		case ADMIN_LOGIN:
			currentAdmin = currentAdmin->Login(listAdmin);
			while (!(currentAdmin)) {
				cout << "Wrong username or password.\n";
				cout << "Type Y to return to main menu, N to try again: ";
				cin >> choice;
				if (choice == 'y' || choice == 'Y') {
					system("cls");
					goto here;
				}
				currentAdmin = currentAdmin->Login(listAdmin);
			}
			adminPage->addSubMenu(addAdmin);
			adminPage->addSubMenu(bookSetting);
			adminPage->addSubMenu(collectionSetting);
			adminPage->addSubMenuLog(Logout);

			system("cls");
			do {
				cout << "Admin: " << currentAdmin->getUsername() << endl;
				currentMenu->displayMenu();
				opt = currentMenu->promptOption();
				currentMenu = currentMenu->getSubMenu(opt);
				system("cls");
				switch (currentMenu->getAct()) {
				case -1:
					///
					break;
				case BOOK_ADD:
					do {
						currentAdmin->addBook(listBook);
						cout << "Do you want to continue adding books to library? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case ADMIN_ADD:
					do {
						currentAdmin->createAdmin(listAdmin);
						cout << "Do you want to continue adding admins? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case SHOW_BOOK:
					type = ' ';
					do {
						cout << "Enter the serial number of the book you want to show: ";
						cin >> input;
						cout << endl;
						if (currentAdmin->searchbySerial(listBook, input)) {
							currentBook = currentAdmin->searchbySerial(listBook, input);
							currentAdmin->show(currentBook);
							currentBook = nullptr;
						}
						else cout << "There is no book with this serial number.\n";
						cout << "Do you want to continue showing books to library? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case HIDE_BOOK:
					do {
						cout << "Enter the serial number of the book you want to hide: ";
						cin >> input;
						cout << endl;
						if (currentAdmin->searchbySerial(listBook, input)) {
							currentBook = currentAdmin->searchbySerial(listBook, input);
							currentAdmin->hide(currentBook);
						}
						else cout << "There is no book with this serial number.\n";
						cout << "Do you want to continue hiding books from library? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case REMOVE_BOOK:
					cout << "Display all books: ";
					currentAdmin->display(listBook);
					do {
						cout << "Enter the serial number of the book you want to remove: ";
						cin >> input;
						cout << endl;
						if (currentAdmin->searchbySerial(listBook, input)) {
							currentBook = currentAdmin->searchbySerial(listBook, input);
							currentAdmin->remove(currentBook, listBook, listCollection);
							currentBook = nullptr;
						}
						else cout << "There is no book with this serial number.\n";
						cout << "Do you want to continue removing books from library? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case DIS_ALL_BK:
					cout << "Display all books: " << endl;
					currentAdmin->display(listBook);
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case EDIT_BOOK:
					do {
						cout << "Enter the serial number of the book you want to edit: ";
						cin >> input;
						cout << endl;
						if (currentAdmin->searchbySerial(listBook, input)) {
							currentBook = currentAdmin->searchbySerial(listBook, input);
							currentAdmin->edit(currentBook);
							currentBook = nullptr;
						}
						else cout << "There is no book with this serial number.\n";
						cout << "Do you want to continue editing books? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case COLL_ADD:
					do {
						currentAdmin->createCollection(listCollection);
						cout << "Do you want to continue adding collection to library? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case COLL_REMOVE:
					do {
						cout << "This is all of the collections: \n";
						currentAdmin->displayAllCollection(listCollection);
						currentAdmin->deleteCollection(listCollection);
						cout << "Do you want to continue removing collection from library? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case EDIT_COLL:
					do {
						cout << "This is all of the collections: \n";
						currentAdmin->displayAllCollection(listCollection);
						currentAdmin->editCollection(listBook, listCollection);
						cout << "Do you want to continue editing collections? Y/N: ";
						cin >> type;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case DIS_ALL_COL:
					cout << "Display all collections: " << endl;
					currentAdmin->displayAllCollection(listCollection);
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case LOGOUT:
					adminPage->removeAllSubMenu();
					bookSetting->removeSubMenu();
					collectionSetting->removeSubMenu();

					test = false;
					break;
				default:
					break;
				};
			} while (test);
			break;
		case MEM_LOGIN:
			test = true;
			currentMember = currentMember->Login(listMember);
			while (!(currentMember)) {
				cout << "Wrong username or password.\n";
				cout << "Type Y to return to main menu, N to try again: ";
				cin >> choice;
				if (choice == 'y' || choice == 'Y') {
					system("cls");
					goto here;
				}
				currentMember = currentMember->Login(listMember);
			}
			memPage->addSubMenu(read_m);
			memPage->addSubMenu(borrow);
			memPage->addSubMenu(return_B);
			memPage->addSubMenu(subcribe);
			memPage->addSubMenu(unSubcribe);
			memPage->addSubMenu(displaySubCollection);
			memPage->addSubMenu(displayBorrowed);
			memPage->addSubMenuLog(Logout);
			system("cls");
			do {
				cout << "Member: " << currentMember->getUsername() << endl;
				currentMenu->displayMenu();
				opt = currentMenu->promptOption();
				currentMenu = currentMenu->getSubMenu(opt);
				system("cls");
				switch (currentMenu->getAct()) {
				case -1:
					///
					break;
				case READ_M:
					do {
						cout << "Which book do you want to read? Type in serial number: ";
						cin >> input;
						cout << endl;
						if (currentMember->searchbySerial(listBook, input)) {
							currentBook = currentMember->searchbySerial(listBook, input);
							currentMember->read(currentBook);
							currentBook = nullptr;
						}
						else cout << "There is no book with this serial number.\n";
						cout << "Do you want to read another book? Y/N: ";
						cin >> type;
						cout << endl;
					} while (type == 'y' || type == 'Y');
					cout << endl << endl;
					break;
				case BORROW_BOOK:
					do {
						cout << "Enter the serial number of the book you want to borrow: ";
						cin >> input;
						cout << endl;
						if (currentMember->searchbySerial(listBook, input)) {
							currentBook = currentMember->searchbySerial(listBook, input);
							currentMember->borrow(currentBook);
							currentBook = nullptr;
						}
						else cout << "There is no book with this serial number.\n";
						cout << "Do you want to continue borrowing books? Y/N: ";
						cin >> type;
						cout << endl;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case RETURN_BOOK:
					do {
						cout << "Enter the serial number of the book you want to return: ";
						cin >> input;
						cout << endl;
						if (currentMember->searchbySerial(listBook, input)) {
							currentBook = currentMember->searchbySerial(listBook, input);
							currentMember->returnBook(currentBook);
							currentBook = nullptr;
						}
						else cout << "There is no book with this serial number.\n";
						cout << "Do you want to continue returning books? Y/N: ";
						cin >> type;
						cout << endl;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case SUB_COLLECTION:
					do {
						for (int i = 0; i < listCollection.size(); i++) {
							cout << listCollection[i]->getName() << ". ID: " << listCollection[i]->getId() << endl;
						}
						bool checkCol = true;
						cout << "Enter collection's name or id that you want to subscribe: ";
						cin >> in;
						for (int i = 0; i < listCollection.size(); i++) {
							if (listCollection[i]->getId() == in || listCollection[i]->getName() == in) {
								currentMember->subcribe(listCollection[i]);
								checkCol = false;
							}
						}
						if (checkCol == true) cout << "There is no collection with this id or this name.\n";
						cout << "Do you want to continue subscribing collections? Y/N: ";
						cin >> type;
						cout << endl;
					} while (type == 'y' || type == 'Y');
					currentMember->displayCollection();
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case UNSUB_COLLECTION:
					do {
						bool checkCol = true;
						cout << "Enter collection's name or id that you want to unsubscribe: ";
						cin >> in;
						for (int i = 0; i < listCollection.size(); i++) {
							if (listCollection[i]->getId() == in || listCollection[i]->getName() == in) {
								currentMember->unsubcribed(listCollection[i]);
								checkCol = false;
							}
						}
						if (checkCol == true) cout << "There is no collection with this id.\n";
						cout << "Do you want to continue unsubscribing books? Y/N: ";
						cin >> type;
						cout << endl;
					} while (type == 'y' || type == 'Y');
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case DIS_SUB_COLL:
					if (currentMember->getlistSubsize() > 0) {
						cout << "This is your subcribed collections: \n";
						currentMember->displayCollection();
					}
					else cout << "You haven't subscribed to any collections.\n";
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case DIS_BRW_BOOK:
					if (currentMember->getlistBooksize() > 0) {
						cout << "This is your borrowed books: \n";
						currentMember->displayBorrowed();
					}
					else cout << "You haven't borrowed any books.\n";
					cout << "Do you want to return to previous menu?" << endl << endl;
					break;
				case LOGOUT:
					memPage->removeAllSubMenu();
					borrow->removeSubMenu();
					return_B->removeSubMenu();
					subcribe->removeSubMenu();
					unSubcribe->removeSubMenu();
					displaySubCollection->removeSubMenu();
					displayBorrowed->removeSubMenu();

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
	return 0;
}