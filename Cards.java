public class Cards {
    private String cardName;
    private int value;
    private String cardType;
    
    public Cards() {
        cardName = "";
        value = 0;
        cardType = "";
    }

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
