import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import java.awt.Color;
import java.util.Scanner;

import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;

/**
 * 
 * This class creates and runs the game!
 * JRL Farming Simulator.
 * Created by: Jaylynn Rodriguez, Russell Ni, and Lien Lian
 * 
 */
public class Game {
    private CanvasWindow canvas;
    private Character character;
    private Environment environment;
    private Rectangle timeButton;
    private Button button; // clickable skip day button
    private Scanner scanner;
    private Rectangle moneyButton;
    private GraphicsText timeLabel = new GraphicsText();
    private GraphicsText moneyLabel = new GraphicsText();
    private int lockCounter = 0; //keeps track of how many landplots have been unlocked
    private LandPlot landplot;

    private int days = 1;
    private GraphicsGroup graphics = new GraphicsGroup(0, 0);

    private boolean appleLock = true;
    private boolean orangeLock = true;
    private boolean cabbageLock = true;

    public Game() {
        canvas = new CanvasWindow("JRL Farm", 880, 930);

        Image grass = new Image(0, 0, "grass.png");

        graphics.add(grass);
        canvas.add(graphics);

        character = new Character();
        environment = new Environment();

        environment.addToCanvas(canvas);
        character.addToCanvas(canvas);
        character.setCenter(250, 250);
        moneyButton(canvas);
        timeButton();
        Button();
        canvas.add(timeButton);
        canvas.add(timeLabel);

        canvas.onKeyDown(event -> {
            moveCharacter(event);
            plant(event);
            harvestByKey(event);
        });
    }

    public static void main(String[] args) {
        System.out.println("Hello, welcome to our simple farming game.");
        System.out.println("You can move the pig by pressing arrows. ");
        System.out.println("Different keys plant different crops.\nQ: Potatoes\nW: Apples\nE: Oranges\nR: Cabbages");
        System.out.println("If you gained enough money, you can choose to unlock 1 of 3 plants every 5 days.");
        System.out.println("If you gained enough money, you can choose to unlock 1 of the lands every 10 days.");
        System.out.println("You can press the 'skip day' to skip day and make the plants grow faster.");
        System.out.println("You can press the space bar to harvest the plants and gain money.");
        System.out.println("However, you can only plant 9 items in one land. ");
        System.out.println("Enjoy this game!😂");
        new Game();
    }

    /** This creates a rectangle which informs the user of what day it is.
    */
    public void timeButton() {
        timeButton = new Rectangle(0, 0, 95, 40);
        timeButton.setCenter(815, 150);
        timeButton.setFillColor(Color.RED);
        timeLabel.setText("Day: " + days);
        timeLabel.setFont(FontStyle.BOLD, 15);
        timeLabel.setFillColor(Color.WHITE);
        timeLabel.setCenter(815, 150);
    }

    /**
     * This creates a clickable button called 'Skip Day' which allows users to move on to the next day in the game.
     * 
     */
    public void Button() {
        button = new Button("Skip Day");
        button.setCenter(815, 200);
        canvas.add(button);
        button.onClick(() -> skipDayMechanism());
    }

    /**This method grows plants and asks several different questions depending on what day it is in the game. */
    public void skipDayMechanism() {
        for (Plant plant : character.getList()) {
            if (!plant.maxSize()) {
                plant.growLarger();
            }
        }
        askAboutLand();
        askAboutPlant();
        days++;
        changeDay();
    }

    /**
     * This method asks the player if they'd like to unlock a new piece of land.
     * The question only pops up if they have the money to buy land,
     * and it will stop popping up entirely when there is no more land to unlock (check lockCounter)
     * */
    public void askAboutLand() {
        if (days % 10 == 0) {
            scanner = new Scanner(System.in);

            if (character.getMoney() >= 100 && lockCounter <= 6) {
                System.out.println("Do you wanna unlock land(Yes/No)");
                String unlockResponse = scanner.nextLine();
                if (unlockResponse.equalsIgnoreCase("Yes")) {
                    environment.getLands().get(lockCounter + 3).unlock();
                    lockCounter++;
                    character.subtractMoney(100);
                    changeMoney();
                } else if (unlockResponse.equalsIgnoreCase("No")) {
                    return;

                }
            }
        }
    }

