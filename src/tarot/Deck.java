package tarot;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Deck implements java.io.Serializable{
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

	public void addCardToPanel(ArrayList<Card> d, int i, JPanel p) {
		JLabel label = new JLabel();
		int width = 150;
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.getCard(d, i).getImageFile()).getImage().getScaledInstance(width, (int) (width*1.85), Image.SCALE_SMOOTH));
		label.setIcon(imageIcon);
		p.add(label);

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
		getLists();
		
	}
	public void addCard(String name, String number, String image) {
		Card newCard = new Card(name, number, image);
		deck.add(newCard);
	}
	
	public void suffleDeck(ArrayList<Card> d) {
		Collections.shuffle(d);
	}
	
	
	public void showDeck(ArrayList<Card> d) {
		for(int i=0;i<d.size();i++) {
			System.out.println(d.get(i).toString());
		}
	}
	
	public void showCards(ArrayList<Card> cards) {
		for(int i=0;i<cards.size();i++) {
			System.out.println(cards.get(i).toString());
		}
	}
	
	public ArrayList searchByName(ArrayList<Card> d, String name) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<d.size(); i++) {
			//System.out.println(this.deck.get(i).name);
			if(d.get(i).name == name) {
				searchArray.add(d.get(i));
			}
		}
		return searchArray;
	}
	
	public ArrayList searchByNumber(ArrayList<Card> d, String number) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<this.deck.size(); i++) {
			System.out.println(this.deck.get(i).number);
			if(this.deck.get(i).number == number) {
				searchArray.add(this.deck.get(i));
			}
		}
		return searchArray;
	}
	
	
	

	
}
