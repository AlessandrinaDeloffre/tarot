package tarot;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateCardMenu extends JPanel implements ActionListener{

	Deck deck;
	Card card;
	JPanel panel = new JPanel();
	
	JTextField cardName = new JTextField();
	JTextField positiveField = new JTextField();
	JTextField negativeField = new JTextField();
	JButton create = new JButton("Cr�er");
	
	public UpdateCardMenu(Deck deck, Card card) {
		this.card=card;
		this.deck=deck;
	
		
		cardName.setPreferredSize( new Dimension( 200, 24 ) );
		cardName.setText(card.name);
		positiveField.setPreferredSize( new Dimension( 200, 24 ) );
		positiveField.setText(card.descriPositive);
		negativeField.setPreferredSize( new Dimension( 200, 24 ) );
		negativeField.setText(card.descriNegative);
	
		panel.add(cardName);
		panel.add(positiveField);
		panel.add(negativeField);
		panel.add(create);
		
		create.addActionListener(this);
		this.add(panel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==create) {
			try {
				String name = cardName.getText();
				String descriPositive = positiveField.getText();
				String descriNegative = negativeField.getText();
				if(name!=null) {
					System.out.println("ici1");
					card.updateCard(name, descriPositive, descriNegative);
					deck.getLists();
					System.out.println("ici");
					Tarot.addMenu(new SingleCardMenu(deck, card));
					Tarot.changePanel(new SingleCardPanel(card));
		
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(Board.window, "Erreur de modification de la carte.");
			}
		}
	}

}