package tarot;

import java.util.ArrayList;

public class Deck implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Card> deck = new ArrayList<Card>();
	public ArrayList<Card> searchDeck = new ArrayList<Card>();
	public String[] cardNames;
	public String[] cardNumbers;
	public String[] numbers;

	
	public Deck() {
		generateDeck();
		getLists();
	}
	
	public void generateDeck() {
		new Card();
		for(int i=0; i<Card.cardNames.size(); i++) {
			String mots[]=Card.cardNames.get(i).toLowerCase().split(" |\\'");
			
			String imgName;
			if(mots.length==1) {
				imgName = i+"-"+mots[0]+".jpg";
			} else {
				imgName = i+"-"+mots[0]+"-"+mots[1]+".jpg";
			}
			Card card =new Card(Card.cardNames.get(i), Card.romanNumbers.get(i), imgName);
			card.addDescription(Card.positives.get(i), Card.negatives.get(i));
			this.deck.add(card);
		}
		
	}
	
	public void reinitializeDeck(Card c) {
		this.deck.add(c);
		Card.cardNames.add(c.name);
		getLists();
		
	}
	

	
	public void getLists() {
		ArrayList<String> cardNamesList = new ArrayList<String>();
		cardNamesList.addAll(Card.cardNames);
		cardNames = cardNamesList.toArray(new String[cardNamesList.size()]);
		
		ArrayList<String> cardNumbersList = new ArrayList<String>();
		cardNumbersList.addAll(Card.romanNumbers); 
		cardNumbers = cardNumbersList.toArray(new String[cardNumbersList.size()]);

		ArrayList<String> numbersList = new ArrayList<String>();
		numbersList.addAll(Card.numbers); 
		numbers = numbersList.toArray(new String[numbersList.size()]);

	}

	
	public Card getCard(ArrayList<Card> d, int index) {
		return d.get(index);
	}
	
	public void deleteCard(Card c) {
		for(int i=0; i<Card.cardNames.size();i++) {
			if(Card.cardNames.get(i) == c.name) {
				Card.cardNames.remove(i);
				break;
			}
		}
		for(int i=0; i<Card.romanNumbers.size();i++) {
			if(Card.romanNumbers.get(i) == c.number) {
				Card.romanNumbers.remove(i);
				break;
			}
		}
		
		Card.numbers.set(0, c.number);
		
		deck.remove(c);
		System.out.println(deck);
		getLists();
		
	}
	
	public ArrayList<Card> searchByName(ArrayList<Card> d, String name) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<d.size(); i++) {
			//System.out.println(this.deck.get(i).name);
			if(d.get(i).name == name) {
				searchArray.add(d.get(i));
			}
		}
		return searchArray;
	}
	
	public ArrayList<Card> searchByNumber(ArrayList<Card> d, String number) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<this.deck.size(); i++) {
			//System.out.println(this.deck.get(i).number);
			if(this.deck.get(i).number == number) {
				searchArray.add(this.deck.get(i));
			}
		}
		return searchArray;
	}
	
	
	

	
}
