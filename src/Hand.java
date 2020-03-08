//Author: Dylan
public class Hand {
    static String testDeck[] = {"green,seven,lunges","draw4,x4","green,skip,dontdocolor","wild,burpees", "red,draw2,x2", "red,skip,dontdocolor","blue,seven,pushups","yellow,six,squats","blue,eight,pushups", "blue, reverse, returntodeck"};
    static int size = (testDeck.length / 7) + 1;
    static int situpReps = 0, pushupReps = 0, lungesReps = 0, burpeeReps = 0, squatReps = 0, totalReps = 0;
    static int number;
    static int handNumber = 0,drawCounter = 0;
    static String handData = "\n", cardData, color, action;
    static String stats[] = new String[size];

    public static void main(String[] args) {
        for(String s: testDeck) {
          System.out.println(s);
        }
        for(int i = 0; i < testDeck.length; i++) {
            cardData = testDeck[i];
            //Checks to see if the card is a color card or not. If it is, get the color.
            if (cardData.contains("blue") || cardData.contains("red") ||cardData.contains("green") || cardData.contains("yellow")) {
              if (cardData.contains("skip")) {
                color = getColor(cardData);
                handData += (color + " skip" + "\n");
                // action = doSkipAction("skipping this color for this hand");
              }
              else if (cardData.contains("x2")) {
                color = getColor(cardData);
                handData += color + " x2" + "\n";
                // action = dox2Action("skipping this color for this hand");
              }
              else if (cardData.contains("reverse")) {
                color = getColor(cardData);
                handData += color + " discard" + "\n";
                // action = doReverseAction("skipping this color for this hand");
              }
              else {
                color = getColor(cardData);
                action = getAction(cardData, color);
                handData += color + " " + action + "\n";
              }
            }
            else {
              color = getColor(cardData);
              action = getAction(cardData, color);
              handData += color + "\n";
            }
            drawCounter++;
            if((drawCounter % 7 == 0) && (drawCounter != 0)) {
                stats[handNumber] = handData;
                if(handData.contains("skip")) {
                  //doAllSkips(handData);
                  System.out.println("Implement doAllSkips");
                }
                if(handData.contains("x2")) {
                  //doAllx2(handData);
                  System.out.println("Implement doAllx2");
                }
                if(handData.contains("reverse")) {
                  //doAllReverse(handData);
                  System.out.println("Implement doAllReverse");
                }
                stats[handNumber] += "Situps for this hand: " + situpReps + "\n";
                stats[handNumber] += "Pushups for this hand: " + pushupReps + "\n";
                stats[handNumber] += "Squats for this hand: " + squatReps + "\n";
                stats[handNumber] += "Lunges for this hand: " + lungesReps + "\n";
                stats[handNumber] += "Burpees for this hand: " + burpeeReps + "\n";
                situpReps = 0;
                pushupReps = 0;
                lungesReps = 0;
                burpeeReps = 0;
                squatReps = 0;
                handData = "";
                handNumber++;
            }
            else if(testDeck.length == drawCounter) {
              stats[handNumber] = handData + '\n';
              stats[handNumber] = "\n" + handData;
              stats[handNumber] += "Situps for this hand: " + situpReps + "\n";
              stats[handNumber] += "Pushups for this hand: " + pushupReps + "\n";
              stats[handNumber] += "Squats for this hand: " + squatReps + "\n";
              stats[handNumber] += "Lunges for this hand: " + lungesReps + "\n";
              stats[handNumber] += "Burpees for this hand: " + burpeeReps + "\n";
              situpReps = 0;
              pushupReps = 0;
              lungesReps = 0;
              burpeeReps = 0;
              squatReps = 0;
              handNumber += 1;
            }
        }
        System.out.println("\n");
        System.out.println("hands drawn: " + handNumber);
        for(String s:stats)
        {
           System.out.println(s);
        }
    }
    public static String getColor(String handData) {
            char ch[] = {};
            int stringCount = 1;
            String temp = "";
            String color = "";
            ch = handData.toCharArray();
            for(char c: ch)
            {
                if(c != ',' && c != '\n')
                {
                    temp += c;
                }
                else
                {
                    if(stringCount == 1)
                        color = temp;
                    stringCount++;
                }
            }
            return color;
    }
    public static String getSpecialColor(String handData) {
            char ch[] = {};
            int stringCount = 1;
            String temp = "";
            String color = "";
            ch = handData.toCharArray();
            for(char c: ch)
            {
                if(c != ',' && c != '\n')
                {
                    temp += c;
                }
                else
                {
                    if(stringCount == 0)
                        color = temp;
                    stringCount++;
                }
            }
            return color;
    }
    public static String getAction(String cardData, String color) {
            String action = "";

            if (cardData.contains("wild") || cardData.contains("draw4")) {
              if(cardData.contains("wild")) {
                action = "10 burpees";
                burpeeReps += 10;
              }
              else {
                action = "10 burpees, x4";
                burpeeReps += 10;
              }
            }
            else {
              action = getNumber(cardData, color);
            }
            return action;
    }
    public static String getNumber(String cardData, String color) {
        String actionNumber = "";
        String colorbyWorkout = "";
        int currentExcersize = 0;
        switch(color) {
          case "blue":
            colorbyWorkout = "pushups";
            break;
          case "green":
            colorbyWorkout = "lunges";
            break;
          case "yellow":
            colorbyWorkout = "squat";
            break;
          case "red":
            colorbyWorkout = "sit ups";
            break;
        }
          if(cardData.contains("zero")) {
            actionNumber = "0: " + colorbyWorkout;
            currentExcersize += 0;
          }
          else if(cardData.contains("one")) {
            actionNumber = "1: " + colorbyWorkout;
            currentExcersize += 1;
          }
          else if(cardData.contains("two")) {
            actionNumber = "2: " + colorbyWorkout;
            currentExcersize += 2;
          }
          else if(cardData.contains("three")) {
            actionNumber = "3: " + colorbyWorkout;
            currentExcersize += 3;
          }
          else if(cardData.contains("four")) {
            actionNumber = "4: " + colorbyWorkout;
            currentExcersize += 4;
          }
          else if(cardData.contains("five")) {
            actionNumber = "5: " + colorbyWorkout;
            currentExcersize += 5;
          }
          else if(cardData.contains("six")) {
            actionNumber = "6: " + colorbyWorkout;
            currentExcersize += 6;
          }
          else if(cardData.contains("seven")) {
            actionNumber = "7: " + colorbyWorkout;
            currentExcersize += 7;
          }
          else if(cardData.contains("eight")) {
            actionNumber = "8: " + colorbyWorkout;
            currentExcersize += 8;
          }
          else if(cardData.contains("nine")) {
            actionNumber = "9: " + colorbyWorkout;
            currentExcersize += 9;
          }
          switch(color) {
            case "blue":
              pushupReps += currentExcersize;
              break;
            case "green":
              lungesReps += currentExcersize;
              break;
            case "yellow":
              squatReps += currentExcersize;
              break;
            case "red":
              situpReps += currentExcersize;
              break;
          }
          return actionNumber;
    }
    public static void doAllSkips(String handData) {
      //handData will contain one string that has EVERY card in it (7 cards)
      //make an if else for each case and then apply the skip to the whole hand based on the if else statements.
    }
    public static void doAllx2(String handData) {
      //handData will contain one string that has EVERY card in it (7 cards)
      //make an if else for each case that applies the x2 function to each rep counter
    }
    public static void doAllReverse(String handData) {
      //handData will contain one string that has EVERY card in it (7 cards)
      //Make an if else that handled each reverse case, and also returns the cards to the bottom of the deck.
    }
}
