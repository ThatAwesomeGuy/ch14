import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
	
	private String label;
	private ArrayList<Cards> cards;

	public CardCollection(String label) {
		this.label = label;
		this.cards = new ArrayList<Cards>();
	}
	
	
		
	
	public void addCard(Cards card) {
		cards.add(card);
		}
	
	public String getLabel()
	{
		return this.label;
	}
	
	public Cards popCard(int i) {
		return cards.remove(i);
		}
	
	public Cards popCard() {
		int i = size() - 1;
		return popCard(i);
		}

	public int size() {
		return cards.size();
		}
	
	public boolean empty() {
		return cards.size() == 0;
		}
	
	
		
	public Cards getCard(int i) {
		return cards.get(i);
		}

	public Cards last() {
		int i = size() - 1;
		return cards.get(i);
		}
	
	
	public void swapCards(int i, int j) {
		Cards temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
		}
		
		Random random = new Random();{
		for (int i = size() - 1; i > 0; i--) {
		int j = random.nextInt(i);
		swapCards(i, j);
		}
		}
		
		public void deal(CardCollection that, int n) {
			for (int i = 0; i < n; i++) {
			Cards card = popCard();
			that.addCard(card);
			}
			}


		Deck deck = new Deck("Deck");
		deck.shuffle();
		hand Hand = new hand("Hand");
		deck.deal(hand,5);
		hand.display();
		
		hand drawPile = new hand("Draw Pile");
		deck.dealAll(drawPile);
		System.out.printf("Draw Pile has %d cards.\n",
		drawPile.size());
}

	
	
	
	

