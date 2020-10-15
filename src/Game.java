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
        canvas=new CanvasWindow("JRL Farm", 880, 1000);
        
        // Image grass = new Image(0, 0, "grass.png");
        // grass.set(1000);
        // grass.setWidth(880);
        // graphics.add(grass);
        // canvas.add(graphics);

        character=new Character();
        environment=new Environment();
        currency = new Currency();

        

        environment.addToCanvas(canvas);
        character.addToCanvas(canvas);
        currency.createButton(canvas);
        timeButton();
        canvas.add(button);
        canvas.add(label);
       
        canvas.onKeyDown(event -> moveCharacter(event));
        

    }



    public static void main(String[] args) {
        new Game();
    }

    public void timeButton(){
        button = new Rectangle(0, 0, 80, 30);
        button.setCenter(815, 120);
        button.setFillColor(Color.RED);
        label.setText("Next Day");       
        label.setFont(FontStyle.BOLD,10);
        label.setFillColor(Color.WHITE);
        label.setCenter(815,120);

    }

    public void moveCharacter(KeyboardEvent event){
        if(event.getKey() == Key.UP_ARROW){
            character.moveY(-10);
        }   
        if(event.getKey() == Key.DOWN_ARROW){
            character.moveY(10);
        } 
        if(event.getKey() == Key.RIGHT_ARROW){
            character.moveX(10);
        } 
        if(event.getKey() == Key.LEFT_ARROW){
            character.moveX(-10);
        }
    }
}
