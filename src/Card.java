// Creates card class
// @author Dylan Lowman and Jacob Hewgley
public class Card {
        public enum CardColor {
            BLUE("pushups"),YELLOW("squats"),GREEN("lunges"),RED("situps");

            CardColor(String workout) {
                this.workout = workout;
            }

            private final String workout;
            public final String getWorkout(){
                return workout;
            }
           }
        public enum CardValue {
            ZERO("0"),ONE("1"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NINE("9");
            //constructor for the action
            CardValue(String description){
                this.description = description;
            }
            private final String description;
            //accessor to access card value/action
            public final String getDescription() {
                return description;
            }
        }
        public enum SpecialCards {
          REVERSE("BACKINDECK"),SKIP("DONTDOCOLOR"),DRAW2("x2");

          SpecialCards(String description) {
            this.description = description;
          }

          private final String description;
          public final String getDescription() {
            return description;
          }
        }
        public enum WildCards {
          DRAW4("x4"), WILD("Burpees");

          WildCards(String description){
            this.description = description;
          }

          private final String description;
          public final String getDescription() {
            return description;
          }
        }
        public static void main(String[] args){}
}
