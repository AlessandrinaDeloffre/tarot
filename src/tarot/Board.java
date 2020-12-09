package tarot;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Board {
	
	public JPanel panel;
	public JPanel menuPanel;
	public JScrollPane scrollPanel;
	public JFrame window;
	public Deck deck = new Deck();
	
	public Board() {
		this.panel = new JPanel();
		this.menuPanel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.scrollPanel=new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.window = new JFrame("Tarot");
		this.window.setSize(1200, 650);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void addPanel(JPanel p) {
		this.panel.add(p);
		this.scrollPanel.getViewport().setView(this.panel);
		this.window.add(this.scrollPanel);
		this.window.setVisible(true);
		this.window.revalidate();
	}
	
	public void showDeck(ArrayList<Card> d) {
		JPanel p = new JPanel();
		for (int i =0; i<d.size();i++) {
			deck.addCardToPanel( d,i, p);
		}
		int row = (int) Math.ceil(((double)d.size())/6);
		p.setLayout(new GridLayout(row, 6));
		addPanel(p);
	}
	
	public void showMainMenu() {
		this.menuPanel.add(createLabel("Bienvenue"));
		//JPanel p = new JPanel();
		JButton seeCollection = new JButton("Voir la collection");
		JButton drawCards = new JButton("Tirer les cartes");
		seeCollection.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  menuPanel.removeAll();
				  showCollectionMenu();
				  showCollection();
				  
			  }
			});
		this.menuPanel.add(seeCollection);
		this.menuPanel.add(drawCards);
		addPanel(this.menuPanel);
	}
	private void showCollectionMenu() {
		this.menuPanel.add(createLabel("Votre collection"));
		//JPanel p = new JPanel();
		JButton home = new JButton("Accueil");
		JButton addCard = new JButton("Ajouter une nouvelle carte");
		home.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  panel.removeAll();
				  menuPanel.removeAll();
				  showMainMenu();
			  }
			});
		this.menuPanel.add(home);
		this.menuPanel.add(addCard);
		addPanel(this.menuPanel);
	}
	public void addLabel(String labelText) {
		JPanel p = new JPanel();
		JLabel label = new JLabel();
		label.setText(labelText);
		label.setFont(new Font("Serif", Font.PLAIN, 32));
		p.setSize(this.panel.getWidth(), 500);
		p.add(label);
		addPanel(p);
	}
	public JPanel createLabel(String labelText) {
		JPanel p = new JPanel();
		JLabel label = new JLabel();
		label.setText(labelText);
		label.setFont(new Font("Serif", Font.PLAIN, 32));
		p.setSize(1000, 500);
		p.add(label);
		return p;
//		addPanel(p);
	}
	
	public void showCollection() {
		addPanel(createLabel("Arcanes Majeures"));
		showDeck(deck.deckMajor);
		addPanel(createLabel("Arcanes Mineures"));
		showDeck(deck.deckMajor);
	}
}
