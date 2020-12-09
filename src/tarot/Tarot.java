package tarot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Tarot {

	public static void main(String[] args) {
		Deck deckMajor = new Deck("major");
		Deck deckMinor = new Deck("minor");
		Deck deck = new Deck("complete");
		
		//deck.showDeck();
		//deckMajor.deleteCard(deckMajor.deck.get(1));
		//deckMajor.showDeck();
		System.out.println(deckMinor.getCard(1).toString());
		//deckMinor.showDeck();
		ArrayList searchArray = deckMinor.searchByName("as");
		for(int i=0; i<searchArray.size();i++) {
			System.out.println(searchArray.get(i).toString());
		}
		//deckMinor.getCard(1).updateCard("OUI", 1, "red");
		//System.out.println("XXXXXXXXXXXXXXXX");
		//deckMinor.showDeck();
		deckMajor.showDeck();
	
		Board board = new Board();
		//board.showDeck(deck);
		//board.showCollection();
		//board.showDeck(deck);
		board.showMainMenu();
		//deckMajor.generateWindow();
	//	deckMajor.addCardToPanel(1, board);
		//deckMajor.addCardToPanel(2, board);
		
	}

}
