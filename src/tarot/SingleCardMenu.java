package tarot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SingleCardMenu extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			Main.menuPanel.removeAll();
			Main.subMenu.removeAll();
			Main.changePanel(new HomePanel(deck));
		}
		
		if(e.getSource()==updateCard) {
			Main.addSubMenu(new UpdateCardMenu(deck, card));
			Main.changePanel(new SingleCardPanel(card));
			
		}
		if(e.getSource()==deleteCard) {
			deck.deleteCard(card);	
			Main.addMenu(new CollectionMenu(deck));
			Main.changePanel(new CollectionPanel(deck, deck.deck));
		}
		if(e.getSource()==showAll) {
			
			Main.subMenu.removeAll();
			Main.addMenu(new CollectionMenu(deck));
			Main.changePanel(new CollectionPanel(deck, deck.deck));
		}
	}
}
