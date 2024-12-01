/*Oliver D'Avino
Mikhayla de las Alas
 *0001 
 */

import java.util.Scanner;
public class Driver{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Player 1 name: ");
        String p1Name = input.nextLine();
        System.out.println("Player 2 name: ");
        String p2Name = input.nextLine();
        Player player1 = new Player(p1Name);
        Player player2 = new Player(p2Name);
        Deck gameDeck = new Deck();
        Deck sideDeck = new Deck();
        Deck player1Deck = player1.getDeck();
        Deck player2Deck = player2.getDeck();

        for(int i = 0; i < 54; i++){
            gameDeck.shuffle();
            Card p1Card = gameDeck.dealCard(i++);
            Card p2Card = gameDeck.dealCard(i);
            // if(p1CardValue>p2CardValue){
            player1Deck.addToDeck(p1Card);
                //player1Deck.addToDeck(p2Card);
                //'player1Deck.addWholeDeck(sideDeck);
                
                
            //     }
            // else if(p2CardValue>p1CardValue){
                player2Deck.addToDeck(p2Card);
                //player2Deck.addToDeck(p2Card);   
                //player2Deck.addWholeDeck(sideDeck);
            // }
            // else{
                //sideDeck.addToDeck(p1Card);
                //sideDeck.addToDeck(p2Card);
            // }
        }
        // System.out.println("Player 1: Press Enter to deal a card:" );
        // input.nextLine();
        System.out.println("Player 1 has " + player1Deck.getNumCards() + " cards");
        // System.out.println("Player 1: Press Enter to deal a card:" );
        // input.nextLine();
        System.out.println("Player 2 has " + player2Deck.getNumCards() + " cards");
        System.out.println("Player 1 deck ");
        player1Deck.printDeck();
        System.out.println("-----------------");
        System.out.println("Player 2 deck ");
        player2Deck.printDeck();
        int i = 0;
        do{
            
            System.out.println("Player 1, Press Enter to deal a card.");
            input.nextLine();
            Card Player2Card = player2Deck.dealCard(i++);
            System.out.println(Player2Card);
            System.out.println("Player 2, Press Enter to deal a card.");
            input.nextLine();
            Card Player1Card = player1Deck.dealCard(i);
            if(Player1Card.getValue() > Player2Card.getValue()){
                player1Deck.addToDeck(Player2Card);
                player1Deck.addWholeDeck(sideDeck);
                player1Deck.getNumCards();
            }
            else if(Player2Card.getValue() > Player1Card.getValue()){
                player2Deck.addToDeck(Player2Card);
                player2Deck.addWholeDeck(sideDeck);
                player2Deck.getNumCards();
            }
            else{
                sideDeck.addToDeck(Player1Card);
                sideDeck.addToDeck(Player2Card);
            }
        }
        while (player1Deck.getNumCards() != 0 || player2Deck.getNumCards() != 0);

        player1Deck.printDeck();

        player2Deck.printDeck();

        sideDeck.printDeck();
        
        
        
        
        
        // System.out.println("P1's deck is: ");
        // player1Deck.printDeck();
        
        // System.out.println("P2's deck is: ");
        // player2Deck.printDeck();
        
        // for(int i = 0; i < 27; i++){                        //first transfer
        //     Card p1Card = player1Deck.dealCard();
        //     player2Deck.addToDeck(p1Card);
        // }
        // System.out.println("Now, P1's new deck is: ");
        // player1Deck.printDeck();
        // System.out.print("Now, P2's new deck is: ");
        // player2Deck.printDeck();

        // for(int i = 0; i < 54; i++){                          //second transfer
        //     Card p2Card = player2Deck.dealCard();
        //     player1Deck.addToDeck(p2Card);
        // }
        // System.out.println("Now, P1's new deck is: ");
        // player1Deck.printDeck();
        // System.out.print("Now, P2's new deck is: ");
        // player2Deck.printDeck();
    }
}