package com.company;

import java.util.Scanner;

public class Main {

    String [] deck = new String[52];

    public void createAllCards(){
        String[] colour = new String[4];
        colour[0] = "Hearts";
        colour[1] = "Spades";
        colour[2] = "Clubs";
        colour[3] = "Diamonds";

        String[] number = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jacks", "Queen", "King"};

        String card = "";
        int deckNumber = 0;
        for (int c = 0; c < colour.length; c++){
            for (int n = 0; n < number.length; n++){
                card = number[n]+ " of " + colour[c];
                deck[deckNumber] = card;
                deckNumber++;
            }
        }
    }
    public void outputCards(){
        for (int i = 0; i < 52; i++) {
            System.out.println(deck[i]);
        }
    }

    public void shuffleTwoCards (int cardA, int cardB){
        String cardOne = deck[cardA];
        deck[cardA] = deck[cardB];
        deck[cardB] = cardOne;
    }

    public void shuffleDeck() {
        for (int x = 0; x < 100; x++) {
            int randomCardA = (int) (Math.random() * 52);
            int randomCardB = (int) (Math.random() * 52);
            shuffleTwoCards(randomCardA,randomCardB);
        }
    }

    public String pickRandomCard(){
        int random = (int) (Math.random() * 52);
        String randomCard = deck[random];
        return randomCard;
    }

    public String pickTopCard(){
        String topCard = deck[0];
        return topCard;
    }

    public void userInterface(){
        createAllCards();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\nWelcome to your virtual deck of cards.");
        System.out.println("Press any key to continue!");
        String next = sc.nextLine();

        boolean run = true;

        while (run){
            System.out.println("\n\nWhat do you wish to do next?");
            System.out.println("Press 1: See all cards in deck");
            System.out.println("Press 2: Shuffle deck");
            System.out.println("Press 3: Get a new deck");
            System.out.println("Press 4: Pick a card from a random location in the deck");
            System.out.println("Press 5: Pick top card of the deck");
            System.out.println("Press 9: To end");
            String choice = sc.next();
            switch(choice) {
                case "1":
                    outputCards();
                    break;
                case "2":
                    shuffleDeck();
                    break;
                case "3":
                    createAllCards();
                    break;
                case "4":
                    System.out.println("The chosen card is: " + pickRandomCard());
                    break;
                case "5":
                    System.out.println("The chosen card is: " + pickTopCard());
                    break;
                case "9":
                    System.out.println("\n\nThank you for using Lindinger's Virtual Card Program.");
                    run = false;
                    break;
                default:
                    System.out.println("\nInvalid input!\nPlease try again");
                }
            }
        }

    public static void main(String[] args) {
    Main prg = new Main();

    prg.userInterface();
    }
}
