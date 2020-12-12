package tarot;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	public JPanel mainPanel;
	public ArrayList<Card> searchDeck = new ArrayList<Card>();
	
	
	public Board() {
		this.panel = new JPanel();
		this.mainPanel = new JPanel();
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
				  showCollection(deck.deck);
				  
			  }
			});
		this.menuPanel.add(seeCollection);
		this.menuPanel.add(drawCards);
		addPanel(this.menuPanel);
	}
	private void showCollectionMenu() {
		this.menuPanel.add(createLabel("Votre collection"));
		JPanel searchMenu = new JPanel();
		searchCardMenu(searchMenu);
		JButton home = new JButton("Accueil");
		JButton addCard = new JButton("Ajouter une nouvelle carte");
		JButton searchCard = new JButton("Rechercher");
		
		home.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  panel.removeAll();
				  menuPanel.removeAll();
				  showMainMenu();
			  }
		});
		searchCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMenu.setVisible(true);
			}	
		});
		this.menuPanel.add(home);
		this.menuPanel.add(addCard);
		this.menuPanel.add(searchCard);
		//this.menuPanel.add(searchMenu);
		addPanel(this.menuPanel);
		addPanel(searchMenu);
	}
	
	public void searchCardMenu(JPanel p) {
		p.setVisible(false);
	
		JComboBox cardNumber = new JComboBox(deck.cardNumbers); 
		JComboBox cardName = new JComboBox(deck.cardNames);
	
		cardName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchDeck = deck.searchByName(deck.deck, (String) cardName.getSelectedItem());
				System.out.println(cardName.getSelectedItem());
				System.out.println(deck.deck.size());
				showCollection(searchDeck);
	
			}
			
		});
		
		cardNumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchDeck = deck.searchByNumber(deck.deck, (String) cardNumber.getSelectedItem());
				System.out.println(cardName.getSelectedItem());
				System.out.println(deck.deck.size());
				showCollection(searchDeck);
	
			}
			
		});
	
		
		p.add(cardNumber);
		p.add(cardName);
		
		
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
	}
	
	public void showCollection(ArrayList<Card> d) {
		deck.showDeck(d);
		showDeck(d);
	}
	
	public void showDeck(ArrayList<Card> d) {
		//JPanel p = new JPanel();
		this.mainPanel.removeAll();
		for (int i =0; i<d.size();i++) {
			deck.addCardToPanel( d,i, this.mainPanel);
		}
		int row = (int) Math.ceil(((double)d.size())/6);
		this.mainPanel.setLayout(new GridLayout(row, 6));
		addPanel(this.mainPanel);
	}
}
