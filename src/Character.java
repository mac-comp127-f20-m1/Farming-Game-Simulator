import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.GraphicsGroup;


public class Character {
    // private final GraphicsGroup graphics;
    // private double speed;
    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    // buildGraphics();
    
    
    public Character(){
        Image pig = new Image(0, 0, "pig.png");
        pig.setMaxHeight(50);
        pig.setMaxWidth(50);
        graphics.add(pig);
    }
    

   
}
