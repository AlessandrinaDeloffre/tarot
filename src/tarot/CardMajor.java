package tarot;
import java.util.ArrayList;
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
	public ArrayList<Card> deck = new ArrayList<>();
	

	public CardMajor(String name, int number, String image) {
		super(name, number, "major");
		super.image=image;
	
	}
	
	public CardMajor() {
		this.generateDeck();
	}
	
	public void generateDeck() {
		for(int i=0; i<cardNames.length; i++) {
			String mots[]=cardNames[i].toLowerCase().split(" ");
			if(mots.length==1) {
				mots=cardNames[i].split("'");
			}
			String imgName;
			if(mots.length==1) {
				imgName = i+"-"+mots[0]+".jpg";
			} else {
				imgName = i+"-"+mots[0]+"-"+mots[1]+".jpg";
			}
			
			this.deck.add(new CardMajor(cardNames[i], i, imgName));
		}
		
	}
	
	public void updateCard(String name, int number) {
		//ajouter sécurité sur number
		this.name=name;
		this.number=number;
	}
	

}
