import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.GraphicsGroup;


public class Character {
    // private final GraphicsGroup graphics;
    // private double speed;
    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private Image pig;
    List<Plant> plants=new ArrayList<>();
    
    public Character(){
        pig = new Image(0, 0, "pig.png");
        pig.setMaxHeight(100);
        pig.setMaxWidth(80);
        graphics.add(pig);
        
    }

    /**
     * Creates a new apple object and adds it to the canvas
     * at a certain position
     *  
     * @param canvas
     */
    public void plantApple(CanvasWindow canvas,double x, double y){ 
        Apple apple = new Apple();
        apple.setPostion(x, y);
        plants.add(apple);
        apple.addToCanvas(canvas);
    }

    /**
     * Creates a new orange object
     */
    public void plantOrange(){
        Orange orange = new Orange();
    }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(this.pig);
    }

    public void moveX(double dx){
        pig.setX(pig.getX()+dx);
    }

    public void moveY(double dy){
        pig.setY(pig.getY()+dy);
    }

    public void setCenter(double x, double y){
        pig.setCenter(x, y);
    }

    public double getX(){
        return pig.getX();
    }

    public double getY(){
        return pig.getY();
    }
    
    //---------------------------

    public void canvasBounds(CanvasWindow canvas){
        double height = canvas.getHeight();
        
        if(pig.getX()+pig.getWidth()>750){
            pig.setX(750-pig.getWidth());
        }
           
        if (pig.getX()<0){
            pig.setX(0);
           
        }
        if (pig.getY()+pig.getHeight()>height){
            pig.setY(height-pig.getHeight());
        }
        if (pig.getY()<0){
            pig.setY(0);
            
        }
    
    }
    

    public void lockLandBounds(CanvasWindow canvas){
        
    }

    public void ButtonsBounds(CanvasWindow canvas){
        
    }

    // public void updatePosition(double dt, CanvasWindow canvas, List<GraphicsObject> brick, Paddle paddle) {
    //     newx = getX() + dt * velocityx;
    //     newy = getY() + dt * velocityy;


    //     if (newx > 0 && newx < maxX && newy > 0 && newy < maxY) {
    //         this.setPosition(newx, newy);
    //     } else {
    //         if (newx <= 0 || newx >= maxX) {
    //             this.velocityx = -velocityx;
    //         }
    //         if (newy <= 0 || newy >= maxY) {
    //             this.velocityy = -velocityy;
    //         }
    //     }
    //     collision(canvas, brick, paddle);

    // }
   
}
