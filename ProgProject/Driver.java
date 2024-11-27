/*Oliver D'Avino
Mikhayla de las Alas
 *0001 
 */

import java.util.Scanner;
import java.util.ArrayList;
public class Driver{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter player 1's name: ");
        Player player1 = new Player(input.nextLine());
        System.out.println("Please enter player 2's name: ");
        Player player2 = new Player(input.nextLine());
        Deck gameDeck = new Deck();
        Deck sideDeck = new Deck();
        Deck player1Deck = player1.getDeck();
        Deck player2Deck = player2.getDeck();
        int j = 0;
        for(int i = 0; i < 27; i++){
            gameDeck.shuffle();
            Card p1Card = gameDeck.dealCard(j++);
            Card p2Card = gameDeck.dealCard(j++);
            int p1CardValue = p1Card.getValue();
            int p2CardValue = p2Card.getValue();
            if(p1CardValue>p2CardValue){
                player1Deck.addToDeck(p1Card);
                player1Deck.addToDeck(p2Card);
                player1Deck.addWholeDeck(sideDeck);
                
                
                }
            else if(p2CardValue>p1CardValue){
                player2Deck.addToDeck(p1Card);
                player2Deck.addToDeck(p2Card);   
                player2Deck.addWholeDeck(sideDeck);
            }
            else{
                sideDeck.addToDeck(p1Card);
                sideDeck.addToDeck(p2Card);
            }
        }
        System.out.println("Player 1: Press Enter to deal a card:" );
        input.nextLine();
        System.out.println("Player 1 has: " + player1Deck.getNumCards());
        System.out.println("Player 1: Press Enter to deal a card:" );
        input.nextLine();
        System.out.println("Player 2 has: " + player2Deck.getNumCards());
        
        
        
        
        
        
        
        
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