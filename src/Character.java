import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.GraphicsGroup;


public class Character {
    // private final GraphicsGroup graphics;
    // private double speed;
    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    // buildGraphics();
    private Image pig;
    
    
   
        
    
    public Character(){
        pig = new Image(0, 0, "pig.png");
        pig.setMaxHeight(100);
        pig.setMaxWidth(80);
        graphics.add(pig);
        
    }

    // public void movePaddle(Point point) {
    //     this.setCenter(point.withY(600));
    //     double newx = getX();
    //     if (newx > 0 && newx + this.paddleWidth < maxX) {
    //         this.setPosition(newx, getY());
    //     }
    //     if (newx <= 0) {
    //         this.setPosition(0, getY());
    //     }
    //     if (newx + this.paddleWidth >= maxX) {
    //         this.setPosition(maxX - this.paddleWidth, getY());
    //     }
    // }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(this.pig);
    }

    public void moveX(double dx){
        pig.setX(pig.getX()+dx);
    }

    public void moveY(double dy){
        pig.setY(pig.getY()+dy);
    }


    public double getX(){
        return pig.getX();
    }

    public double getY(){
        return pig.getY();
    }
    

   
}
