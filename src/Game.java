import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import java.awt.Color;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.GraphicsText;


public class Game {
    private CanvasWindow canvas;
    private Character character;
    private Environment environment;
    private Rectangle timeButton;
    private Rectangle moneyButton;
    private GraphicsText timeLabel = new GraphicsText();
    private GraphicsText moneyLabel = new GraphicsText();

    private int days;
    GraphicsGroup graphics = new GraphicsGroup(0, 0);


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

        canvas.add(timeButton);
        canvas.add(timeLabel);

        canvas.onKeyDown(event -> {
            moveCharacter(event);
            plant(event);
        });
    }

    public static void main(String[] args) {
        new Game();
    }

    public void timeButton() {
        timeButton = new Rectangle(0, 0, 80, 30);
        timeButton.setCenter(815, 120);
        timeButton.setFillColor(Color.RED);
        timeLabel.setText("Next Day");
        timeLabel.setFont(FontStyle.BOLD, 15);
        timeLabel.setFillColor(Color.WHITE);
        timeLabel.setCenter(815, 120);

    }

    // public void skipDay(){
    //     canvas.onMouseDown((event) -> {

    //         if (event.getPosition().getX()> &&
    //         event.getPosition().getX()< &&
    //         event.getPosition().getY()> &&
    //         event.getPosition().getY()< );    
    //     });
    // }

    public void moneyButton(CanvasWindow canvas) {
        moneyButton = new Rectangle(0, 0, 80, 30);
        moneyButton.setCenter(815, 80);
        moneyButton.setFillColor(new Color(156, 195, 230));
        moneyLabel.setText("Coins: " + character.getMoney());
        moneyLabel.setFont(FontStyle.BOLD, 15);
        moneyLabel.setFillColor(Color.WHITE);
        moneyLabel.setCenter(815, 80);

        canvas.add(moneyButton);
        canvas.add(moneyLabel);
    }

    public void plant(KeyboardEvent event) {
        double x = character.getX();
        double y = character.getY();

        if (event.getKey() == Key.Q && character.getMoney() >= 10) {
            character.plantApple(canvas, x, y);
            changeMoney();
        }
        if (event.getKey() == Key.W && character.getMoney() >= 15) {
            character.plantOrange(canvas, x, y);
            changeMoney();
        }
        if (event.getKey() == Key.E && character.getMoney() >= 5) {
            character.plantPotato(canvas, x, y);
            changeMoney();
        }
        if (event.getKey() == Key.R && character.getMoney() >= 20) {
            character.plantCabbage(canvas, x, y);
            changeMoney();
        }
    }

    public void changeMoney() {
        moneyLabel.setText("Coins: " + character.getMoney());
        System.out.println("money" + character.getMoney());
    }

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
