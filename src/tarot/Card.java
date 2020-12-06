package tarot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card {
	protected int number;
	protected String type;
	protected String name;
	protected static Card [] deck = new Card[78];
	protected CardMajor[] deckMajor;
	protected CardMinor[] deckMinor;
	
	
	public Card() {

	}
	
	public Card(CardMajor[] deckMajor, CardMinor[] deckMinor) {
		generateDeck(deckMajor, deckMinor);
		this.deckMajor=deckMajor;
		this.deckMinor=deckMinor;
	}
	
	public Card(String name, int number) {
		this.number=number;
		this.type=null;
		this.name=name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void generateDeck(CardMajor[] deckMajor, CardMinor[] deckMinor) {
		for(int i=0;i<deckMajor.length;i++) {
			deck[i]=deckMajor[i];
		}
		for(int i=0;i<deckMinor.length;i++) {
			deck[i+deckMajor.length]=deckMinor[i];
		}
		
	}

	
	public void shuffleDeck(Card[] deck) {
		List<Card> cardList = Arrays.asList(deck);
		Collections.shuffle(cardList);
		cardList.toArray(deck);
	};
	

}
