package tarot;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public ArrayList<Card> deck = new ArrayList<Card>();
	public String deckType;
	public Deck(String type) {
		if(type=="major") {
			this.deck = new CardMajor().deck;
			this.deckType=type;
		} else if(type=="minor") {
			this.deck = new CardMinor().deck;
			this.deckType=type;
		} else if (type=="complete"){
			this.deck=new CardMajor().deck;
			deck.addAll(new CardMinor().deck);
			this.deckType=type;
		}
	}
	
	public Card getCard(int index) {
		return this.deck.get(index);
	}
	
	public void deleteCard(Object c) {
		deck.remove(c);
	}
	
	public void deleteCard(int index) {
		deck.remove(index);
	}
	
	public void suffleDeck() {
		Collections.shuffle(this.deck);
	}
	
	
	public void showDeck() {
		for(int i=0;i<this.deck.size();i++) {
			System.out.println(this.deck.get(i).toString());
		}
	}
	
	public void showCards(ArrayList<Card> cards) {
		for(int i=0;i<cards.size();i++) {
			System.out.println(cards.get(i).toString());
		}
	}
	
	public ArrayList searchByName(String name) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<this.deck.size(); i++) {
			//System.out.println(this.deck.get(i).name);
			if(this.deck.get(i).name == name) {
				searchArray.add(this.deck.get(i));
			}
		}
		return searchArray;
	}
	
	public ArrayList searchByNumber(int number) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<this.deck.size(); i++) {
			//System.out.println(this.deck.get(i).name);
			if(this.deck.get(i).number == number) {
				searchArray.add(this.deck.get(i));
			}
		}
		return searchArray;
	}
	
	public ArrayList searchByColor(String color) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<this.deck.size(); i++) {
			//System.out.println(this.deck.get(i).name);
			
			if(((CardMinor)(this.deck.get(i))).color == color) {
				searchArray.add(this.deck.get(i));
			}
		}
		return searchArray;
	}
	

	
}
