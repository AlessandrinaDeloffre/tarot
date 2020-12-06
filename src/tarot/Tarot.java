package tarot;

public class Tarot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Card card = new Card(new CardMajor().deck, new CardMinor().deck);
		//card.generateDeck(new CardMajor().deck, new CardMinor().deck);
		card.shuffleDeck(card.deck);
		for(int i=0; i<card.deck.length;i++) {
			System.out.println(card.deck[i].toString());
		}
		for(int i=0; i<card.deckMajor.length;i++) {
			System.out.println(card.deckMajor[i].toString());
		}
		
	}

}
