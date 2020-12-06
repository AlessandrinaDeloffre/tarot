package tarot;



public class CardMinor extends Card{
	private String color;
	
	public static String [] names = {"as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "cavalier", "dame", "roi"};
	public static String [] colors = {"épées", "deniers", "coupes", "bâtons"};
	public static CardMinor [] deck = new CardMinor[56];
	
	private CardMinor(String name, int number, String color) {
		super(name, number);
		super.type="minor";
		this.color=color;
	}
	
	public CardMinor() {
		super();
		super.type="minor";
		this.generateDeck();
	}

	public void generateDeck() {
		// TODO Auto-generated method stub
		int compteur = 0;
		for (int y=0; y<colors.length; y++) {
			for(int j =0; j<names.length; j++) {
				deck[compteur]=new CardMinor(getName(j), j+1, getColor(y));
				compteur++;	
			}
		}
	}
	
	public String toString() {
		return this.name+" "+this.color;
	}
	
	private String getColor(int color) {
		return colors[color];
	}
	
	private String getName(int name) {
		return names[name];
	}

}
