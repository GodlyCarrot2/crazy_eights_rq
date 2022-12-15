import java.util.Scanner;
import java.util.ArrayList;

public class Main { 
    public static void main(String[] args) { 
        System.out.println("Crazy Eights!"); 

        ArrayList<Cards> deck = new ArrayList<Cards>();
        
        int count = 0;
        /*
        for (int i = 0; i<=52; i++) {
            String x = Integer.toString(i);
            Cards card = new Cards(x, 0);
            deck.add(card);
        }
        */

        //hearts, spades, diamonds, clubs
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

            for (int i2 = 0; i2<=9; i2++) {
                //System.out.println(cardCat);
                String concatenate = Integer.toString(i2+1);
                Cards card = new Cards((concatenate+" "+cardCat), i2+1);
                deck.add(card);
            } 
            
            String face = "";
            for (int i3 = 0; i3<=2; i3++) {
                if (i3==0) {
                    face = "Jack ";
                } else if (i3==1) {
                    face = "Queen ";
                } else {
                    face = "King ";
                }
                String y = face.concat(cardCat);
                Cards card = new Cards(y, 11+i3);
                deck.add(card);
            }
        }

        for (int i = 0; i<=51; i++) {
            System.out.print(deck.get(i).getCardName()+" ");
            System.out.println(deck.get(i).getValue());
        }
        System.out.println(deck.get(0).getValue());
    }
}