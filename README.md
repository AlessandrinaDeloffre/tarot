# Mystic tarot

This project aims to produce a playable divinatory tarot with the possibility to manipulate and personalize the deck of cards.

## Base classes : Card and Deck

In order to generate a deck of cards, I used two base classes Card and Deck with function as follow.

| CARD                   	|                                                                                                                                                                      	|                                                                                                                                                                     	|
|------------------------	|----------------------------------------------------------------------------------------------------------------------------------------------------------------------	|---------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| Constructors           	| Card()<br>Card(name, number, image, descriPositive, descriNegative)                                                                                                  	| used to populate the ArrayLists with the initial values<br>used to create individual cards (initials and new)                                                       	|
| Mandatory parameters   	| String name<br>String number<br>String image<br>String descriPositive<br>String descriNegative                                                                       	| name of the card<br>roman number of the card <br>name of the imageFile<br>positive adjective associated with the card<br>negative adjective asociated with the card 	|
| Additionnal parameters 	| ArrayList<String> cardNames<br>ArrayList<String> romanNumbers <br>ArrayList<String> additionnalNumbers<br>ArrayList<String> positives<br>ArrayList<String> negatives 	| list of names<br>list of numbers<br>list of numbers (to allow new cards to be created)<br>list of positive adjectives<br>list of negative adjectives                	|
| Functions              	| String getImageFile() <br>void updateCard(name, descriPositive, descriNegative)<br>void updateNumbers(number)                                                        	| returns the path to the image<br>updates a card <br>updates romanNumbers and additionnalNumbers when a new card is created                                          	|

| DECK                   	|                                                                                                                                                                                                                                          	|                                                                                                                                                                                                                                                                                                                                   	|
|------------------------	|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| Constructors           	| Deck()                                                                                                                                                                                                                                   	| calls generateDeck and updateLists                                                                                                                                                                                                                                                                                                	|
| Additionnal parameters 	| ArrayList<Card> deck<br>ArrayList<Card> searchDeck<br>String[] cardNames<br>String[] cardNumbers<br>String[] numbers                                                                                                                     	| arraylist of all the cards<br>subarraylist used with searchFunctions<br>array corresponding to arraylist name of Card<br>array corresponding to arraylist romanNumbers of Card<br>array corresponding to arraylist additionnalNumbers of Card                                                                                     	|
| Functions              	| void generateDeck()<br>void reinitializeDeck()<br>void updateLists()<br>Card getCard(ArrayList, index)<br>void deletedCard(Card c)<br>ArrayList<Card> searchByName(ArrayList, name)<br>ArrayList<Card> searchByNumber(ArrayList, number) 	| generates full deck according to the arraylists of Card<br>updates arraylists and arrays when a new card is added<br>updates arrays corresponding to arraylists of Card<br>returns Card from arraylist at given indew<br>deletes Card<br>populates searchArray with name parameter<br>populates searchArray with number parameter 	|


## Interface classes

I decided to divide the interface in multiple panels defined in Main : menuPanel, subMenu and mainPanel.
For each screen, there is a corresponding mainPanel class and menuPanel class. SubMenus are added as needed.
All menus carry the deck with them and they are called by the mainPanel classes.
Classes are linked as follow 

| MAINPANEL                                                                                     	| MENUS                      	| SUBMENUS                              	|
|-------------------------------------------------------------------------------------------------	|----------------------------	|---------------------------------------	|
| HomePanel(deck)                                                                                 	|                            	|                                       	|
| CollectionPanel(deck)                                                                           	| CollectionMenu(deck)       	| AddCardMenu(deck)<br>SearchMenu(deck) 	|
| SingleCardPanel(card)                                                                           	| SingleCardMenu(deck, card) 	| UpdateCardMenu(deck, card)            	|
| DrawCardPanel(deck, cards, type)<br>*cards is a subarraylist of deck*<br>*type = 1 or type = 2* 	| DrawCardMenu(deck)         	|                                       	|
 
## Navigation

The interface is launched on the HomePanel. This panel gives the user the choice between two main aspects of the project :
* Explore and personalize the card collection
* Draw the card to see your future

### Collection interface

#### Collection panel
The collection panel allows the user to :
* visualize all the cards
* add a new card
* rechercher des cartes
* visualize a single card
* return to home

#### Single card panel
The single card panel allows the user to :
* visualize a single card and its informations
* update the name and descriptions of the card
* delete the card
* return to collection panel
* return to home

### Draw cards interface
The draw cards interface only has one panel. It offers 2 types of draw : present reading and complete reading. 

Once the user chose his type of reading, the cards and theirs meaning will appear. 

The cards are drown by random and each of them has a specific meaning depending on the order of the draw.

### Global functions

Some functions are set in Main and used globally accross the panels, menus and submenus classes.

| Function                                	| Description                               	|
|-----------------------------------------	|-------------------------------------------	|
| void updatePanel(Jpanel panel)          	| empty global interface and repopulates it 	|
| void addMenu(Jpanel menu)               	| empty menu and repopulates it             	|
| void addSubMenu(Jpanel submenu)         	| empty subMenu and repopulates it          	|
| void createLabel(String text, int font) 	| returns a JLabel                          	|


## Backup of personalized deck

In order for the user to save the changes applied to the initial deck, the deck created in Main is saved in deck.ser file. 
