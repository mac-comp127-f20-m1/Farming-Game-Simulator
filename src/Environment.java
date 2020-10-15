
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;


public class Environment {
    private double landPlot=200;
    private int Row = 3, brickColumn = 3, buffer=5;
    private List<Rectangle> lands = new ArrayList<Rectangle>();

    public Environment() {
        for (int j = 0; j < Row; j++) {

            for (int i = 0; i < Row; i++) {
               Rectangle rec = new Rectangle(i,j, landPlot,
                landPlot);
                rec.setPosition(i*landPlot+70*i+buffer,j*landPlot+70*j);
                rec.setFillColor(new Color(139,69,19));
                lands.add(rec);
                rec.setStrokeColor(Color.red);
                rec.setStrokeWidth(5);
                
            }
        }
        
    }

    public void unLock() {
        for (Rectangle b : lands) {
            b.setStrokeColor(Color.red);
        }
        
    }

   

    public List<Rectangle> getLands() {
        return lands;
    }

    
    public void addToCanvas(CanvasWindow canvas) {
        for (Rectangle b : lands) {
            canvas.add(b);
        }
    }

    public void setColor(Rectangle rec){

    }

    
}

