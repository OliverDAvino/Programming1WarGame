public class Joker extends Card{
    public Joker(int suit, int value){
        super(suit, value);
    }
    public String getSuitAsString(){
        return "Joker";
    }
    public String getValueAsString(){
        return Integer.toString(value);
    }
}
