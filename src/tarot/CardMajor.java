package tarot;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardMajor extends Card {
	public static String [] cardNames = {"Le mat","Le bateleur", "La papesse", "L'impératrice",
										 "L'empereur", "Le pape", "Le chariot", "La Justice",
										 "L'amoureux", "L'hermite", "La roue de fortune",
										 "La force", "Le pendu", "L'arcane sans nom","Tempérance", 
										 "Le diable", "La maison dieu","L'étoile", "La lune", 
										 "Le soleil", "Le jugement","Le monde"};
	public static CardMajor [] deck = new CardMajor[22];
	
	public CardMajor(String name, int number) {
		super(name, number);
		super.type="major";
	}
	
	public CardMajor() {
		super();
		super.type="major";
		this.generateDeck();
	}

	public void generateDeck() {
		for(int i=0; i<22; i++) {
			deck[i]= new CardMajor(cardNames[i], i);
		}
		
	}
	
	public String toString() {
		return this.name;
	}

	/*@Override
	public void shuffleDeck(Card[] deck) {
		List<Card> cardList = Arrays.asList(deck);
		Collections.shuffle(cardList);
		cardList.toArray(deck);
	}*/


	
	

}
