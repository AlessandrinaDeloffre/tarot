package tarot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SearchMenu extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Deck deck;
	JPanel panel = new JPanel();
	JComboBox<String> cardNumber;
	JComboBox<String> cardName;
	ArrayList<Card> searchDeck = new ArrayList<Card>();
	JButton showAll = new JButton("Montrer toutes les cartes");
	public SearchMenu(Deck deck) {
		this.deck = deck;
		cardNumber = new JComboBox<String>(this.deck.cardNumbers); 
		cardName = new JComboBox<String>(this.deck.cardNames);
		cardNumber.addActionListener(this);
		cardName.addActionListener(this);
		panel.add(cardNumber);
		panel.add(cardName);	
		panel.add(this.showAll);
		
		this.add(panel);
		showAll.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cardNumber) {
			searchDeck = deck.searchByNumber(deck.deck,cardNumber.getSelectedItem().toString());
			Main.changePanel(new CollectionPanel(deck, searchDeck));
		}
		if(e.getSource()==cardName) {
			searchDeck = deck.searchByName(deck.deck, cardName.getSelectedItem().toString());
			Main.changePanel(new CollectionPanel(deck, searchDeck));
			
		}
		if(e.getSource()==showAll) {
			Main.subMenu.removeAll();
			Main.changePanel(new CollectionPanel(deck, deck.deck));
		}
		
	}
}
