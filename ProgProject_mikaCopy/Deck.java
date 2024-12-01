public class Deck{
    private Card[] deck;
    private int numCards;

public Deck(int size){
    deck = new Card[size];
    int numCards = 0;
}
public Deck(){
    deck = new Card[54];
    int index = 0;
    numCards = 54;


    for (int suit = 1; suit < 5; suit++){
        for(int value = 1; value < 14; value++){
            deck[index] = new Card(suit, value);
                index++;
        }
    }
    deck[52] = new Joker(5, 14);
    deck[53] = new Joker(5, 14);
}

public void shuffle(){
    for (int i = deck.length-1; i > 0; i--){
        int rand = (int)(Math.random()*(i+1));
        Card temp = deck[i];
        deck[i] = deck[rand];
        deck[rand] = temp;
    }
}
public Card dealCard(int index){
    return deck[index];
}
public Card dealCard(){
    if(numCards <= 0){
        System.out.println("Empty deck");
    }
    return deck[--numCards];
    }

public void addToDeck(Card card){
    if(numCards < 54){
        deck[numCards++] = card;
        
    }
}
public void printDeck(){
    for(int i = 0; i < numCards; i++){
        System.out.println(deck[i]);
    }
    if(numCards <= 0){
        System.out.println("Empty deck");
    }
}
public void addWholeDeck(Deck tempDeck){
    do{
        addToDeck(tempDeck.dealCard());
    }
    while(tempDeck.getNumCards() != 0);
}
public int getNumCards(){
    return numCards;
}
}

