// Author: Ethan
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.*;
import java.util.Arrays;

public class Deck {

  private static int numberOfDecks;
  private static String shuffleTogetherOrSeperately;
  private static String removeActionCards;
  private static String[] currentDeck;

  //Constructor. Pass three variables to tell the deck class how to format your
  //deck for you, then it will return a deck that has been formatted properly.
  public Deck(int numberOfDecks, String shuffleTogetherOrSeperately, String removeActionCards) {
    this.numberOfDecks = numberOfDecks;
    this.shuffleTogetherOrSeperately = shuffleTogetherOrSeperately;
    this.removeActionCards = removeActionCards;
  }

  private static String[] createWithActionCards() {
    //Create a deck and return it.
    String[] newDeck = new String[108];
    for(Card.CardColor color: Card.CardColor.values()) {
        for(Card.CardValue description: Card.CardValue.values()) {
          for(int i = 0; i < newDeck.length; i++) {
            if (newDeck[i] == null) {
              if(description.toString() == "ZERO") {
                newDeck[i] = ((color + ", " + description + ", " + color.getWorkout()).toLowerCase());
                break;
              }
              else {
                newDeck[i] = ((color + ", " + description + ", " + color.getWorkout()).toLowerCase());
                newDeck[i+1] = ((color + ", " + description + ", " + color.getWorkout()).toLowerCase());
                break;
              }
            }
          }
        }
        for(Card.SpecialCards card: Card.SpecialCards.values()) {
          for(int i = 0; i < newDeck.length; i++) {
            if (newDeck[i] == null) {
             newDeck[i] = ((color + ", " + card + ", " + card.getDescription()).toLowerCase());
             newDeck[i+1] = ((color + ", " + card + ", " + card.getDescription()).toLowerCase());
             break;
             }
          }
        }
    }
    for(Card.WildCards card: Card.WildCards.values()) {
      for(int i = 0; i < newDeck.length; i++) {
        if (newDeck[i] == null) {
         newDeck[i] = ((card + ", " + card.getDescription()).toLowerCase());
         newDeck[i+1] = ((card + ", " + card.getDescription()).toLowerCase());
         newDeck[i+2] = ((card + ", " + card.getDescription()).toLowerCase());
         newDeck[i+3] = ((card + ", " + card.getDescription()).toLowerCase());
         break;
         }
      }
    }
    return newDeck;
  }
  private static String[] createWithoutActionCards() {
    //Create a deck and return it.
    String[] newDeck = new String[84];
    for(Card.CardColor color: Card.CardColor.values()) {
        for(Card.CardValue description: Card.CardValue.values()) {
          for(int i = 0; i < newDeck.length; i++) {
            if (newDeck[i] == null) {
              if(description.toString() == "ZERO") {
                newDeck[i] = ((color + ", " + description + ", " + color.getWorkout()).toLowerCase());
                break;
              }
              else {
                newDeck[i] = ((color + ", " + description + ", " + color.getWorkout()).toLowerCase());
                newDeck[i+1] = ((color + ", " + description + ", " + color.getWorkout()).toLowerCase());
                break;
              }
            }
          }
        }
    }
    for(Card.WildCards card: Card.WildCards.values()) {
      for(int i = 0; i < newDeck.length; i++) {
        if (newDeck[i] == null) {
         newDeck[i] = ((card + ", " + card.getDescription()).toLowerCase());
         newDeck[i+1] = ((card + ", " + card.getDescription()).toLowerCase());
         newDeck[i+2] = ((card + ", " + card.getDescription()).toLowerCase());
         newDeck[i+3] = ((card + ", " + card.getDescription()).toLowerCase());
         break;
         }
      }
    }
    return newDeck;
  }
  private static String[] shuffle(String[] deck) {
    //Fischer-Yates Shuffle Example from https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    Random rnd = ThreadLocalRandom.current();
      for (int i = deck.length - 1; i > 0; i--)
      {
        int index = rnd.nextInt(i + 1);
        // Simple swap
        String holder = deck[index];
        deck[index] = deck[i];
        deck[i] = holder;
      }
    return deck;
  }
  private static String[] combineTwo(String[] firstDeck, String[] secondDeck) {
    String[] outputString = new String[firstDeck.length + secondDeck.length];
    for(int i = 0; i < firstDeck.length; i++) {
      outputString[i] = firstDeck[i];
    }
    for(int j = firstDeck.length; j < (firstDeck.length + secondDeck.length); j++) {
      outputString[j] = secondDeck[j - firstDeck.length];
    }
    return outputString;
    //combine the two decks above into one deck
  }
  private static String[] combineThree(String[] firstDeck, String[] secondDeck, String[] thirdDeck) {
    //Combine three decks into one deck
    String[] outputString = new String[firstDeck.length + secondDeck.length + thirdDeck.length];
    for(int i = 0; i < firstDeck.length; i++) {
      outputString[i] = firstDeck[i];
    }
    for(int j = firstDeck.length; j < (firstDeck.length + secondDeck.length); j++) {
      outputString[j] = secondDeck[j - firstDeck.length];
    }
    for(int k = firstDeck.length + secondDeck.length; k < (firstDeck.length + secondDeck.length + thirdDeck.length); k++) {
      outputString[k] = secondDeck[k - firstDeck.length - secondDeck.length];
    }
    return outputString;
  }
  private static String[] testValidDeck() {
    String[] testingDeck = Deck.currentDeck.clone();
    int blueCounter = 0;
    int greenCounter = 0;
    int yellowCounter = 0;
    int redCounter =0;
    int draw4Counter = 0;
    int wildCounter = 0;
    int totalCardCounter = 0;
    System.out.println("\nTesting to validate even number of each card for deck validity:");
    for(String card: testingDeck) {
      if(card.toLowerCase().contains("red")) {redCounter = redCounter + 1;}
      if(card.toLowerCase().contains("blue")) {blueCounter = blueCounter + 1;}
      if(card.toLowerCase().contains("yellow")) {yellowCounter = yellowCounter + 1;}
      if(card.toLowerCase().contains("green")) {greenCounter = greenCounter + 1;}
      if(card.toLowerCase().contains("draw4")) {draw4Counter = draw4Counter + 1;}
      if(card.toLowerCase().contains("wild")) {wildCounter = wildCounter + 1;}

    }

    totalCardCounter = redCounter + blueCounter + yellowCounter + greenCounter + draw4Counter + wildCounter;
    System.out.println("Total Cards: " + totalCardCounter + "\n"
                        + "Red Cards: " + redCounter + "\n"
                        + "Blue Cards: " + blueCounter + "\n"
                        + "Yellow Cards: " + yellowCounter + "\n"
                        + "Green Cards: " + greenCounter + "\n"
                        + "Draw4 Cards: " + draw4Counter + "\n"
                        + "Wild Cards: " + wildCounter);
    if(redCounter == yellowCounter && yellowCounter == greenCounter && greenCounter == blueCounter && draw4Counter == wildCounter) {
      System.out.println("\nThe Deck is Valid.\n");
    }
    return testingDeck;
  }
  public static String[] getDeck() {
    String[] finalDeck = Deck.currentDeck.clone();
    return finalDeck;
  }
  public static void printDeck() {
    String[] finalDeck = Deck.currentDeck.clone();
    System.out.println("\nPrinting Deck:");
    for(String card: finalDeck) {
      System.out.println(card);
    }
    System.out.println("\n");
  }
  public static void main(String[] args) {
    Deck testDeck = new Deck(2, "together", "dontRemove");
    String[] finalDeck = new String[108];
    if(numberOfDecks == 1){
      if(removeActionCards == "remove") {
        finalDeck = Deck.createWithoutActionCards();
        finalDeck = shuffle(finalDeck);
      }
      else if(removeActionCards == "dontRemove") {
        finalDeck = Deck.createWithActionCards();
        finalDeck = shuffle(finalDeck);
      }
    }
    else if(numberOfDecks == 2){
      if(removeActionCards == "remove") {
        finalDeck = new String[168];
        String[] firstDeck = new String[84];
        String[] secondDeck = new String[84];
        firstDeck = Deck.createWithoutActionCards();
        secondDeck = Deck.createWithoutActionCards();
        if(shuffleTogetherOrSeperately.toLowerCase() == "together") {
          finalDeck = combineTwo(firstDeck, secondDeck);
          finalDeck = shuffle(finalDeck);
        }
        else if(shuffleTogetherOrSeperately.toLowerCase() == "seperately") {
          finalDeck = shuffle(firstDeck);
          finalDeck = shuffle(secondDeck);
          finalDeck = combineTwo(firstDeck, secondDeck);

        }
      }
      else if(removeActionCards == "dontRemove"){
        finalDeck = new String[214];
        String[] firstDeck = new String[108];
        String[] secondDeck = new String[108];
        firstDeck = Deck.createWithActionCards();
        secondDeck = Deck.createWithActionCards();
        if(shuffleTogetherOrSeperately.toLowerCase() == "together") {
          finalDeck = combineTwo(firstDeck, secondDeck);
          finalDeck = shuffle(finalDeck);
        }
        else if(shuffleTogetherOrSeperately.toLowerCase() == "seperately") {
          firstDeck = shuffle(firstDeck);
          secondDeck = shuffle(secondDeck);
          finalDeck = combineTwo(firstDeck, secondDeck);
        }
      }
    }
    else if(numberOfDecks == 3){
      if(removeActionCards == "remove") {
        finalDeck = new String[252];
        String[] firstDeck = new String[84];
        String[] secondDeck = new String[84];
        String[] thirdDeck = new String[84];
        firstDeck = Deck.createWithoutActionCards();
        secondDeck = Deck.createWithoutActionCards();
        thirdDeck = Deck.createWithoutActionCards();
        if(shuffleTogetherOrSeperately.toLowerCase() == "together") {
          finalDeck = shuffle(combineThree(firstDeck, secondDeck, thirdDeck));
        }
        else if(shuffleTogetherOrSeperately.toLowerCase() == "seperately") {
          firstDeck = shuffle(firstDeck);
          secondDeck = shuffle(secondDeck);
          thirdDeck = shuffle(thirdDeck);
          finalDeck = combineThree(firstDeck, secondDeck, thirdDeck);
        }

      }
      else if(removeActionCards == "dontRemove") {
        finalDeck = new String[324];
        String[] firstDeck = new String[108];
        String[] secondDeck = new String[108];
        String[] thirdDeck = new String[108];
        firstDeck = Deck.createWithActionCards();
        secondDeck = Deck.createWithActionCards();
        thirdDeck = Deck.createWithActionCards();
        if(shuffleTogetherOrSeperately.toLowerCase() == "together") {
          finalDeck = shuffle(combineThree(firstDeck, secondDeck, thirdDeck));
        }
        else if(shuffleTogetherOrSeperately.toLowerCase() == "seperately") {
          firstDeck = shuffle(firstDeck);
          secondDeck = shuffle(secondDeck);
          thirdDeck = shuffle(thirdDeck);
          finalDeck = combineThree(firstDeck, secondDeck, thirdDeck);
        }
      }
    }

    Deck.currentDeck = finalDeck.clone();
    testDeck.getDeck();
    testDeck.testValidDeck();
    testDeck.printDeck();


  }
}
