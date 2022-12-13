public class Cards {
    private String cardName;
    private int value;
    
    public Cards() {
        cardName = "";
        value = 0;
    }

    public Cards(String a, int b) {
        cardName = a;
        value = b;
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
}
