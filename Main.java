import java.util.Scanner;
import java.util.ArrayList;

public class Main { 
    public static void main(String[] args) {  

        ArrayList<Cards> deck = new ArrayList<Cards>();
        ArrayList<Cards> discard = new ArrayList<Cards>();
        ArrayList<Cards> hand1 = new ArrayList<Cards>();
        ArrayList<Cards> comphand = new ArrayList<Cards>();

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
                Cards card = new Cards((concatenate+" "+cardCat), i2+2, cardCat);
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
                Cards card = new Cards(y, 11+i3, cardCat);
                deck.add(card);
            }

            String y = "Ace"+" of "+cardCat;
            Cards card = new Cards(y, 1, cardCat);
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

        System.out.println("Player, what is your name?");
        String p1Name = sc.nextLine();

        System.out.print("\033[H\033[2J");

        //deals the cards out to both players
        int cards = 52;
        System.out.println("Here is your hand, "+p1Name);
        for (int d=0; d<=4; d++ ) {
            int rand = (int) ((Math.random()*cards));
            Cards y = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
            deck.remove(rand);
            hand1.add(y);
            System.out.println(hand1.get(d).getCardName());
            cards = cards-1;
        }

        for (int d=0; d<=4; d++ ) {
            int rand = (int) ((Math.random()*cards));
            Cards y = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
            deck.remove(rand);
            comphand.add(y);
            cards = cards-1;
        }

        int win = 0;
        int rand = (int) (1+(Math.random()*cards));
        deck.remove(rand);
        Cards topcard = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
        cards = cards-1;
        while(win==0) {
            System.out.println("\nOptions: \nA) Look at hand. \nB) Play a card. \nC) Draw a card.");
            System.out.println("\nThe top cards is: "+topcard.getCardName());
            String decision = sc.nextLine();

            if (decision.equals("A")) {
                System.out.print("\033[H\033[2J");
                System.out.println("You choose to look at your hand!");
                for (int d = 0; d < hand1.size(); d++) {
                    System.out.println(hand1.get(d).getCardName());
                }

            } else if (decision.equals("B")) {
                System.out.print("\033[H\033[2J");
                System.out.println("You choose to play a card!");

                //check for legal moves
                int legal = 0;
                for (int d = 0; d < hand1.size(); d++) {
                    if ((hand1.get(d).getCardType().equals(topcard.getCardType())) || (hand1.get(d).getValue() == (topcard.getValue()))) {
                        legal = legal+1;
                    }
                }

                if (legal == 0) {
                    System.out.println("Sorry you don't have any matching cards. You must draw a card.");
                } else if (legal > 0) {
                    int work = 0;
                    while (work == 0) {
                        System.out.println("Which card would you like to play?");
                        for (int d = 0; d < hand1.size(); d++) {
                            System.out.println(hand1.get(d).getCardName());
                        }
                        System.out.println("Select the Number (not value) of the card you want to play.");
                        int play = Integer.parseInt(sc.nextLine());
                        
                        if ((hand1.get(play-1).getCardType().equals(topcard.getCardType()))||(hand1.get(play-1).getValue() == (topcard.getValue()))) {
                            topcard = hand1.get(play-1);
                            hand1.remove(play-1);
                            work = 1;
                            System.out.print("\033[H\033[2J");
                            System.out.println("You played: "+topcard.getCardName());
                        } else {
                            System.out.println("You can't play that card. Please choose a different card.");
                        }
                        
                    }
                }

            } else if (decision.equals("C")) {
                System.out.print("\033[H\033[2J");
                System.out.println("You choose to draw a card!");
                rand = (int) ((Math.random()*cards));
                Cards y = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
                deck.remove(rand);
                hand1.add(y);
                System.out.println("You drew a: "+y.getCardName());

            } else {
                System.out.print("\033[H\033[2J");
                System.out.println("Please enter the option A, B or C with a capital letter.");
            }
        }
    }
}
