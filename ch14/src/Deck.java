import java.util.Arrays;
import java.util.Random;
/**
* A deck of playing cards (of fixed size).
*/

public class Deck {



    private Cards[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     * @param string 
     */
    public Deck(String string) {
        this.cards = new Cards[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Cards(rank, suit);
                index++;
            }
        }
    }
  

    /**
     * Constructs a deck of n cards (null).
     */
    public Deck(int n) {
        this.cards = new Cards[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Cards[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println(this.cards[i]);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        String str = new String();
        for (int i = 0; i < this.cards.length; i++) {
            str+=(this.cards[i]);
            str+=('\n');
        }
        return str.toString();
    }

    /**
     * Chooses a random number between low and high, including both.
     */  
    public static int[] randomInt(int low,int high) {
      	Random random = new Random();
      	int[] a = new int[low];
      	int[] b = new int[high];
      	for (int i = 0; i < a.length; i++) {
      	a[i] = random.nextInt(high);
      	}
      	return a;
      	}

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) {
        Cards deck = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = deck;
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle(){
        int length = cards.length;
        Random random = new Random();
        random.nextInt();
        for (int i=0;i<length;i++){
            int j = i + random.nextInt(length-i);
            swapCards(i, j);
        }
        
     
    }




    public static int indexLowest(int low, int high) {
    	  
      	
      	int lowest = low;
      	
      	for(int y = low; y < high; y++)
      	{
      		
      		if (y > high-1)
      		{
      			lowest = y;
      			
      			
      		}
      		
      	}

         return lowest;
          
      }
      
     
    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        int high = this.cards.length - 1;
        for (int i = 0; i < this.cards.length; i++) {
            int j = this.indexLowest(i, high);
            this.swapCards(i, j);
        }
    }
    
    

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    public static Deck merge(Deck d1, Deck d2) {
        Cards[] c1 = d1.cards;
        Cards[] c2 = d2.cards;
        Deck result = new Deck(c1.length + c2.length);
        Cards[] c3 = result.cards;
        int i = 0; 
        int j = 0; 


        for (int k = 0; k < c3.length; k++) {
            int choice;

            if (i >= c1.length) {
                choice = 2; 
            } else if (j >= c2.length) {
                choice = 1; 
            } else if (c1[i].compareTo(c2[j]) < 0) {
                choice = 1;  
            } else {
                choice = 2; 
            }

         
            if (choice == 1) {
                c3[k] = c1[i];
                i++;
            } else {
                c3[k] = c2[j];
                j++;
            }
        }
        return result;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {

        
        int size = this.cards.length;
        if (size < 2) {
            return this;
        }


        int mid = size / 2;
        Deck d1 = this.subdeck(0, mid - 1);
        Deck d2 = this.subdeck(mid, size - 1);

     
        d1 = d1.mergeSort();
        d2 = d2.mergeSort();
        return merge(d1, d2);
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
        for (int i = 1; i < this.cards.length; i++) {
            Cards card = this.cards[i];
            this.insert(card, i);
        }
    }

    /**
     * Helper method for insertion sort.
     */
    public void insert(Cards card, int i) {
        int j = i;
        while (j > 0 && card.compareTo(this.cards[j - 1]) < 0) {
            this.cards[j] = this.cards[j - 1];
            j--;
        }
    }
    
	public static void main(String[] args){
		
		
		}
	}


