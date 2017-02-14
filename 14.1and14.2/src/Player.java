public class Player {
	private String name;
	private hand hand;

	public Player(String name) {
		this.name = name;
		this.hand = new hand(name);
	}
	
	
	
	public String getName()
	{
		return this.name;
	}
	
	
	
	
	
	public Cards play(Eights eights, Cards prev) {
		Cards card = searchForMatch(prev);
		if (card == null) {
		card = drawForMatch(eights, prev);
		}
		return card;
		}

	public Cards searchForMatch(Cards prev) {

		for (int i = 0; i < hand.size(); i++) {
		Cards card = hand.getCard(i);
		if (cardMatches(card, prev)) {
		return hand.popCard(i);
		}
		}
		return null;
		}
	
	public Cards drawForMatch(Eights eights, Cards prev) {
		while (true) {
		Cards card = eights.draw();
		System.out.println(name + " draws " + card);
		if (cardMatches(card, prev)) {
		return card;
		}
		hand.addCard(card);
		}
		}
	
	public static boolean cardMatches(Cards card1, Cards card2) {
		if (card1.getSuit() == card2.getSuit()) {
		return true;
		}
		if (card1.getRank() == card2.getRank()) {
		return true;
		}
		if (card1.getRank() == 8) {
		return true;
		}
		return false;
		}
	
	public int score() {
		int sum = 0;
		for (int i = 0; i < hand.size(); i++) {
		Cards card = hand.getCard(i);
		int rank = card.getRank();
		if (rank == 8) {
		sum -= 20;
		} else if (rank > 10) {
		sum -= 10;
		} else {
		sum -= rank;
		}
		}
		return sum;
		}


	
	

}
