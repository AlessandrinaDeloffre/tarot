package tarot;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Card extends JFrame {
	protected String number;
	protected String type;
	protected String name;
	protected String description;
	protected ArrayList<Card> deck = new ArrayList<Card>();
	public static ArrayList<String> numbers = new ArrayList<String>();
	protected String image;
	public static ArrayList<String> cardNames = new ArrayList<String>();
	public static ArrayList<String> romanNumbers = new ArrayList<String>();
	public Card(String name, String number, String image) {
		this.name = name;
		this.number = number;
		this.image= image;
	}
	public Card() {
		cardNames.addAll(Arrays.asList("Le mat","Le bateleur", "La papesse", "L'impératrice",
				 "L'empereur", "Le pape", "Le chariot", "La Justice",
				 "L'amoureux", "L'hermite", "La roue de fortune",
				 "La force", "Le pendu", "L'arcane sans nom","Tempérance", 
				 "Le diable", "La maison dieu","L'étoile", "La lune", 
				 "Le soleil", "Le jugement","Le monde"));
		romanNumbers.addAll(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII","IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII"));
		//this.generateDeck();

		numbers.addAll(Arrays.asList("XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII"));
	}
	
	
	
	public String getImageFile() {
		return ".\\src\\tarot\\assets\\"+this.image;
//		return "C:\\Users\\aless\\eclipse-workspace\\tarot\\src\\tarot\\assets\\"+this.image;
	}
	
	
	
	public void addDescription(String description) {
		this.description = description;
	}
	
	public void updateCard(String name, String number) {
		//ajouter sécurité sur number
		this.name=name;
		this.number=number;
	}

	public String toString() {
		return this.name;
	}
	
	public void romanConversion(int i) {
		String result = numbers.get(i);
		numbers.remove(i);
		romanNumbers.add(result);
		//return result;
	}
	
	
	
}
