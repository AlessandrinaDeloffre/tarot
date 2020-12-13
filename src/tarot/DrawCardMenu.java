package tarot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawCardMenu extends JPanel implements ActionListener{
	Deck deck;
	JPanel panel = new JPanel();
	JButton home = new JButton("Accueil");
	
	JButton draw1 = new JButton("Lecture du présent");
	JButton draw2 = new JButton("Lecture de la vie");
	
	public DrawCardMenu (Deck deck) {
		this.deck=deck;
		panel.add(home);
		panel.add(draw1);
		panel.add(draw2);
		
		home.addActionListener(this);
		draw1.addActionListener(this);
		draw2.addActionListener(this);
		
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==home) {
			Tarot.menuPanel.removeAll();
			Tarot.subMenu.removeAll();
			Tarot.changePanel(new HomePanel(deck));
		}
		
		if(e.getSource()==draw1) {
			Tarot.changePanel(new DrawCardPanel(deck, deck.deck, 1));
		}
		
		if(e.getSource()==draw2) {
			Tarot.changePanel(new DrawCardPanel(deck, deck.deck, 2));
		}
		
		
	}
}
