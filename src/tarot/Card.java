package tarot;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;

public class Card extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String number;
	protected String type;
	protected String name;
	protected String image;
	protected String[] description = new String[2];
	protected String descriPositive;
	protected String descriNegative;
	
	protected ArrayList<Card> deck = new ArrayList<Card>();
	public static ArrayList<String> numbers = new ArrayList<String>();
	public static ArrayList<String> cardNames = new ArrayList<String>();
	public static ArrayList<String> romanNumbers = new ArrayList<String>();
	public static ArrayList<String> positives = new ArrayList<String>();
	public static ArrayList<String> negatives = new ArrayList<String>();
	
	public Card(String name, String number, String image) {
		this.name = name;
		this.number = number;
		this.image= image;
		this.description[0] = this.descriPositive;
		this.description[1] = this.descriNegative;
	}
	public Card() {
		cardNames.addAll(Arrays.asList("Le mat","Le bateleur", "La papesse", "L'imp�ratrice",
				 "L'empereur", "Le pape", "Le chariot", "La Justice",
				 "L'amoureux", "L'hermite", "La roue de fortune",
				 "La force", "Le pendu", "L'arcane sans nom","Temp�rance", 
				 "Le diable", "La maison dieu","L'�toile", "La lune", 
				 "Le soleil", "Le jugement","Le monde"));
		romanNumbers.addAll(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII","IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII"));
		//this.generateDeck();
		positives.addAll(Arrays.asList("libert�","commencement","f�condit�","intelligence","autorit�","spiritualit�","choix","succ�s","ma�trise","choix","introspection","hasard","volont�","attente","transformation","harmonie","vitalit�","reconstruction","amour","intuition","clart�","lucidit�","bonheur"));
		negatives.addAll(Arrays.asList("errance","malhonn�tet�","secret","superficialit�","intol�rance","stagnation","blocage","dispersion","jugement","blocage","solitude","instabilit�","faiblesse","d�pendance","resistance","exc�s","manipulation","�chec","inertie","nostalgie","discorde","retards","impr�vu"));
		numbers.addAll(Arrays.asList("XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII"));
	}
	
	
	
	public String getImageFile() {
		return ".\\src\\tarot\\assets\\"+this.image;
//		return "C:\\Users\\aless\\eclipse-workspace\\tarot\\src\\tarot\\assets\\"+this.image;
	}
	
	
	
	public void addDescription(String description, int type) {
		if(type==1) {
			this.descriPositive = description;
			this.description[0] = this.descriPositive;
		} else if(type==2) {
			this.descriNegative = description;
			this.description[1] = this.descriNegative;
		} 
		
	}
	
	public void addDescription(String descriPositive, String descriNegative) {
		
			this.descriPositive = descriPositive;
			this.description[0] = this.descriPositive;
		
			this.descriNegative = descriNegative;
			this.description[1] = this.descriNegative;
		 
		
	}
	
	public void updateCard(String name, String descriPositive, String descriNegative) {
		//ajouter s�curit� sur number
	
		for(int i=0; i<cardNames.size();i++) {
			if(cardNames.get(i) == this.name) {
				cardNames.set(i, name); 
			}
		}
		this.name=name;
		this.addDescription(descriPositive, descriNegative);
		//this.number=number;
	}

	public String toString() {
		return this.name;
	}
	
	public void updateNumber(String number) {
		for(int i=0; i<numbers.size();i++) {
			if(numbers.get(i) == number) {
				numbers.remove(i);
			}
		}
		romanNumbers.add(number);
	}
	
	
	
}
