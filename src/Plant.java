import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.GraphicsGroup;
import java.awt.Color;

public class Plant {
    Ellipse plant;
    private int price;

    public Plant(Color color, double x, double y, int price){
        plant = new Ellipse(x, y, 10, 10);
        this.price=price;
    }
    
    public void growLarger(){
        //makes the plant grow larger
    }

    public boolean maxSize(){
        //check if plant is at maximum size
        return true;
    }

    public int getPrice() {
        return price;
    }

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(plant);
    }

    public void removeFromCanavas(CanvasWindow canvas){
        canvas.remove(plant);
    }
}