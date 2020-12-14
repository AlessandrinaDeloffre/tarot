# Mystic tarot

This project aims to produce a playable divinatory tarot with the possibility to manipulate and personalize the deck of cards.

## Base classes : Card and Deck

In order to generate a deck of cards, I used two base classes 


| Constructors           	| Card()<br>Card(name, number, image, descriPositive, descriNegative)                                                                                                  	| used to populate the ArrayLists with the initial values<br>used to create individual cards (initials and new)                                                       	|
|------------------------	|----------------------------------------------------------------------------------------------------------------------------------------------------------------------	|---------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| Mandatory parameters   	| String name<br>String number<br>String image<br>String descriPositive<br>String descriNegative                                                                       	| name of the card<br>roman number of the card <br>name of the imageFile<br>positive adjective associated with the card<br>negative adjective asociated with the card 	|
| Additionnal parameters 	| ArrayList<String> cardNames <br>ArrayList<String> romanNumbers <br>ArrayLsi<String> additionnalNumbers<br>ArrayList<String> positives<br>ArrayList<String> negatives 	| list of names<br>list of numbers<br>list of numbers (to allow new cards to be created)<br>list of positive adjectives<br>list of negative adjectives                	|
| Functions              	| String getImageFile() <br>void updateCard(name, descriPositive, descriNegative)<br>void updateNumbers(number)                                                        	| returns the path to the image<br>updates a card <br>updates romanNumbers and additionnalNumbers when a new card is created                                          	|



