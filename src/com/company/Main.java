package com.company;

import java.util.Scanner;

public class Main {
  int nextCard = 0;
  String[] deck = new String[52];
  Scanner sc = new Scanner(System.in);

  public void createAllCards() {
    String[] colour = new String[4];
    colour[0] = "\u001B[40mSpades\u001B[0m";
    colour[1] = "\u001B[40mClubs\u001B[0m";
    colour[2] = "\u001B[31mHearts\u001B[0m";
    colour[3] = "\u001B[31mDiamonds\u001B[0m";

    String[] number = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jacks", "Queen", "King"};

    String card = "";
    int deckNumber = 0;
    for (int c = 0; c < colour.length; c++) {
      for (int n = 0; n < number.length; n++) {
        card = number[n] + " of " + colour[c];
        deck[deckNumber] = card;
        deckNumber++;
      }
    }
  }

  public void outputCards() {
    for (int i = 0; i < 52; i++) {
      System.out.println(deck[i]);
    }
  }

  public void shuffleTwoCards(int cardA, int cardB) {
    String cardOne = deck[cardA];
    deck[cardA] = deck[cardB];
    deck[cardB] = cardOne;
  }

  public void shuffleDeck() {
    for (int x = 0; x < 100; x++) {
      int randomCardA = (int) (Math.random() * 52);
      int randomCardB = (int) (Math.random() * 52);
      shuffleTwoCards(randomCardA, randomCardB);
    }
  }

  public String pickRandomCard() {
    int random = (int) (Math.random() * 52);
    String randomCard = deck[random];
    return randomCard;
  }

  public String pickTopCard() {
    String topCard = deck[nextCard];
    return topCard;
  }

  public void pickTopCardGame(){
    boolean getOut = true;
    while (getOut) {
      System.out.println("\nPress 1:  pick the next card");
      System.out.println("Press 2:  go back to main menu");
      String choice1 = sc.next();
      switch (choice1) {
        case "1":
          if (nextCard == 51){
            nextCard = 0;
          }else {
            nextCard++;
          }
          System.out.println(pickTopCard());
          break;
        case "2":
          getOut = false;
          break;
        default:
          System.out.println("Invalid input!");
          System.out.println("Please try again");
      }
    }
  }

  public void userInterface() {
    createAllCards();
    System.out.println("\n\n\nWelcome to your virtual deck of cards.");
    System.out.println("Press any key to continue!");
    String next = sc.nextLine();

    boolean run = true;

    while (run) {
      System.out.println("\n\nWhat do you wish to do next?");
      System.out.println("Press 1: See all cards in deck");
      System.out.println("Press 2: Shuffle deck");
      System.out.println("Press 3: Pick top card of the deck");
      System.out.println("Press 4: Pick a card from a random location in the deck");
      System.out.println("Press 5: Get a fresh deck cards");
      System.out.println("Press 9: To end");
      String choice = sc.next();
      switch (choice) {
        case "1":
          outputCards();
          break;
        case "2":
          shuffleDeck();
          break;
        case "3":
          System.out.println("\n" + pickTopCard());
          pickTopCardGame();
          break;
        case "4":
          System.out.println("\nThe chosen card is: " + pickRandomCard());
          break;
        case "5":
          createAllCards();
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
