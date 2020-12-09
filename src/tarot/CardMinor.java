package tarot;

import java.util.ArrayList;

public class CardMinor extends Card{
	public String color;
	public static String [] names = {"as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "cavalier", "reine", "roi"};
	public static String [] colors = {"épées", "deniers", "coupes", "bâtons"};
	public ArrayList<Card> deck = new ArrayList<>();
	
	public CardMinor(String name, int number, String color, String image) {
		super(name, number, "minor");
		this.color=color;
		super.image=image;
	}
	
	public CardMinor() {
		this.generateDeck();
	}
	
	public void generateDeck() {
		// TODO Auto-generated method stub
		for (int y=0; y<colors.length; y++) {
			for(int j =0; j<names.length; j++) {
				String imgName = getName(j)+"-"+getColor(y)+".jpg";
				deck.add(new CardMinor(getName(j), j+1, getColor(y), imgName));
			}
		}
	}
	
	private String getColor(int index) {
		return colors[index];
	}
	
	private String getName(int index) {
		return names[index];
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.color;
	}
	
	@Override
	public void updateCard(String name, int number, String color) {
		//ajouter sécurité sur number
		this.name=name;
		this.number=number;
		this.color=color;
//		new CardMinor(name, number, color);
	}




	
	
	
}
