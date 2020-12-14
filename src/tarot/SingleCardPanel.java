package tarot;

import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SingleCardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Card card;
	JPanel panel;
	JLabel label;
	JLabel name = new JLabel();
	JPanel subPanel = new JPanel();
	
	public SingleCardPanel(Card card) {
		
		this.card = card;
		
		
		this.label = new JLabel();
		int width = 150;
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.card.getImageFile()).getImage().getScaledInstance(width, (int) (width*1.85), Image.SCALE_SMOOTH));
		label.setIcon(imageIcon);
		//final int index = i;
		this.panel = new JPanel();
		panel.add(label);
		
		
		name.setText(card.name);
		this.subPanel.add(Tarot.createLabel("Nom", 20));
		this.subPanel.add(name);
		
		if(card.descriPositive !=null) {
			JLabel descriPositive = new JLabel();
			descriPositive.setText(card.descriPositive);
			this.subPanel.add(Tarot.createLabel("Signification positive", 20));
			this.subPanel.add(descriPositive);
			}
			if(card.descriPositive !=null) {
			JLabel descriNegative = new JLabel();
			descriNegative.setText(card.descriNegative);
			this.subPanel.add(Tarot.createLabel("Signification négative", 20));
			this.subPanel.add(descriNegative);
			subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
			}
			panel.add(subPanel);
			this.add(panel);
	}
}
