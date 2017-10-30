import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name hereB0544129 施又丹
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 闂佸湱顣幏鐑芥煛閸繍妲烘繛鍫熷灴閹囨晸閿燂拷
	 * @param nDeck 缂備線缂氬Λ鍕矗閿熺姴瀚夊璺猴工閹稿嫰鏌涢幙鍐ㄧ仯濠⒀嶆嫹
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here definition how many card they are and put the deck into it add three loop ,X represent suit,Y represent rank
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		for(int i=1;i<=nDeck;i++)
		{
for(int X =1; X<=4; X++)
		
        {
            for(int Y=1; Y<=13;Y++)
            {
                cards.add(new Card(X,Y));
            }
        }  
		}
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1);->meansnew card as clubs ace
		//cards.add(card);
		//Sample code end//definition how many cards thet are

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		//print all card
		int a=cards.size();
		for(int i=0;i<=a-1;i++)
		{
			Card card=new Card(cards.get(i).getSuit(),cards.get(i).getRank());
			card.printCard();
	}

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here this method set every card ,let suit and rank transfor from number to word
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4 if I need to definition the suit and rank  String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	  //String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		if(getSuit()==1)
			System.out.print("Clubs,");
			if(getRank()==2)
				System.out.print("Diamonds,");
			if(getRank()==3)
				System.out.print("Hearts,");
			if(getRank()==4)
				System.out.print("Spades,");
			
		
		/*char a=(char)getSuit();
		
		switch(a)
		{
		case'1':
		System.out.println("Clubs");
			break;
		case '2':
		System.out.println("Diamonds");
			break;
		case '3':
			System.out.println("Hearts");	
			break;
		case '4':
			System.out.println("Spades");
			break;
		}*/
		if(getRank()==1)
		System.out.println("Ace");
		if(getRank()==2)
			System.out.println("2");
		if(getRank()==3)
			System.out.println("3");
		if(getRank()==4)
			System.out.println("4");
		if(getRank()==5)
			System.out.println("5");
		if(getRank()==6)
			System.out.println("6");
		if(getRank()==7)
			System.out.println("7");
		if(getRank()==8)
			System.out.println("8");
		if(getRank()==9)
			System.out.println("9");
		if(getRank()==10)
			System.out.println("10");
			if(getRank()==11)
		System.out.println("jack");
			if(getRank()==12)
			System.out.println("Queen");	
			if(getRank()==13)
			System.out.println("king");
			
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
