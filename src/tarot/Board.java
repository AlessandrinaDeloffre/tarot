package tarot;

import java.awt.Color;
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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
	public JPanel subPanel;
	public ArrayList<Card> searchDeck = new ArrayList<Card>();
	public Card currentCard;
	public JLabel currentLabel;
	public JPanel subMenu;
	public JPanel header;
	
	
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
		this.subMenu = new JPanel();
		this.panel = new JPanel();
		this.header = new JPanel();
		this.mainPanel = new JPanel();
		this.subPanel = new JPanel();
		this.subPanel.setLayout(new BoxLayout(this.subPanel, BoxLayout.Y_AXIS));
		
		this.menuPanel = new JPanel();
//		this.mainPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		

		this.panel.setBackground(Color.black);
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
	
///////// MENU
	
	public void showMainMenu() {
		this.header.add(createLabel("Bienvenue", 32));
		addPanel(this.header);
		JButton seeCollection = new JButton("Voir la collection");
		JButton drawCards = new JButton("Tirer les cartes");
		seeCollection.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  header.removeAll();
				  menuPanel.removeAll();
				  showCollectionMenu(1);
				  showDeck(deck.deck);
			  }
		});
		
		drawCards.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  header.removeAll();
				  menuPanel.removeAll();
				  showDrawCardMenu();
				  //cardMENU showCollectionMenu(1);
				  // drawCARD showDeck(deck.deck);
			  }
		});
		this.menuPanel.add(seeCollection);
		this.menuPanel.add(drawCards);
		addPanel(this.menuPanel);
	}
	

	private void showCollectionMenu(int type) {
		this.header.add(createLabel("Votre collection", 32));
		addPanel(this.header);
		JButton home = new JButton("Accueil");
		home.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  panel.removeAll();
				  header.removeAll();
				  menuPanel.removeAll();
				  showMainMenu();
			  }
		});
		
		if(type==1) {
			JButton addCard = new JButton("Ajouter une nouvelle carte");
			addCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					subMenu.removeAll();
					newCardMenu(subMenu);
					subMenu.setVisible(true);
				}
				
			});
			
			JButton searchCard = new JButton("Rechercher");
			searchCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton showAll = new JButton("Montrer toutes les cartes");
					showAll.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							subMenu.removeAll();
							header.removeAll();
							menuPanel.removeAll();
							showCollectionMenu(1);
							showDeck(deck.deck);
						}
						
					});
					menuPanel.add(showAll);
					subMenu.removeAll();
					searchCardMenu(subMenu);
					subMenu.setVisible(true);
				}	
			});
			
		
			this.menuPanel.add(home);
			this.menuPanel.add(addCard);
			this.menuPanel.add(searchCard);
			addPanel(this.menuPanel);
			addPanel(subMenu);
		
		} else if (type==2) {
			JButton updateCard = new JButton("Mettre la carte à jour");
			updateCard.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					subMenu.removeAll();
					updateCardMenu(subMenu);
					subMenu.setVisible(true);					
				}
				
			});	
			JButton suppressCard = new JButton("Supprimer la carte");
			suppressCard.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					deck.deleteCard(currentCard);
					header.removeAll();
					menuPanel.removeAll();
					showCollectionMenu(1);
					showDeck(deck.deck);
				}
				
			});	
			
			JButton showAll = new JButton("Montrer toutes les cartes");
			showAll.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					subMenu.removeAll();
					header.removeAll();
					menuPanel.removeAll();
					showCollectionMenu(1);
					showDeck(deck.deck);
				}
				
			});
			
			this.menuPanel.add(home);
			this.menuPanel.add(updateCard);
			this.menuPanel.add(suppressCard);
			this.menuPanel.add(showAll);
			addPanel(this.menuPanel);
			addPanel(subMenu);
		}
		
	}
	
	private void showDrawCardMenu() {
		this.header.add(createLabel("Tirage des cartes", 32));
		addPanel(this.header);
		JButton home = new JButton("Accueil");
		home.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  panel.removeAll();
				  header.removeAll();
				  menuPanel.removeAll();
				  showMainMenu();
			  }
		});
		JPanel significations = new JPanel();
		JPanel titlesPanel = new JPanel();
			JButton draw1 = new JButton("Mode 1");
			draw1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mainPanel.removeAll();
					titlesPanel.removeAll();
					significations.removeAll();
					ArrayList<Card> arrayOf5 = new ArrayList<Card>();
					
					String[] titles =  {"Vos amours", "Votre travail", "Votre famille", "Vos amis", "Votre état d'esprit"};
					
					for(int i =0; i<titles.length; i++) {
						titlesPanel.add(createLabel(titles[i], 14));
					}
					
					for(int i=0; i<5; i++) {
						randomCards(arrayOf5);
						significations.add(createLabel(arrayOf5.get(i).descriPositive, 14));
					}
					addPanel(titlesPanel);
					showDeck(arrayOf5);
					addPanel(significations);
					titlesPanel.setLayout(new GridLayout(1, 5));
					
					mainPanel.setLayout(new GridLayout(1, 5));
					significations.setLayout(new GridLayout(1, 5));
					
				}
				
			});
			
			JButton draw2 = new JButton("Mode2");
			draw2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainPanel.removeAll();
					titlesPanel.removeAll();
					significations.removeAll();
					ArrayList<Card> arrayOf5 = new ArrayList<Card>();
					
					String[] titles =  {"Passé", "Présent", "Futur"};
					
					for(int i =0; i<titles.length; i++) {
						titlesPanel.add(createLabel(titles[i], 14));
					}
					
					for(int i=0; i<3; i++) {
						randomCards(arrayOf5);
						significations.add(createLabel(arrayOf5.get(i).descriPositive, 14));
					}
					addPanel(titlesPanel);
					showDeck(arrayOf5);
					addPanel(significations);
					titlesPanel.setLayout(new GridLayout(1, 3));
					mainPanel.setLayout(new GridLayout(1, 3));
					significations.setLayout(new GridLayout(1, 3));
					
				}	
			});
			
		
			this.menuPanel.add(home);
			this.menuPanel.add(draw1);
			this.menuPanel.add(draw2);
			addPanel(this.menuPanel);
			addPanel(subMenu);
		
	
		
	}
	public ArrayList randomCards(ArrayList<Card> array) {
	
			
			int rand =  (int)(Math.random() * (deck.deck.size()));
			if(checkRandom(rand, array)==false) {
				randomCards(array);
			} else {
			array.add(deck.deck.get(rand));
			}
		
			return array;
	}
	
	public boolean checkRandom(int rand, ArrayList<Card> array) {
		for(int y=0; y<array.size();y++) {
			if (deck.deck.get(rand)==array.get(y)) {
				return false;
			} 
		}
		return true;
	}
