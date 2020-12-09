package tarot;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Deck extends JPanel {
	public ArrayList<Card> deck = new ArrayList<Card>();
	public ArrayList<Card> deckMajor = new ArrayList<Card>();
	public ArrayList<Card> deckMinor = new ArrayList<Card>();
	public JPanel panel;
	public JFrame window;
	public String deckType;
	public Deck(String type) {
		if(type=="major") {
			this.deck = new CardMajor().deck;
			this.deckType=type;
		} else if(type=="minor") {
			this.deck = new CardMinor().deck;
			this.deckType=type;
		} else if (type=="complete"){
			this.deckMajor = new CardMajor().deck;
			this.deck= this.deckMajor;
			this.deckMinor = new CardMinor().deck;
			deck.addAll(this.deckMinor);
			this.deckType=type;
		}
	}
	
	public Deck() {
		
			this.deckMajor = new CardMajor().deck;
			this.deck= this.deckMajor;
			this.deckMinor = new CardMinor().deck;
			deck.addAll(this.deckMinor);
			//this.deckType=type;
		
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
		deck.remove(c);
		if(c.type=="major") {
			deckMajor.remove(c);
		} else if (c.type=="minor") {
			deckMinor.remove(c);
		}
	}
	public void addCard(String name, int number, String image) {
		CardMajor newCard = new CardMajor(name, number, image);
		deck.add(newCard);
	}
	
	public void suffleDeck(ArrayList<Card> d) {
		Collections.shuffle(d);
	}
	
	
	public void showDeck(ArrayList<Card> d) {
		for(int i=0;i<this.deck.size();i++) {
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
	
	public ArrayList searchByColor(ArrayList<Card> d, String color) {
		ArrayList<Card> searchArray = new ArrayList<Card>();
		for(int i=0;i<d.size(); i++) {
			//System.out.println(this.deck.get(i).name);
			
			if(((CardMinor)(d.get(i))).color == color) {
				searchArray.add(d.get(i));
			}
		}
		return searchArray;
	}
	

	
}
