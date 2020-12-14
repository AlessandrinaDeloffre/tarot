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
	
	
	public static ArrayList<String> additionnalNumbers = new ArrayList<String>();
	public static ArrayList<String> cardNames = new ArrayList<String>();
	public static ArrayList<String> romanNumbers = new ArrayList<String>();
	public static ArrayList<String> positives = new ArrayList<String>();
	public static ArrayList<String> negatives = new ArrayList<String>();
	
	public Card(String name, String number, String image, String descriPositive, String descriNegative) {
		this.name = name;
		this.number = number;
		this.image= image;
		this.descriPositive = descriPositive;
		this.descriNegative = descriPositive;
	}
	
	public Card() {
		cardNames.addAll(Arrays.asList("Le mat","Le bateleur", "La papesse", "L'impératrice",
				 "L'empereur", "Le pape", "Le chariot", "La Justice",
				 "L'amoureux", "L'hermite", "La roue de fortune",
				 "La force", "Le pendu", "L'arcane sans nom","Tempérance", 
				 "Le diable", "La maison dieu","L'étoile", "La lune", 
				 "Le soleil", "Le jugement","Le monde"));
		romanNumbers.addAll(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII","IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII"));
		positives.addAll(Arrays.asList("liberté","commencement","fécondité","intelligence","autorité","spiritualité","choix","succès","maîtrise","choix","introspection","hasard","volonté","attente","transformation","harmonie","vitalité","reconstruction","amour","intuition","clarté","lucidité","bonheur"));
		negatives.addAll(Arrays.asList("errance","malhonnêteté","secret","superficialité","intolérance","stagnation","blocage","dispersion","jugement","blocage","solitude","instabilité","faiblesse","dépendance","resistance","excès","manipulation","échec","inertie","nostalgie","discorde","retards","imprévu"));
		additionnalNumbers.addAll(Arrays.asList("XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII"));
	}
	
	public String getImageFile() {
		return ".\\src\\tarot\\assets\\"+this.image;
	}
	
	public void updateCard(String name, String descriPositive, String descriNegative) {
		//ajouter sécurité sur number
		for(int i=0; i<cardNames.size();i++) {
			if(cardNames.get(i) == this.name) {
				cardNames.set(i, name); 
			}
		}
		this.name=name;
		this.descriPositive = descriPositive;
		this.descriNegative = descriNegative;
		
	}
	
	public void updateNumbers(String number) {
		for(int i=0; i<additionnalNumbers.size();i++) {
			if(additionnalNumbers.get(i) == number) {
				additionnalNumbers.remove(i);
			}
		}
		romanNumbers.add(number);
	}
	
	
	
}
