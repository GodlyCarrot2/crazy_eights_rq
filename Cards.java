public class Cards {
    //creates the variables
    private String cardName;
    private int value;
    private String cardType;

    //makes the constructors
    public Cards() {
        cardName = "";
        value = 0;
        cardType = "";
    }

    //Creates the getters and setters
    public Cards(String a, int b, String c) {
        cardName = a;
        value = b;
        cardType = c;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String a) {
        cardName = a;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int b) {
        value = b;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String c) {
        cardType = c;
    }
}
