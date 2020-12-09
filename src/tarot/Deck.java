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
	public JPanel panel;
	public JFrame window;
	public String deckType;
	public Deck(String type) {
		System.out.println("newDeck");
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
	
	public void generateWindow() {
		this.panel = new JPanel();
		this.window = new JFrame("Tarot");
		this.window.setSize(1000, 1000);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setVisible(true);
	}
	
	public void addCardToPanel(int i, JPanel p) {
		JLabel label = new JLabel();
		int width = 150;
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.getCard(i).getImageFile()).getImage().getScaledInstance(width, (int) (width*1.85), Image.SCALE_SMOOTH));
		label.setIcon(imageIcon);
		p.add(label);

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
