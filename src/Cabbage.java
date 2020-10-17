import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.CanvasWindow;

public class Cabbage implements Plant {

    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private int price = 20;
    private Image cabbage;

    public Cabbage() {
        cabbage = new Image(0, 0, "cabbage.png");
        cabbage.setMaxHeight(50);
        cabbage.setMaxWidth(40);
        graphics.add(cabbage);
    }

    public void growLarger() {
        // makes the plant grow larger
    }

    public boolean maxSize() {
        // check if plant is at maximum size
        return true;
    }

    public void setPosition(double x,double y){
        cabbage.setCenter(x,y);
    }

    public int getPrice() {
        return price;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(cabbage);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(cabbage);
    }
}
