
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;


public class Environment {
    private double landPlot=250;
    private int Row = 3, brickColumn = 3;
    private List<GraphicsObject> lands = new ArrayList<GraphicsObject>();

    public Environment() {
        for (int j = 0; j < Row; j++) {

            for (int i = 0; i < Row; i++) {
               Rectangle rec = new Rectangle(i,j, landPlot,
                landPlot);
                rec.setPosition(i*landPlot+70*i+5,j*landPlot+70*j);
                rec.setFillColor(new Color(139,69,19));
                lands.add(rec);
            }
        }
    }

    // // public void createBrickWall(){

    //     for (int y=100;y<=350;y+=25){
    //         double x=5;
    //         for (int j=0;j<10;j++){
    //             Brick brick= new Brick(x, y, 50, 20);
    //             brick.addToCanvas(window);
                
    //             // bricks.add(brick);
    //             x+=60;
    //         }
    //     } 

   

    public List<GraphicsObject> getLands() {
        return lands;
    }

    
    public void addToCanvas(CanvasWindow canvas) {
        for (GraphicsObject b : lands) {
            canvas.add(b);
        }
    }

    public void setColor(Rectangle rec){

    }

    
}

