package tarot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SingleCardMenu extends JPanel implements ActionListener {
	Deck deck;
	Card card;
	JPanel panel = new JPanel();
	JButton home = new JButton("Accueil");
	JButton updateCard = new JButton("Mettre la carte à jour");
	JButton deleteCard = new JButton("Supprimer la carte");
	JButton showAll = new JButton("Montrer toutes les cartes");
	public SingleCardMenu(Deck deck, Card card) {
		this.deck = deck;
		this.card = card;
		panel.add(this.home);
		panel.add(this.updateCard);
		panel.add(this.deleteCard);	
		panel.add(this.showAll);
		updateCard.addActionListener(this);
		home.addActionListener(this);
		deleteCard.addActionListener(this);
		showAll.addActionListener(this);
		this.add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home) {
			Tarot.menuPanel.removeAll();
			Tarot.subMenu.removeAll();
			Tarot.changePanel(new HomePanel(deck));
		}
		
		if(e.getSource()==updateCard) {
			Tarot.addSubMenu(new UpdateCardMenu(deck, card));
			Tarot.changePanel(new SingleCardPanel(card));
			
		}
		if(e.getSource()==deleteCard) {
			deck.deleteCard(card);	
			Tarot.addMenu(new CollectionMenu(deck));
			Tarot.changePanel(new CollectionPanel(deck, deck.deck));
		}
		if(e.getSource()==showAll) {
			
			Tarot.subMenu.removeAll();
			Tarot.addMenu(new CollectionMenu(deck));
			Tarot.changePanel(new CollectionPanel(deck, deck.deck));
		}
	}
}
