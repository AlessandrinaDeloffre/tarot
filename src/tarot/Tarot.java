package tarot;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;

public class Tarot {
	static Board board = null;
	public static void main(String[] args) {
	
		//Deck deck = new Deck();
		//System.out.println(deck.deckMajor.size());
//		deck.showDeck(deck.deckMajor);
		//deck.showDeck();
		//deckMajor.deleteCard(deckMajor.deck.get(1));
		//deckMajor.showDeck();
		//System.out.println(deck.getCard(deck.deckMinor, 1).toString());
		//deckMinor.showDeck();
		//ArrayList searchArray = deck.searchByName(deck.deckMinor, "as");
		//for(int i=0; i<searchArray.size();i++) {
		//	System.out.println(searchArray.get(i).toString());
		//}
		//deckMinor.getCard(1).updateCard("OUI", 1, "red");
		//System.out.println("XXXXXXXXXXXXXXXX");
		//deckMinor.showDeck();


		Board board = new Board();

		//board.deck.suffleDeck(board.deck.deck);
		//board.deck.showDeck(board.deck.deckMajor);
		//board.showMainMenu();
	}

}
