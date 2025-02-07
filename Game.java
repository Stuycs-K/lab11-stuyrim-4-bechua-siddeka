import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    Text.go(1, 1);
    for (int i = 0; i < WIDTH; i++) {
        System.out.print("-");
    }

    for (int i = 2; i < HEIGHT; i++) {
        Text.go(i, 1);
        System.out.print("|");
        for (int j = 2; j < WIDTH; j++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }

    Text.go(HEIGHT, 1);
    for (int i = 0; i < WIDTH; i++) {
        System.out.print("-");
    }
  }
  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.println(s);
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){

    String[] words = text.split(" ");

    int currentRow = row;
    int lineLength = 0;
    String currentLine = "";

    for (String word : words) {
      if (lineLength + word.length() + 1 > width) {
        drawText(currentLine, currentRow, col);

        currentRow++;
        if (currentRow >= row + height) {
          break;
        }

        lineLength = 0;
        currentLine = "";
      }

      if (!currentLine.isEmpty()) {
        currentLine += " ";
        lineLength++;
      }
        currentLine += word;
        lineLength += word.length();
    }

    if (!currentLine.isEmpty() && currentRow < row + height) {
      drawText(currentLine, currentRow, col);
      currentRow++;
    }

    for (int i = currentRow; i < row + height; i++) {
      drawText(" ".repeat(width), i, col);
    }
  }


    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      Random rng = new Random();
      int choice = rng.nextInt(3);

      if (choice == 0) {
        return new CodeWarrior("Warrior"+(int)(Math.random()*100));
      }
      if (choice == 1) {
        return new Healer("Healer"+(int)(Math.random()*100));
      }
      if (choice == 2) {
        return new Mage("Mage"+(int)(Math.random()*100));
      }

      return new Mage("Mage"+(int)(Math.random()*100));
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      final int COLUMN_WIDTH = 20;

      String namesRow = "";
      String hpRow = "";
      String specialRow = "";
      for (Adventurer adventurer : party) {
        String name = adventurer.getName();
        while (name.length() < COLUMN_WIDTH) {
          name += " ";
        }
        namesRow += name;

        String hp = "HP: " + colorByPercent(adventurer.getHP(), adventurer.getmaxHP());
        while (hp.length() < COLUMN_WIDTH) {
          hp += " ";
        }
        hpRow += hp;

        String special = adventurer.getSpecialName() + ": " + adventurer.getSpecial();
        while (special.length() < COLUMN_WIDTH){
            special += " ";
        }
        specialRow += special;
      }
      drawText(namesRow, startRow, 2);
      drawText(hpRow, startRow + 1, 2);
      drawText(specialRow, startRow + 2, 2);
      drawText(" ".repeat(WIDTH - 2), startRow + 3, 2);
     /// add code
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    drawBackground();

    drawParty(party, 6);

    drawParty(enemies, 16);

    drawText("-".repeat(WIDTH - 2), 15, 2);

  }

  public static String userInput(Scanner in){
    Text.go(HEIGHT - 2, 1);
    Text.showCursor();
      //Move cursor to prompt location

      //show cursor

      String input = in.nextLine();

      Text.go(HEIGHT - 2, 1);
      Text.clear();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Random rng = new Random();
    int numOfEnemies = rng.nextInt(3) + 1;

    if (numOfEnemies == 1) {
      Boss boss = new Boss("Boss"+(int)(Math.random()*100));
      enemies.add(boss);
    } else {
      for (int x = 0; x < numOfEnemies; x++) {
        enemies.add(createRandomAdventurer());
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Random rng2 = new Random();
    int partySize = rng2.nextInt(3) + 2;

    for (int x = 0; x < partySize; x++) {
      party.add(createRandomAdventurer());
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.


    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      if (whichPlayer >= party.size()) {
        whichPlayer = 0;
      }

      String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit [index]";
      drawText(preprompt, HEIGHT, 2);
      //Read user input
      input = userInput(in);

      /*
      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );
      */

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if (input.startsWith("attack ") || input.startsWith("a ")) {
          Adventurer attacker = party.get(whichPlayer);
          int targetIndex = Integer.parseInt(input.split(" ")[1]);
          if (targetIndex < 0 || targetIndex >= enemies.size()) {
            TextBox(HEIGHT - 3, 3, WIDTH - 6, 1, "Invalid target index.");
            continue;
          }
          Adventurer target = enemies.get(targetIndex);

          String attackMessage = attacker.attack(target);
          TextBox(HEIGHT - 3, 3, WIDTH - 6, 1, attackMessage);

          if (target.getHP() <= 0) {
            TextBox(25, 2, WIDTH - 2, 1, target.getName() + " has been defeated!");
            enemies.remove(targetIndex);
          }
        } else if (input.equals("special") || input.equals("sp")) {
          Adventurer attacker = party.get(whichPlayer);
          int targetIndex = Integer.parseInt(input.split(" ")[1]);
          if (targetIndex < 0 || targetIndex >= enemies.size()) {
            TextBox(HEIGHT - 3, 3, WIDTH - 6, 1, "Invalid target index.");
            continue;
          }
          Adventurer target = enemies.get(targetIndex);

          String specialMessage = attacker.specialAttack(target);
          TextBox(24, 2, WIDTH - 2, 1, specialMessage);

          if (target.getHP() <= 0) {
            TextBox(25, 2, WIDTH - 2, 1, target.getName() + " has been defeated!");
            enemies.remove(targetIndex);
          }
        } else if (input.startsWith("su ") || input.startsWith("support ")) {
          Adventurer supporter = party.get(whichPlayer);
          int targetIndex = Integer.parseInt(input.split(" ")[1]);
          if (targetIndex < 0 || targetIndex >= party.size()) {
            TextBox(HEIGHT - 3, 3, WIDTH - 6, 1, "Invalid target index.");
            continue;
          }
          Adventurer target = party.get(targetIndex);

          String supportMessage = supporter.support(target);
          TextBox(24, 2, WIDTH - 2, 1, supportMessage);
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit [index]";
          drawText(prompt, HEIGHT - 1, 2);

        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:

          partyTurn = false;
          whichOpponent = 0;
          drawText("Press enter to see monster's turn", HEIGHT - 1, 2);

        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        Random rand = new Random();
        int enemyIndex = rand.nextInt(enemies.size());
        int partyIndex = rand.nextInt(party.size());

        int action = rand.nextInt(3);

        if (action == 0) {
          enemies.get(enemyIndex).attack(party.get(partyIndex));
        } else if (action == 1) {
          if (enemies.size() == 1) {
            enemies.get(enemyIndex).support();
          } else {
            enemies.get(enemyIndex).support(enemies.get(rand.nextInt(enemies.size())));
          }
        } else if (action == 2){
          enemies.get(enemyIndex).specialAttack(party.get(partyIndex));
        }

        whichOpponent++;
      }

      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit [index]";
        drawText(prompt, HEIGHT - 1, 2);
      }

      if (party.isEmpty()) {
        drawText("Game Over! All adventurers have been defeated.", HEIGHT - 2, 2);
        break;
      }
      if (enemies.isEmpty()) {
        drawText("Victory! All enemies have been defeated.", HEIGHT - 2, 2);
        break;
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);

    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
