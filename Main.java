//Imports Scanner, ArrayList and Collections
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main { 
    public static void main(String[] args) {  

        //Creates the ArrayLists
        ArrayList<Cards> deck = new ArrayList<Cards>(); //the array list for the deck
        ArrayList<Cards> discard = new ArrayList<Cards>(); //the array list for the discard pile
        ArrayList<Cards> hand1 = new ArrayList<Cards>(); //the array list for the player hand
        ArrayList<Cards> comphand = new ArrayList<Cards>(); //the array list for the computer hand

        //Creates every single card of the deck
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
            
            //Creates all the number cards
            for (int i2 = 0; i2<=8; i2++) {
                String concatenate = Integer.toString(i2+2);
                Cards card = new Cards((concatenate+" "+cardCat), i2+2, cardCat);
                deck.add(card);
            } 
            
            //Creates all the face cards
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

            //Creates the 4 aces
            String y = "Ace"+" of "+cardCat;
            Cards card = new Cards(y, 1, cardCat);
            deck.add(card);
        }

        //Starts the game and asks the user for their name
        System.out.print("\033[H\033[2J"); //clears the terminal
        System.out.println("Welcome to Crazy Eights!!!");
        System.out.println("For information on how to play Crazy Eights please review the README file.");
        Scanner sc =  new Scanner(System.in);
        
        //Asks the user for their name
        System.out.println("Player, what is your name?");
        String p1Name = sc.nextLine();

        System.out.print("\033[H\033[2J");

        //deals the cards out to both the user and the computer
        int cards = 52;
        System.out.println("Here is your hand, "+p1Name);
        for (int d=0; d<=4; d++ ) {
            int rand = (int) ((Math.random()*deck.size()));
            Cards y = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
            deck.remove(rand);
            hand1.add(y);
            System.out.println(hand1.get(d).getCardName());
            cards = cards-1;
        }

        for (int d=0; d<=4; d++ ) {
            int rand = (int) ((Math.random()*deck.size()));
            Cards y = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
            deck.remove(rand);
            comphand.add(y);
            cards = cards-1;
        }

        //initializes the game phase and the variable
        int win = 0;
        //chooses the first top card
        int rand = (int) (1+(Math.random()*deck.size()));
        deck.remove(rand);
        Cards topcard = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
        cards = cards-1;
        //while loop to keep the game running
        while(win==0) {
            //asks the user for their action
            System.out.println("\nOptions: \nA) Look at hand. \nB) Play a card. \nC) Draw a card.");
            System.out.println("\nThe top cards is: "+topcard.getCardName()); //prints the top cards
            String decision = sc.nextLine();

            //Allows the user to view their hand
            if (decision.equals("A")) {
                System.out.print("\033[H\033[2J");
                System.out.println("You choose to look at your hand!");
                for (int d = 0; d < hand1.size(); d++) {
                    System.out.println(hand1.get(d).getCardName());
                }
            
            //Lets the user play a card
            } else if (decision.equals("B")) {
                System.out.print("\033[H\033[2J");
                System.out.println("You choose to play a card!");

                //check for legal moves
                int legal = 0;
                for (int d = 0; d < hand1.size(); d++) {
                    if ((hand1.get(d).getCardType().equals(topcard.getCardType())) || (hand1.get(d).getValue() == (topcard.getValue())) || hand1.get(d).getValue() == 8) {
                        legal = legal+1;
                    }
                }

                //Asked the user to draw a card if they don't have any playable card.
                if (legal == 0) {
                    System.out.println("Sorry you don't have any matching cards. You must draw a card.");
                //Ask the user which carde they want to play.
                } else if (legal > 0) {
                    int work = 0;
                    while (work == 0) {
                        System.out.println("Which card would you like to play?");
                        for (int d = 0; d < hand1.size(); d++) {
                            System.out.println(hand1.get(d).getCardName());
                        }
                        System.out.println("Select the Number (not value) of the card you want to play.");
                        int play = Integer.parseInt(sc.nextLine());
                        
                        if ((hand1.get(play-1).getCardType().equals(topcard.getCardType())) || (hand1.get(play-1).getValue() == (topcard.getValue())) || hand1.get(play-1).getValue() == 8) { //checks if the card chosen is valid
                            topcard = hand1.get(play-1); //changes the topcard
                            discard.add(hand1.get(play-1)); //adds the card to the discard array list

                            //if they play an 8, this asks for the suit they want to change it to.
                            if (hand1.get(play-1).getValue() == 8) {
                                Scanner scan = new Scanner(System.in);
                                System.out.println("Which suit would you like to chance it to? \nA) Hearts \nB) Spades \nC) Clubs \nD) Diamonds");
                                String suit = scan.nextLine();
                                if (suit.equals("A")) {
                                    System.out.println("You choose: Hearts");
                                    topcard.setCardType("Hearts");
                                    topcard.setCardName("8 of Hearts");
                                } else if (suit.equals("B")) {
                                    System.out.println("You choose: Spades");
                                    topcard.setCardType("Spades");
                                    topcard.setCardName("8 of Spades");
                                } else if (suit.equals("C")) {
                                    System.out.println("You choose: Clubs");
                                    topcard.setCardType("Clubs");
                                    topcard.setCardName("8 of Clubs");
                                } else if (suit.equals("D")) {
                                    System.out.println("You choose: Diamonds");
                                    topcard.setCardType("Diamonds");
                                    topcard.setCardName("8 of Diamonds");
                                }
                            }
                            
                            //removes the card from player hand and exits the loop
                            hand1.remove(play-1);
                            work = 1;

                            //Informs the user of what they played
                            System.out.print("\033[H\033[2J");
                            System.out.println("You played: "+topcard.getCardName());
                            
                            //checks if the user won
                            if (hand1.size() == 0) {
                                win = 1; 
                                break;
                            }

                            //has the AI choose a random card it can play
                            int done = 0;
                            while (done == 0) {
                                //checks if the computer has any legal moves.
                                int legal2 = 0;
                                for (int d = 0; d < comphand.size(); d++) {
                                    if ((comphand.get(d).getCardType().equals(topcard.getCardType())) || (comphand.get(d).getValue() == (topcard.getValue())) || comphand.get(d).getValue() == 8) {
                                        legal2 = legal2+1;
                                    }
                                }
                                if (legal2 == 0) {
                                    //draws cards for the AI if they cannot play a card
                                    rand = (int) ((Math.random()*deck.size()));
                                    Cards y = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
                                    deck.remove(rand);
                                    comphand.add(y);

                                    //reshuffles the deck if there are 0 cards left
                                    if (deck.size() == 0) {
                                        for (int i = discard.size(); i >= 1; i--) {
                                            Cards z = new Cards(discard.get(i).getCardName(), discard.get(i).getValue(), discard.get(i).getCardType());
                                            deck.add(z);
                                            discard.remove(i);
                                        }
                                        Collections.shuffle(deck);
                                        Cards z = new Cards(topcard.getCardName(), topcard.getValue(), topcard.getCardType()); 
                                        deck.remove(z);
                                        discard.add(z);
                                        System.out.println("Deck Reset");
                                    }
                                //if the computer has a card they can play it chooses the first one it can play
                                } else if (legal2 > 0) {
                                    Collections.shuffle(comphand);
                                    for (Cards i: comphand) {
                                        if ((i.getCardType().equals(topcard.getCardType())) || (i.getValue() == (topcard.getValue())) || i.getValue() == 8) {
                                            topcard = i;
                                            discard.add(i);
                                            comphand.remove(i);
                                            break;
                                        }
                                   }
                                   done = 1; //breaks out of the loop
                                }
                            }
                            System.out.println("The AI played a: "+topcard.getCardName()); //informs the user of what the computer played

                            //checks if the AI won
                            if (comphand.size() == 0) {
                                win = 2;
                                break;
                            }

                        } else {
                            System.out.println("\nYou can't play that card. Please choose a different card.\n"); //informs the user if they choose a card they cannot play
                        }
                        
                    }
                }
            
            //The code for when the user draws a card
            } else if (decision.equals("C")) { 
                System.out.print("\033[H\033[2J");
                System.out.println("You choose to draw a card!");
                rand = (int) ((Math.random()*deck.size()));
                Cards y = new Cards(deck.get(rand).getCardName(), deck.get(rand).getValue(), deck.get(rand).getCardType());
                deck.remove(rand);
                hand1.add(y);
                System.out.println("You drew a: "+y.getCardName());

                //reshuffles deck if 0
                if (deck.size() == 0) {
                    for (int i = discard.size(); i >= 1; i--) {
                        Cards z = new Cards(discard.get(i).getCardName(), discard.get(i).getValue(), discard.get(i).getCardType());
                        deck.add(z);
                        discard.remove(i);
                    }
                    Collections.shuffle(deck);
                    Cards z = new Cards(topcard.getCardName(), topcard.getValue(), topcard.getCardType()); 
                    deck.remove(z);
                    discard.add(z);
                    System.out.println("Deck Reset");
                }
            
            //The code for when the user doesn't input an A, B, C or D
            } else {
                System.out.print("\033[H\033[2J");
                System.out.println("Please enter the option A, B or C with a capital letter.");
            }

            //checks if the user or computer has won
            if (hand1.size() == 0) {
                win = 1; 
            } else if (comphand.size() == 0) {
                win = 2;
            }
        }
        
        //Informs the user if they won or lost
        if (win == 1) {
            System.out.println("You Won!!");
        } else if (win == 2) {
            System.out.println("You lost.");
        }
    }
}
