package tarot;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddCardMenu extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Deck deck;
	JPanel panel = new JPanel();
	JComboBox<String> cardNumber;
	JTextField cardName;
	JTextField positiveField = new JTextField();
	JTextField negativeField = new JTextField();
	JButton addImage = new JButton("Choisir l'image");
	JButton create = new JButton("Créer");
	String path;
	 
	public AddCardMenu(Deck deck) {
		this.deck = deck;
		cardNumber = new JComboBox<String>(deck.numbers); 
		cardName = new JTextField();
		cardName.setText("nom");
		cardName.setPreferredSize( new Dimension( 200, 24 ) );
		
		positiveField.setPreferredSize( new Dimension( 200, 24 ) );
		positiveField.setText("signification positive");
		
		negativeField.setPreferredSize( new Dimension( 200, 24 ) );
		negativeField.setText("signification negative");
		
		@SuppressWarnings("unused")
		final String path[] = {""};
		
		addImage.addActionListener(this);
		create.addActionListener(this);
		
		panel.add(cardNumber);
		panel.add(cardName);
		panel.add(positiveField);
		panel.add(negativeField);
		panel.add(addImage);
		panel.add(create);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addImage) {
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(panel);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
	            	path = chooser.getSelectedFile().getAbsolutePath();
		    }
			
		}
		
		if(e.getSource()==create) {
			String number = cardNumber.getSelectedItem().toString();
			String name = cardName.getText();
			String descriPositive = positiveField.getText();
			String descriNegative = negativeField.getText();
			String mots[]=name.toLowerCase().split(" |\\'");
			String img;
			if(mots.length==1) {
				img = Card.romanNumbers.size()+"-"+mots[0]+".jpg";
			} else {
				img = Card.romanNumbers.size()+"-"+mots[0]+"-"+mots[1]+".jpg";
			}
			if(number!=null && name!=null && img!=null) {
				BufferedImage origImage;
				try {	
					origImage = ImageIO.read(new File(path));
					File outputfile = new File(".\\src\\tarot\\assets\\"+img);
					ImageIO.write(origImage, "jpg", outputfile);
					Card newCard = new Card(name, number, img, descriPositive, descriNegative);
					newCard.updateNumbers(cardNumber.getSelectedItem().toString());
					deck.reinitializeDeck(newCard);
					Main.subMenu.removeAll();
					Main.updatePanel(new CollectionPanel(deck, deck.deck));
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
			
		}
		
	}
}
