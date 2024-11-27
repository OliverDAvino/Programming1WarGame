import java.util.Scanner;

public class Game{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tries = 0;
        while (tries < 5) {
        Deck myDeck = new Deck();
        //myDeck.shuffle();
        System.out.println("Please enter your guess (ex. Ace of Diamonds): ");
        String playerGuess = input.nextLine();
        System.out.println("Pick a card from the deck by choosing a number between 0-53: ");
        int playCard = input.nextInt();
        Card dealtCard = myDeck.dealCard(playCard);
        System.out.println("You drew a " + dealtCard.toString());
        if(dealtCard.toString().equals(playerGuess)){
            System.out.println("Congratulations! You guessed right! Play again next time!");
            break;
        }
        else if(tries < 5){
            System.out.println("Game over! You ran out of tries.");
            break;
        }
        else{
            System.out.println("Oh no! You guessed wrong. Try again.");
            input.nextLine();
            tries++;
        }
    }
}
}