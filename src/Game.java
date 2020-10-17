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
    private Currency currency;
    private Rectangle button;
    private GraphicsText label = new GraphicsText();

    private int days;
    GraphicsGroup graphics = new GraphicsGroup(0, 0);
  

    public Game(){
        canvas=new CanvasWindow("JRL Farm", 880, 930);
        
        Image grass = new Image(0, 0, "grass.png");

        graphics.add(grass);
        canvas.add(graphics);

        character=new Character();
        environment=new Environment();
        currency = new Currency();

        environment.addToCanvas(canvas);
        character.addToCanvas(canvas);
        character.setCenter(250, 250);
        currency.createButton(canvas);
        timeButton();

        canvas.add(button);
        canvas.add(label);
       
        canvas.onKeyDown(event -> {
            moveCharacter(event);
            plant(event);
        });
    }

    public static void main(String[] args) {
        new Game();
    }

    public void timeButton(){
        button = new Rectangle(0, 0, 80, 30);
        button.setCenter(815, 120);
        button.setFillColor(Color.RED);
        label.setText("Next Day");       
        label.setFont(FontStyle.BOLD, 15);
        label.setFillColor(Color.WHITE);
        label.setCenter(815,120);

    }

    public void plant(KeyboardEvent event){
        double x = character.getX();
        double y = character.getY();
        if(event.getKey() == Key.Q&&canvas.getElementAt(x, y) instanceof LandPlot){
            character.plantApple(canvas, x, y);
            System.out.println("is this working");
        }
        if(event.getKey() == Key.W && canvas.getElementAt(x, y) instanceof LandPlot){
            character.plantOrange(canvas, x, y);
            System.out.println("is this working");
        }
        if(event.getKey() == Key.E && canvas.getElementAt(x, y) instanceof LandPlot){
            character.plantPotato(canvas, x, y);
            System.out.println("is this working");
        }
        if(event.getKey() == Key.R && canvas.getElementAt(x, y) instanceof LandPlot){
            character.plantCabbage(canvas, x, y);
            System.out.println("is this working");
        }
    }

    public void moveCharacter(KeyboardEvent event){
        if(event.getKey() == Key.UP_ARROW){
            character.moveY(-20);
        }   
        if(event.getKey() == Key.DOWN_ARROW){
            character.moveY(20);
        } 
        if(event.getKey() == Key.RIGHT_ARROW){
            character.moveX(20);
        } 
        if(event.getKey() == Key.LEFT_ARROW){
            character.moveX(-20);
        }
        character.canvasBounds(canvas);
    }
}
