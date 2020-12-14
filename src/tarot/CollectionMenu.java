package tarot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CollectionMenu  extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Deck deck;
	JPanel panel = new JPanel();
	JButton home = new JButton("Accueil");
	JButton addCard = new JButton("Ajouter une nouvelle carte");
	JButton searchCard = new JButton("Rechercher");
	
	
	public CollectionMenu(Deck deck) {
		this.deck = deck;
		
		panel.add(this.home);
		panel.add(this.addCard);
		panel.add(this.searchCard);	
		addCard.addActionListener(this);
		home.addActionListener(this);
		searchCard.addActionListener(this);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==home) {
			Main.menuPanel.removeAll();
			Main.subMenu.removeAll();
			Main.updatePanel(new HomePanel(deck));
		}
		if(e.getSource()==addCard) {
			Main.addSubMenu(new AddCardMenu(deck));
			Main.updatePanel(new CollectionPanel(deck, deck.deck));
			
		}
		if(e.getSource()==searchCard) {
			Main.addSubMenu(new SearchMenu(deck));
			deck.updateLists();
			Main.updatePanel(new CollectionPanel(deck, deck.deck));
		
			
		}
		
		
		
		
	}
}