///////// SUBMENU
	public void updateCardMenu(JPanel p) {
		p.setVisible(false);
		JTextField cardName = new JTextField();
		cardName.setPreferredSize( new Dimension( 200, 24 ) );
		cardName.setText(currentCard.name);
		JTextField positiveField = new JTextField();
		positiveField.setPreferredSize( new Dimension( 200, 24 ) );
		positiveField.setText(currentCard.descriPositive);
		JTextField negativeField = new JTextField();
		negativeField.setPreferredSize( new Dimension( 200, 24 ) );
		negativeField.setText(currentCard.descriNegative);
		JButton create = new JButton("Créer");
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = cardName.getText();
				String descriPositive = positiveField.getText();
				String descriNegative = negativeField.getText();
				
				if(name!=null) {
					currentCard.updateCard(name, descriPositive, descriNegative);
					deck.getLists();
					mainPanel.removeAll();
					JLabel nameLabel = new JLabel();
					nameLabel.setText(currentCard.name);
					JLabel positiveLabel = new JLabel();
					positiveLabel.setText(currentCard.descriPositive);
					JLabel negativeLabel = new JLabel();
					negativeLabel.setText(currentCard.descriNegative);
					mainPanel.add(currentLabel);
					
					subPanel.add(createLabel("Nom", 20));
					subPanel.add(nameLabel);
					subPanel.add(createLabel("Signification positive", 20));
					subPanel.add(positiveLabel);
					subPanel.add(createLabel("Signification négative", 20));
					subPanel.add(negativeLabel);
					mainPanel.add(subPanel);
					mainPanel.setLayout(new FlowLayout());
					addPanel(mainPanel);						
				}
			}	
		});
		
		p.add(cardName);
		p.add(positiveField);
		p.add(negativeField);
		p.add(create);
	}
	
	public void searchCardMenu(JPanel p) {
		p.setVisible(false);
		deck.getLists();
		JComboBox<String> cardNumber = new JComboBox<String>(deck.cardNumbers); 
		JComboBox<String> cardName = new JComboBox<String>(deck.cardNames);
		
		cardName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchDeck = deck.searchByName(deck.deck, cardName.getSelectedItem().toString());
				showDeck(searchDeck);
			}
		});
		
		cardNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchDeck = deck.searchByNumber(deck.deck,cardNumber.getSelectedItem().toString());
				showDeck(searchDeck);
			}
		});
	
		p.add(cardNumber);
		p.add(cardName);	
	}
	
	public void newCardMenu(JPanel p){
		p.setVisible(false);
		JComboBox<String> cardNumber = new JComboBox<String>(deck.numbers); 
		JTextField cardName = new JTextField();
		cardName.setText("nom");
		cardName.setPreferredSize( new Dimension( 200, 24 ) );
		JTextField positiveField = new JTextField();
		positiveField.setPreferredSize( new Dimension( 200, 24 ) );
		positiveField.setText("signification positive");
		JTextField negativeField = new JTextField();
		negativeField.setPreferredSize( new Dimension( 200, 24 ) );
		negativeField.setText("signification negative");
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
						origImage = ImageIO.read(new File(path[0]));
						File outputfile = new File(".\\src\\tarot\\assets\\"+img);
						ImageIO.write(origImage, "jpg", outputfile);
						Card newCard = new Card(name, number, img);
						newCard.addDescription(descriPositive, descriNegative);
						newCard.updateNumber(cardNumber.getSelectedItem().toString());
						deck.reinitializeDeck(newCard);
						mainPanel.removeAll();
						showDeck(deck.deck);
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				}
			}	
		});
		p.add(cardNumber);
		p.add(cardName);
		p.add(positiveField);
		p.add(negativeField);
		p.add(addImage);
		p.add(create);
	}
	
