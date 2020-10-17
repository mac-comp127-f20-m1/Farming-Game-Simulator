import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.CanvasWindow;

public class Orange implements Plant {

    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private int price;
    private Image orange;

    public Orange() {
        orange = new Image(0, 0, "orange.png");
        orange.setMaxWidth(40);
        orange.setMaxHeight(50);
        graphics.add(orange);
    }

    public void growLarger() {
        // makes the plant grow larger
    }

    public boolean maxSize() {
        // check if plant is at maximum size
        return true;
    }

    public void setPosition(double x,double y){
        orange.setCenter(x,y);
    }

    public int getPrice() {
        return price;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(orange);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(orange);
    }
}


