import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;

public class Game {
    private CanvasWindow canvas;
    private Character character;
    private Environment environment;

    public Game(){
        canvas=new CanvasWindow("JRL Farm", 900, 1000);
        character=new Character();
        environment=new Environment();

        environment.addToCanvas(canvas);
        character.addToCanvas(canvas);
        canvas.onKeyDown(event -> moveCharacter(event));
        

    }

    public static void main(String[] args) {
        new Game();
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