///////// LABEL
	
	public JLabel createLabel(String labelText, int font) {
		JLabel label = new JLabel();
		label.setText(labelText);
		label.setFont(new Font("Serif", Font.PLAIN, font));
		label.setSize(1000, 500);
		//p.add(label);
		return label;
	}
	
	
///////// SHOW

	
	public void showDeck(ArrayList<Card> d) {
		deck.showDeck(d);
		this.mainPanel.removeAll();
		for (int i =0; i<d.size();i++) {
			JLabel label = new JLabel();
			
			int width = 150;
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(deck.getCard(d, i).getImageFile()).getImage().getScaledInstance(width, (int) (width*1.85), Image.SCALE_SMOOTH));
			label.setIcon(imageIcon);
			final int index = i;
			label.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(deck.getCard(d, index).name);
					subMenu.removeAll();
					currentCard = deck.getCard(d, index);
					currentLabel = label;
					mainPanel.removeAll();
					menuPanel.removeAll();
					header.removeAll();
					JLabel name = new JLabel();
					name.setText(deck.getCard(d, index).name);
					mainPanel.add(label);
					subPanel.add(createLabel("Nom", 20));
					subPanel.add(name);
						
					if(deck.getCard(d, index).descriPositive !=null) {
					JLabel descriPositive = new JLabel();
					descriPositive.setText(deck.getCard(d, index).descriPositive);
					subPanel.add(createLabel("Signification positive", 20));
					subPanel.add(descriPositive);
					}
					if(deck.getCard(d, index).descriPositive !=null) {
					JLabel descriNegative = new JLabel();
					descriNegative.setText(deck.getCard(d, index).descriNegative);
					subPanel.add(createLabel("Signification négative", 20));
					subPanel.add(descriNegative);
					}
					mainPanel.add(subPanel);
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
