package tarot;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CollectionPanel  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	Deck deck;
	Card card;
	JLabel label;
	
	public CollectionPanel(Deck deck, ArrayList<Card> cards) {
		this.deck=deck;
		this.panel = new JPanel();
		Main.addMenu(new CollectionMenu(deck));
		
		
		for (int i =0; i<cards.size();i++) {
			
			this.card = deck.getCard(cards, i);
			this.label = new JLabel();
			int width = 150;
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.card.getImageFile()).getImage().getScaledInstance(width, (int) (width*1.85), Image.SCALE_SMOOTH));
			label.setIcon(imageIcon);
			final int index = i;
			label.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					Main.addMenu(new SingleCardMenu(deck,  deck.getCard(cards, index)));
					Main.changePanel(new SingleCardPanel( deck.getCard(cards, index)));
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseReleased(MouseEvent arg0) {}
				
			});
			panel.add(label);
		}
		int row = (int) Math.ceil(((double)cards.size())/6);
		panel.setLayout(new GridLayout(row, 6));
		this.add(Main.menuPanel);
		this.add(panel);
	}



	

}
