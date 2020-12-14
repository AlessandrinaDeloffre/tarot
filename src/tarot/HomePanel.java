package tarot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePanel extends JPanel implements ActionListener{
	
	Deck deck;
	JPanel panel;
	JButton seeCollection = new JButton("Voir la collection");
	JButton drawCards = new JButton("Tirer les cartes");
	public HomePanel(Deck deck) {
		this.deck = deck;
		this.panel = new JPanel();
		panel.add(Tarot.createLabel("Bienvenue", 32));
		seeCollection.addActionListener(this);
		drawCards.addActionListener(this);
		panel.add(seeCollection);
		panel.add(drawCards);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.add(panel);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==seeCollection) {
			Tarot.changePanel(new CollectionPanel(deck, deck.deck));
		}
		if(e.getSource()==drawCards) {
			Tarot.changePanel(new DrawCardPanel(deck, deck.deck, 0));
		}
		
	}

}
