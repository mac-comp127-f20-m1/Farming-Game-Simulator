import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.GraphicsGroup;



public class Character {
    // private final GraphicsGroup graphics;
    // private double speed;
    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private Image pig;
    List<Plant> plants=new ArrayList<>();
    private int money = 100;
  
    public List<Plant> getList() {
        return plants;
    }
    public Character(){
        pig = new Image(0, 0, "pig.png");
        pig.setMaxHeight(100);
        pig.setMaxWidth(80);
        graphics.add(pig);
        
    }

    public int getMoney(){
        return money;
    }

    public void harvest(CanvasWindow canvas, Plant plant){
        plant.removeFromCanvas(canvas);
        money+=  plant.getPrice()*2;
        plants.remove(plant);   
    }

  
    public Plant getPlantAtPosition(Point point){
        for (Plant plant : plants) {
            if (plant.getImage().isInBounds(point)){
                return plant;
            }
        }
        return null;
    }


    /**
     * Creates a new apple object and adds it to the canvas
     * at a certain position
     *  
     * @param canvas
     */
    public void plantApple(CanvasWindow canvas,double x, double y){ 
        Plant apple = new Plant("apple.png", 10);
        apple.setPosition(x, y);
        plants.add(apple);
        apple.addToCanvas(canvas);
        money=money-apple.getPrice();   
          
    }

    /**
     * Creates a new orange object
     */
    public void plantOrange(CanvasWindow canvas,double x, double y){
        Plant orange = new Plant("orange.png", 15);
        orange.setPosition(x, y);
        plants.add(orange);
        orange.addToCanvas(canvas);
        money=money-orange.getPrice();    
    }

    /**
     * Creates a new potato object
     */
    public void plantPotato(CanvasWindow canvas,double x, double y){
        Plant potato = new Plant("potato.png", 5);
        potato.setPosition(x, y);
        plants.add(potato);
        potato.addToCanvas(canvas);
        money=money-potato.getPrice();   
    
    }

    /**
     * Creates a new cabbage object
     */
    public void plantCabbage(CanvasWindow canvas,double x, double y){
        Plant cabbage = new Plant("cabbage.png", 20);
        cabbage.setPosition(x, y);
        plants.add(cabbage);
        cabbage.addToCanvas(canvas);
        money=money-cabbage.getPrice();   
    }

    // -----------------------

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(this.pig);
    }

    public void removeFromCanvas(CanvasWindow canvas){
        canvas.remove(this.pig);
    }

    //------------------------

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
    
    public Point getPosition() {
        return pig.getPosition();
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
