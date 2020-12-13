package tarot;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Board {
	private static final long serialVersionUID = 2311970105828218463L;
	public JPanel panel;
	public JPanel menuPanel;
	public JScrollPane scrollPanel;
	public JFrame window;
	public Deck deck;
	public JPanel mainPanel;
	public ArrayList<Card> searchDeck = new ArrayList<Card>();
	
	
	public Board() {
		this.window = new JFrame("Tarot");
File f = new File("./src/tarot/tmp/board.ser");
		
		if(f.exists() && !f.isDirectory()) {
			try {
				FileInputStream fileIn = new FileInputStream("./src/tarot/tmp/board.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				this.deck = (Deck) in.readObject();
				in.close();
				fileIn.close();
			} catch(IOException i) {
				i.printStackTrace();
				this.deck= new Deck();
				return;
			} catch (ClassNotFoundException c) {
				System.out.println("Board class not found");
				this.deck= new Deck();
				c.printStackTrace();
				return;
			}
		} else {
			this.deck= new Deck();
		}
		
		this.window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					FileOutputStream fileOut = new FileOutputStream("./src/tarot/tmp/board.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(deck);
					out.close();
					fileOut.close();
					System.out.println("Data is saved in /tpm/board.ser");
				} catch (IOException i) {
					i.printStackTrace();
				}
			}
		});

		
	
		
		
		this.panel = new JPanel();
		this.mainPanel = new JPanel();
		this.menuPanel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.scrollPanel=new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.window.setSize(1200, 650);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showMainMenu();

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
				  showCollectionMenu(1);
				  showCollection(deck.deck);
				  
			  }
			});
		this.menuPanel.add(seeCollection);
		this.menuPanel.add(drawCards);
		addPanel(this.menuPanel);
	}
	private void showCollectionMenu(int type) {
		this.menuPanel.add(createLabel("Votre collection"));
	
		JButton home = new JButton("Accueil");
		home.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  panel.removeAll();
				  menuPanel.removeAll();
				  showMainMenu();
			  }
		});
		
		if(type==1) {
			
			JButton addCard = new JButton("Ajouter une nouvelle carte");
			JPanel newCardMenu = new JPanel();
			
			JButton searchCard = new JButton("Rechercher");
			JPanel subMenu = new JPanel();
		
			
			searchCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchCardMenu(subMenu);
					subMenu.setVisible(true);
				}	
			});
			
			addCard.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					newCardMenu(subMenu);
					subMenu.setVisible(true);
				}
				
			});
			this.menuPanel.add(home);
			this.menuPanel.add(addCard);
			this.menuPanel.add(searchCard);
			addPanel(this.menuPanel);
			addPanel(subMenu);
		} else if (type==2) {
			JButton showAll = new JButton("Montrer toutes les cartes");
			showAll.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					menuPanel.removeAll();
					showCollectionMenu(1);
					showCollection(deck.deck);
					
				}
				
			});
			
			this.menuPanel.add(home);
			this.menuPanel.add(showAll);
			addPanel(this.menuPanel);
		}
		
	}
	
	public void searchCardMenu(JPanel p) {
		p.setVisible(false);
		JComboBox<String> cardNumber = new JComboBox<String>(deck.cardNumbers); 
		JComboBox<String> cardName = new JComboBox<String>(deck.cardNames);
	
		cardName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchDeck = deck.searchByName(deck.deck, cardName.getSelectedItem().toString());
				System.out.println(cardName.getSelectedItem());
				System.out.println(deck.deck.size());
				showCollection(searchDeck);
	
			}
			
		});
		
		cardNumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deck.searchDeck = deck.searchByNumber(deck.deck, (String) cardNumber.getSelectedItem());
				showCollection(searchDeck);
			}
		});
	
		p.add(cardNumber);
		p.add(cardName);
		
		
	}
	
	public void newCardMenu(JPanel p){
		p.setVisible(false);
		JComboBox<String> cardNumber = new JComboBox<String>(deck.numbers); 
		JTextField cardName = new JTextField();
		cardName.setPreferredSize( new Dimension( 200, 24 ) );
		JButton addImage = new JButton("Choisir l'image");
		JButton create = new JButton("Créer");
		final String path[] = {""};
		addImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(mainPanel);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
		            	path[0] = chooser.getSelectedFile().getAbsolutePath();
			    }
			}
		});
		  
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String number = cardNumber.getSelectedItem().toString();
				String name = cardName.getText();
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
						origImage = ImageIO.read(new File(path[0]));
						File outputfile = new File(".\\src\\tarot\\assets\\"+img);
						ImageIO.write(origImage, "jpg", outputfile);
						Card newCard = new Card(name, number, img);
						deck.reinitializeDeck(newCard);
						newCard.romanConversion(cardNumber.getSelectedIndex());
						mainPanel.removeAll();
						showCollection(deck.deck);
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				}
			}	
		});
		p.add(cardNumber);
		p.add(cardName);
		p.add(addImage);
		p.add(create);
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
		this.mainPanel.removeAll();
		for (int i =0; i<d.size();i++) {
			JLabel label = new JLabel();
			int width = 150;
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(deck.getCard(d, i).getImageFile()).getImage().getScaledInstance(width, (int) (width*1.85), Image.SCALE_SMOOTH));
			label.setIcon(imageIcon);
			final int index = i;
			label.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("click");
					mainPanel.removeAll();
					menuPanel.removeAll();
					JLabel name = new JLabel();
					//System.out.println(d.indexOf(this));
					name.setText(deck.getCard(d, index).name);
					mainPanel.add(label);
					mainPanel.add(name);
					mainPanel.setLayout(new FlowLayout());
					showCollectionMenu(2);
					addPanel(mainPanel);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
				}
				
			});
			this.mainPanel.add(label);
			//deck.addCardToPanel( d,i, this.mainPanel);
		}
		int row = (int) Math.ceil(((double)d.size())/6);
		this.mainPanel.setLayout(new GridLayout(row, 6));
		
		addPanel(this.mainPanel);
		
		


	}
}
