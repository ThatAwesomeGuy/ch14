public class Cards {

	

	public static final String[] RANKS = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };

	public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	
	
	static Cards[] cards = new Cards[52];


	private final int rank;
 
	private final int suit;
	
	
	public Cards(){ 
		this.suit = 0;  
		this.rank = 0;
	}
 
	public Cards(int suit, int rank){ 
		this.suit = suit;  
		this.rank = rank;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
	
	public int getRank()
	{
		return this.rank;
	}
	

 
	public static void printCard(Cards c){
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] ranks = { "ERROR", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		System.out.println (ranks[c.rank] + " of " + suits[c.suit]);
	}
 
	public static void printDeck(Cards[] deck){
		for (int i = 0; i < deck.length; i++)
			printCard (deck[i]);
	}
	
	public int position() {
		return this.suit * 13 + this.rank - 1;
	}

 
	public static void makeDeck()
	{	
		int index = 0;
		
		for (int suit = 0; suit <= 3; suit++) {
			
		for (int rank = 1; rank <= 13; rank++) {
		cards[index] = new Cards(rank, suit);
		index++;
		}
		}

		if (cards[0] == null) {
			System.out.println("No card yet!");
			}
		
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);		
			}		
	}
	
	public static Cards[] createDeck(){
		Cards[] deck = new Cards [52];
		int index = 0;
		for(int suit = 0; suit <= 3; suit++){
			for(int rank = 1; rank <= 13; rank++){
				deck[index] = new Cards (suit, rank);
				index++;
				
			}
		}
		return deck;
		
	}



	
 
	public static int[] suitHist (Cards[]hand){
		int suitHist[] = {0, 0, 0, 0}; 
		for(Cards c : hand){  
			if(c.suit == 0) suitHist[0]++; 
			else if(c.suit == 1) suitHist[1]++; 
			else if(c.suit == 2) suitHist[2]++; 
			else if(c.suit == 3) suitHist[3]++; 
			else System.out.println("none");
		}
		return suitHist;
	}
	

	public int compareTo(Cards that) {

		if (this.suit < that.suit) {
			return -1;
		}
		if (this.suit > that.suit) {
			return 1;
		}

		if (this.rank == 1 && that.rank != 1) {
			return 1;
		}

		if (this.rank != 1 && that.rank == 1) {
			return -1;
		}

		if (this.rank < that.rank) {
			return -1;
		}
		if (this.rank > that.rank) {
			return 1;
		}

		return 0;
	}


	
	 public static boolean hasFlush(Cards[] x, int y) {
	        int count = 0;
	       
	        if (count >= 5){
	            System.out.println("Got a Flush");
	            return true;
	        }
	        else{
	            System.out.println("No Flush.");
	            return false;
	        }
	    }
	 
	 
	 
 
	public static void main(String[] args){

		
		
		
		Cards[] deck = createDeck();

		printDeck(deck);
		int[] hist = suitHist(deck);
		
		for(int i = 0; i < hist.length; i++)
			System.out.print(" " + hist[i] + " ");
		
		

	}
}







