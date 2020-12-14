package tarot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Main {

	public static JPanel menuPanel;
	public static JScrollPane scrollPanel;
	public static JFrame window;
	public static Deck deck;
	public static JPanel mainPanel;
	public static JPanel subPanel;
	public ArrayList<Card> searchDeck = new ArrayList<Card>();
	public Card currentCard;
	public JLabel currentLabel;
	public static JPanel subMenu;
	public static JPanel header;
	public static void main(String[] args) {
		window = new JFrame("Tarot");
		
File f = new File("./src/tarot/tmp/board.ser");
		
		if(f.exists() && !f.isDirectory()) {
			try {
				FileInputStream fileIn = new FileInputStream("./src/tarot/tmp/board.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				deck = (Deck) in.readObject();
				in.close();
				fileIn.close();
			} catch(IOException i) {
				i.printStackTrace();
				deck= new Deck();
				return;
			} catch (ClassNotFoundException c) {
				System.out.println("Board class not found");
				deck= new Deck();
				c.printStackTrace();
				return;
			}
		} else {
			deck= new Deck();
		}
		
		window.addWindowListener(new WindowAdapter() {
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
		
		menuPanel = new JPanel();
		subMenu = new JPanel();
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		scrollPanel=new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.setSize(1200, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updatePanel(new HomePanel(deck));

	}
	
	public static void addMenu(JPanel menu) {
		menuPanel.removeAll();
		menuPanel = menu;
	} 
	public static void addSubMenu(JPanel menu) {
		subMenu.removeAll();
		subMenu = menu;
		
	} 
	
	public static void updatePanel(JPanel panel) {
		window.getContentPane().removeAll();
		mainPanel.removeAll();
		
		mainPanel.add(menuPanel);
		mainPanel.add(subMenu);
		mainPanel.add(panel);
		
		
		scrollPanel.getViewport().setView(mainPanel);
		scrollPanel.setBackground(Color.black);
		window.add(scrollPanel);
		window.setVisible(true);
		window.revalidate();
		window.repaint();
	}
	
	public static JLabel createLabel(String labelText, int font) {
		JLabel label = new JLabel();
		label.setText(labelText);
		label.setFont(new Font("Serif", Font.PLAIN, font));
		label.setSize(1000, 500);
		//p.add(label);
		return label;
	}
}
