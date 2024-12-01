import java.util.Scanner;
public class Driver{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
            System.out.println("Please enter player 1's name: ");
                String p1Name = input.nextLine();
        Player player1 = new Player(p1Name);
            System.out.println("Please enter player 2's name: ");
                String p2Name = input.nextLine();
        Player player2 = new Player(p2Name);
        Deck gameDeck = new Deck();
            Deck p1Deck = player1.getDeck();
            Deck p2Deck = player2.getDeck();
            Deck sideDeck = new Deck(54);
        //intro to game starts here
        System.out.println("Welcome " + p1Name + " & " + p2Name);
        System.out.println("Please press enter to shuffle and split the deck");
        input.nextLine();
        gameDeck.shuffle();     //shuffle the deck
        
        int j = 0;
        for(int i = 0; i < 27; i++){    //split the deck between 2 players
            Card p1Card = gameDeck.dealCard(j++);
            Card p2Card = gameDeck.dealCard(j++);
            p1Deck.addToDeck(p1Card);
            p2Deck.addToDeck(p2Card);
        }
        //this is where the game actually begins
        System.out.printf("The cards have now been shuffled and dealt.");
        int p1NumCards = p1Deck.getNumCards();
        int p2NumCards = p2Deck.getNumCards();
        do  {
        
            p1NumCards = p1Deck.getNumCards();
            p2NumCards = p2Deck.getNumCards();
            System.out.println(p1Name+ " has "+ p1NumCards + " cards");
            System.out.println(p2Name+ " has "+ p2NumCards + " cards");
            System.out.println(p1Name + " please press enter to deal a card.");
            input.nextLine();
            Card p1Card = p1Deck.dealCard();
            System.out.println("You dealt a " + p1Card.toString());
            System.out.println(p2Name + " please press enter to deal a card.");
            input.nextLine();
        Card p2Card = p2Deck.dealCard();
            System.out.println("You dealt a " + p2Card.toString());

                if(p1Card.getValue() > p2Card.getValue()){      //add cards to p1 deck if p1 wins 
                    p1Deck.addToDeck(p1Card);
                    p1Deck.addToDeck(p2Card);
                    if(sideDeck.getNumCards() > 0){
                        p1Deck.addWholeDeck(sideDeck);
                    }
                        System.out.println(p1Name + " wins this round!");

            }
            else if(p1Card.getValue() < p2Card.getValue()){     //add cards to p2 deck if p2 wins
                p2Deck.addToDeck(p1Card);
                p2Deck.addToDeck(p2Card);
                if(sideDeck.getNumCards() > 0){
                p2Deck.addWholeDeck(sideDeck);
            }
                    System.out.println(p2Name + " wins this round!");
                
            }
            else{                                       //add cards to side deck if tie
                sideDeck.addToDeck(p1Card);
                sideDeck.addToDeck(p2Card);
                System.out.println("This round is a tie!");
                
            }
        }
        while(p1Deck.getNumCards() != 0 && p2Deck.getNumCards() != 0);
        if(p1NumCards == 0){
            System.out.println("Congratulations " + p2Name + " you won!");
        }
        else{
            System.out.println("Congratulations " + p1Name + " you won!");
        }

        // System.out.println( p1Name +"'s deck is: ");
        // player1.getDeck().printDeck();
        // System.out.println(p2Name + "'s deck is: ");
        // player2.getDeck().printDeck();
        
        // for(int i = 0; i < 27; i++){                        //first transfer
        //     Card p1Card = player1.getDeck().dealCard();
        //     player2.getDeck().addToDeck(p1Card);
        // }
        // System.out.println("Now, P1's new deck is: ");
        // player1.getDeck().printDeck();
        // System.out.print("Now, P2's new deck is: ");
        // player2.getDeck().printDeck();

        // for(int i = 0; i < 54; i++){                          //second transfer
        //     Card p2Card = player2.getDeck().dealCard();
        //     player1.getDeck().addToDeck(p2Card);
        // }
        // System.out.println("Now, P1's new deck is: ");
        // player1.getDeck().printDeck();
        // System.out.print("Now, P2's new deck is: ");
        // player2.getDeck().printDeck();
    }
}