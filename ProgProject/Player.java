public class Player{
    private String name;
    private Deck playerDeck;

public Player(String name){
    playerDeck = new Deck(54);
}
public String getPlayerName(){
    return name;
}
public Deck getDeck(){
    return playerDeck;
    }
}