    /**
     * This method asks the user if they'd like to unlock new plants.
     * The question occurs every five days.
     */
    public void askAboutPlant() {
        if(!appleLock && !orangeLock && !cabbageLock){
            return;
        }
        else if(days % 5 == 0) {
            scanner = new Scanner(System.in);
            System.out.println(
                "Do you wanna unlock new seeds? \nApple = 50 coins (Enter A to unlock) \nOrange = 70 coins (Enter O to unlock)\nCabbage = 90 coins (Enter C to unlock)");
            System.out.println("To skip, enter S");
                String unlockResponse = scanner.nextLine();
            if (unlockResponse.equalsIgnoreCase("A") && appleLock) {
                if (character.getMoney() >= 50){
                    appleLock = false;
                    character.subtractMoney(50);
                    changeMoney();
                }
                if (character.getMoney()<50){
                    System.out.println("You're broke.");
                }
            }
            if (unlockResponse.equalsIgnoreCase("O") && orangeLock) {
                if (character.getMoney() >= 70){
                    orangeLock = false;
                    character.subtractMoney(70);
                    changeMoney();
                }
                if (character.getMoney()<70){
                    System.out.println("You're broke.");
                }
            }
            if (unlockResponse.equalsIgnoreCase("C") && cabbageLock) {
                if (character.getMoney() >= 90){
                    cabbageLock = false;
                    character.subtractMoney(90);
                    changeMoney();
                }
                if (character.getMoney()<90){
                    System.out.println("You're broke.");
                }
            }

            if (unlockResponse.equalsIgnoreCase("S")){
                return;
            }
        }
    }

    /**This method updates the graphical text to the current day in-game */
    public void changeDay() {
        timeLabel.setText("Day: " + days);
        timeLabel.setCenter(timeLabel.getCenter());
    }

    /**This method creates a rectangle with graphical text that informs the user of how much money they have. */
    public void moneyButton(CanvasWindow canvas) {
        moneyButton = new Rectangle(0, 0, 95, 40);
        moneyButton.setCenter(815, 80);
        moneyButton.setFillColor(new Color(156, 195, 230));
        changeMoney();
        moneyLabel.setFont(FontStyle.BOLD, 15);
        moneyLabel.setFillColor(Color.WHITE);

        canvas.add(moneyButton);
        canvas.add(moneyLabel);
    }

    /**This method updates the graphical text to the current amount of money the character has after buying/selling. */
    public void changeMoney() {
        moneyLabel.setText("Coins: " + character.getMoney());
        moneyLabel.setCenter(moneyButton.getCenter());
    }

    /**This method makes sure that the character is on top of all the objects on screen. */
    public void makeCharacterOnTop() {
        character.removeFromCanvas(canvas);
        character.addToCanvas(canvas);
    }

    /**This method allows a player to harvest plants by pressing the space bar*/
    public void harvestByKey(KeyboardEvent event) {
        Plant plant = character.getPlantAtPosition(character.getPosition());
        if (plant == null) {
            return;
        }
        if (event.getKey() == Key.SPACE && plant.maxSize()) {
            character.harvest(canvas, plant);
            landplot.minusOne();
            makeCharacterOnTop();
            changeMoney();
        }
    }

    /**
     * This method allows the user to plant crops by pressing different keys. A crop can only be planted
     * if it is unlocked. if they have not reached the maximum number of plants for a landplot, and if
     * they can afford it.
     * @param event
    */
    public void plant(KeyboardEvent event) {
        double x = character.getX();
        double y = character.getY();
        landplot = environment.getLandPlotAtPosition(character.getPosition());
    

        if (landplot == null) {
            return;
        }

        if (event.getKey() == Key.W 
            && character.getMoney() >= 10
            && !landplot.isLocked() 
            && !appleLock&&landplot.getCnt()<landplot.getMaximumPlants()) {  
                         
            character.plantApple(canvas, x, y);
            makeCharacterOnTop();
            changeMoney();
            landplot.plusOne();
        }
        if (event.getKey() == Key.E
            && character.getMoney() >= 15 
            && !landplot.isLocked() 
            && !orangeLock&&landplot.getCnt()<landplot.getMaximumPlants()) {
                
            character.plantOrange(canvas, x, y);
            makeCharacterOnTop();
            changeMoney();
            landplot.plusOne();
        }
        if (event.getKey() == Key.Q
            && character.getMoney() >= 5
            && !landplot.isLocked()
            &&landplot.getCnt()<landplot.getMaximumPlants()) {
                
            character.plantPotato(canvas, x, y);
            makeCharacterOnTop();
            changeMoney();
            landplot.plusOne();
        }
        if (event.getKey() == Key.R 
            && character.getMoney() >= 20 
            && !landplot.isLocked() 
            && !cabbageLock&&landplot.getCnt()<landplot.getMaximumPlants()) {
                
            character.plantCabbage(canvas, x, y);
            makeCharacterOnTop();
            changeMoney();
            landplot.plusOne();
        }
    }

    /**This method moves the character around on the screen according to the arrow keys.
     * 
     * @param event
     * 
    */
    public void moveCharacter(KeyboardEvent event) {
        if (event.getKey() == Key.UP_ARROW) {
            character.moveY(-20);
        }
        if (event.getKey() == Key.DOWN_ARROW) {
            character.moveY(20);
        }
        if (event.getKey() == Key.RIGHT_ARROW) {
            character.moveX(20);
        }
        if (event.getKey() == Key.LEFT_ARROW) {
            character.moveX(-20);
        }
        character.canvasBounds(canvas);
    }
}
