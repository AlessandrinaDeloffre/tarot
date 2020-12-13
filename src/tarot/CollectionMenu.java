package tarot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CollectionMenu  extends JPanel implements ActionListener{
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
			Tarot.menuPanel.removeAll();
			Tarot.subMenu.removeAll();
			Tarot.changePanel(new HomePanel(deck));
		}
		if(e.getSource()==addCard) {
			Tarot.addSubMenu(new AddCardMenu(deck));
			Tarot.changePanel(new CollectionPanel(deck, deck.deck));
			
		}
		if(e.getSource()==searchCard) {
			Tarot.addSubMenu(new SearchMenu(deck));
			deck.getLists();
			Tarot.changePanel(new CollectionPanel(deck, deck.deck));
		
			
		}
		
		
		
		
	}
}
