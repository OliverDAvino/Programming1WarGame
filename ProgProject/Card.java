/*Oliver D'Avino
Mikhayla de las Alas
 *0001 
 */

public class Card{
    protected int suit;
    protected int value;

    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
    }
    public String getSuitAsString(){
        switch (suit){
            case 1:
            return "Spades";
            case 2:
            return "Hearts";
            case 3:
            return "Diamonds";
            case 4:
            return "Clubs";
            default:
            return "Invalid suit";
        }
    }
    public String getValueAsString(){
    
        switch (value){
            case 1:
            return "Ace";
            case 2:
            return "2";
            case 3:
            return "3";
            case 4:
            return "4";
            case 5:
            return "5";
            case 6:
            return "6";
            case 7:
            return "7";
            case 8:
            return "8";
            case 9:
            return "9";
            case 10:
            return "10";
            case 11:
            return "Jack";
            case 12:
            return "Queen";
            case 13:
            return "King";
            default:
            return "Invalid value";
        }
    }
    public String toString(){
        return getValueAsString() + " of " + getSuitAsString();
    }
    public int getSuit(){
        return suit;
    }
    public int getValue(){
        return value;
    }
}