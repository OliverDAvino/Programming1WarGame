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
        Deck sideDeck = new Deck();
        int p1NumCards;
        int p2NumCards;
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
        System.out.println("The cards have now been shuffled and dealt.");
        do{
        p1NumCards = p1Deck.getNumCards();
        p2NumCards = p2Deck.getNumCards();
        System.out.println(p1Name + " please press enter to deal a card.");
        input.nextLine();
        Card p1Card = p1Deck.dealCard();
        System.out.println("You dealt a " + p1Card.toString());
        System.out.println(p2Name + " please press enter to deal a card.");
        input.nextLine();
        Card p2Card = p2Deck.dealCard();
        System.out.println("You dealt a " + p2Card.toString());
            if(p1Card.getValue() > p2Card.getValue()){      //add cards to p1 deck if p1 wins
                System.out.println(p1Name + " wins this round!");
                p1Deck.addToDeck(p1Card);
                p1Deck.addToDeck(p2Card);
                p1NumCards++;
                p2NumCards--;
                if(sideDeck.getNumCards() > 0){             //check if side deck has cards and add to winning deck if so
                    p1Deck.addWholeDeck(sideDeck);
                    p1NumCards = p1NumCards + sideDeck.getNumCards();
                }
            }
            else if(p1Card.getValue() < p2Card.getValue()){     //add cards to p2 deck if p2 wins
                System.out.println(p2Name + " wins this round!");
                p2Deck.addToDeck(p1Card);
                p2Deck.addToDeck(p2Card);
                p1NumCards--;
                p2NumCards++;
                if(sideDeck.getNumCards() > 0){         //check if side deck has cards and add to winning deck if so
                    p2Deck.addWholeDeck(sideDeck);
                    p2NumCards = p2NumCards + sideDeck.getNumCards();
                }
            }
            else{                                       //add cards to side deck if tie
                System.out.println("This round is a tie!");
                sideDeck.addToDeck(p1Card);
                sideDeck.addToDeck(p2Card);
            }
        }
        while(p1NumCards > 0 && p2NumCards > 0);

        if(p1NumCards == 0){
            System.out.println("Congratulations " + p2Name + " you won!");
        }
        else if(p2NumCards == 0){
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