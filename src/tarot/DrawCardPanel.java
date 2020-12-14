package tarot;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawCardPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JPanel subPanel;
	Deck deck;
	Card card;
	JLabel label;
	JPanel significations = new JPanel();
	JPanel titlesPanel = new JPanel();
	ArrayList<Card> cards;
	
	public DrawCardPanel(Deck deck, ArrayList<Card> cards, int type) {
		this.deck=deck;
		this.panel = new JPanel();
		this.cards=cards;
		this.subPanel = new JPanel();
		Main.addMenu(new DrawCardMenu(deck));
		if (type==1) {
			System.out.println("ici");
			titlesPanel.removeAll();
			significations.removeAll();
			ArrayList<Card> arrayOf5 = new ArrayList<Card>();
			
			String[] titles =  {"Vos amours", "Votre travail", "Votre famille", "Vos amis", "Votre état d'esprit"};
			
			for(int i =0; i<titles.length; i++) {
				titlesPanel.add(Main.createLabel(titles[i], 14));
			}
			
			for(int i=0; i<5; i++) {
				randomCards(arrayOf5);
				significations.add(Main.createLabel(arrayOf5.get(i).descriPositive, 14));
			}
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			titlesPanel.setLayout(new GridLayout(1, 5));
			subPanel.setLayout(new GridLayout(1, 5));
			significations.setLayout(new GridLayout(1, 5));
			
			panel.add(titlesPanel);
			generateDeck(arrayOf5);
			panel.add(significations);
		} else if (type==2) {
			titlesPanel.removeAll();
			significations.removeAll();
			ArrayList<Card> arrayOf3 = new ArrayList<Card>();
			
			String[] titles =  {"Passé", "Présent", "Futur"};
			
			for(int i =0; i<titles.length; i++) {
				titlesPanel.add(Main.createLabel(titles[i], 14));
			}
			
			for(int i=0; i<3; i++) {
				randomCards(arrayOf3);
				significations.add(Main.createLabel(arrayOf3.get(i).descriPositive, 14));
			}
	
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
			titlesPanel.setLayout(new GridLayout(1, 3));
			subPanel.setLayout(new GridLayout(1, 3));
			significations.setLayout(new GridLayout(1, 3));
			
			panel.add(titlesPanel);
			generateDeck(arrayOf3);
			panel.add(significations);
			
		}


		this.add(panel);
	}
	
	public void generateDeck(ArrayList<Card> array) {
		for (int i =0; i<array.size();i++) {
			
			this.card = deck.getCard(this.cards, i);
			this.label = new JLabel();
			int width = 150;
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.card.getImageFile()).getImage().getScaledInstance(width, (int) (width*1.85), Image.SCALE_SMOOTH));
			label.setIcon(imageIcon);
			@SuppressWarnings("unused")
			final int index = i;
			
			subPanel.add(label);
		}
		panel.add(subPanel);
	}
	
	public ArrayList<Card> randomCards(ArrayList<Card> array) {
		
		
		int rand =  (int)(Math.random() * (deck.deck.size()));
		if(checkRandom(rand, array)==false) {
			randomCards(array);
		} else {
		array.add(deck.deck.get(rand));
		}
	
		return array;
}

public boolean checkRandom(int rand, ArrayList<Card> array) {
	for(int y=0; y<array.size();y++) {
		if (deck.deck.get(rand)==array.get(y)) {
			return false;
		} 
	}
	return true;
}



	

}
