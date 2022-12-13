import java.util.Scanner;
import java.util.ArrayList;

public class Main { 
    public static void main(String[] args) { 
        System.out.println("Crazy Eights!"); 

        ArrayList<Cards> cards = new ArrayList<Cards>();
        
        int count = 0;
        /*
        for (int i = 0; i<=52; i++) {
            String x = Integer.toString(i);
            Cards card = new Cards(x, 0);
            cards.add(card);
        }
        */

        //hearts, spades, diamonds, clubs
        for (int i = 0; i <=4; i++) {
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

            for (int i2 = 0; i2<=10; i2++) {
                
            }
        }

        for (int i = 0; i<=52; i++) {
            System.out.print(cards.get(i).getCardName()+" ");
            System.out.println(cards.get(i).getValue());
        }
        System.out.println(cards.get(0).getValue());
    }
}