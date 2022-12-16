import java.util.Scanner;
import java.util.ArrayList;

public class Main { 
    public static void main(String[] args) {  

        ArrayList<Cards> deck = new ArrayList<Cards>();
        ArrayList<Cards> discard = new ArrayList<Cards>();
        ArrayList<Cards> hand1 = new ArrayList<Cards>();
        ArrayList<Cards> hand2 = new ArrayList<Cards>();

        for (int i = 0; i <=3; i++) {
            String cardCat = "";
            if (i==0) {
                cardCat = "Hearts";
            } else if (i==1) {
                cardCat = "Spades";
            } else if (i==2) {
                cardCat = "Diamonds";
            } else {
                cardCat = "Clubs";
            }
            
            for (int i2 = 0; i2<=8; i2++) {
                //System.out.println(cardCat);
                String concatenate = Integer.toString(i2+2);
                Cards card = new Cards((concatenate+" "+cardCat), i2+2);
                deck.add(card);
            } 
            
            String face = "";
            for (int i3 = 0; i3<=2; i3++) {
                if (i3==0) {
                    face = "Jack";
                } else if (i3==1) {
                    face = "Queen";
                } else {
                    face = "King";
                }
                String y = face+" of "+cardCat;
                Cards card = new Cards(y, 11+i3);
                deck.add(card);
            }

            String y = "Ace"+" of "+cardCat;
            Cards card = new Cards(y, 1);
            deck.add(card);
        }
        /*
        for (int i = 0; i<=51; i++) {
            System.out.print(deck.get(i).getCardName()+" ");
            System.out.println(deck.get(i).getValue());
        }
        */
        //System.out.println(deck.get(0).getValue());

        System.out.println("Welcome to Crazy Eights!!!");
        System.out.println("For information on how to play Crazy Eights please review the README file.");
        Scanner sc =  new Scanner(System.in);

        System.out.println("Player one, what is your name?");
        String p1Name = sc.nextLine();
        
        System.out.println("Player two, what is your name?");
        String p2Name = sc.nextLine();

        System.out.println(p1Name+" vs "+p2Name);
    }
}
